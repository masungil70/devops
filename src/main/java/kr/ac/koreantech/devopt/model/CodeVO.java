package kr.ac.koreantech.devopt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CodeVO {
	private String grp_cd;
	private String cd;
	private String grp_cd_nm;
	private String cd_nm;
	private String make_date;
	private String use_yn;
}
