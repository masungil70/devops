package kr.ac.koreantech.devopt.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import kr.ac.koreantech.devopt.model.CodeVO;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CodeMapperTest {
    @Autowired
    private CodeMapper codeMapper;

    @Test
    @DisplayName("lang 그룹 코드에 대한 목록")
    public void testCodeList_lang() {
        CodeVO code = new CodeVO();
        code.setGrp_cd("lang");

        List<CodeVO> codeList = codeMapper.codeList(code);

        assertNotNull(codeList);
        assertEquals(3, codeList.size());
    }

    @Test
    @DisplayName("empty 그룹 코드에 대한 목록")
    public void testCodeList_empty() {
        CodeVO code = new CodeVO();
        code.setGrp_cd("empty");

        List<CodeVO> codeList = codeMapper.codeList(code);

        assertNotNull(codeList);
        assertEquals(0, codeList.size());
    }

}