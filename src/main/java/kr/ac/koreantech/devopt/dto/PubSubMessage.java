package kr.ac.koreantech.devopt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PubSubMessage {
	private String cacheName;
	private String grp_cd;
	private String cd;
	
	public static PubSubMessage of(String cacheName, String grp_cd) {
		return new PubSubMessage(cacheName, grp_cd, "");
	}

	public static PubSubMessage of(String cacheName, String grp_cd, String cd) {
		return new PubSubMessage(cacheName, grp_cd, cd);
	}
	
}
