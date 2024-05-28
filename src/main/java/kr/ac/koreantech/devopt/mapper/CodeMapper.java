package kr.ac.koreantech.devopt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.ac.koreantech.devopt.model.CodeVO;


@Mapper
@Repository("codeMapper")
public interface CodeMapper {

	List<CodeVO> codeList(CodeVO code);
	CodeVO findByCd(CodeVO code);
	int insertCode(CodeVO code);
	int updateCode(CodeVO code);
	int deleteCode(CodeVO code);
	
}

