package kr.ac.koreantech.devopt.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RedisPublisher {
    private final RedisTemplate<String, Object> redisTemplate;
    
    public void publish(ChannelTopic topic, String message) {
    	System.out.println("RedisTemplate.publish()  topic : " + topic +  " message = " + message);
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}