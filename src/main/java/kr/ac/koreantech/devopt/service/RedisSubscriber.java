package kr.ac.koreantech.devopt.service;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.ac.koreantech.devopt.dto.PubSubMessage;

@Service
public class RedisSubscriber implements MessageListener {

    private final RedisTemplate<String, Object> redisTemplate;
    private final CacheManager cacheManager;
    
	private ObjectMapper objectMapper = new ObjectMapper();

    public RedisSubscriber(final RedisTemplate<String, Object> redisTemplate
    					 , final CacheManager cacheManager
    					 , final RedisMessageListenerContainer redisMessageListener) {
        this.redisTemplate = redisTemplate;
        this.cacheManager = cacheManager;
        
    	System.out.println("RedisSubscriber.RedisSubscriber() redisTemplate = " + redisTemplate + "   cacheManager : " + cacheManager + "  redisMessageListener : " + redisMessageListener);

        ChannelTopic codeInvalidationChannel = new ChannelTopic("code-invalidation");
        redisMessageListener.addMessageListener(this, codeInvalidationChannel);
    }

    @Override
    public void onMessage(final Message message, final byte[] pattern) {
    	try {
        	//redis의 pub/sub을 통해서 전송하는 문자열 메시지가 수신시에는 문자열의 시작과 끝에 이중따음표(") 문자가 포함된다
        	//그래서 앞뒤의 이중따음표(") 문자를 제거한다
    		String body = redisTemplate.getStringSerializer().deserialize(message.getBody());
    		body = StringEscapeUtils.unescapeJava(body.substring(1, body.length()-1));
    		System.out.println("body->[" + body + "]");
	    	PubSubMessage pubSubMessage = objectMapper.readValue(body, PubSubMessage.class);
	
	    	System.out.println("key->" + pubSubMessage);
	    	//케시에 저장된 코드 목록을 제거 한다 
	    	cacheManager.getCache(pubSubMessage.getCacheName()).evict(pubSubMessage.getGrp_cd() + pubSubMessage.getCd());
	    	
	    	if (!StringUtils.isEmpty(pubSubMessage.getCd())) {
	    		//코드에 대한 값이 존재하면 그룹에 대한 cache 정보도 제거한다  
		    	cacheManager.getCache("codeCacheInfo").evict(pubSubMessage.getGrp_cd());
	    	}
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}