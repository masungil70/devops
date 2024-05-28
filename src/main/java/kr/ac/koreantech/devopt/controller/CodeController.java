package kr.ac.koreantech.devopt.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.koreantech.devopt.model.CodeVO;
import kr.ac.koreantech.devopt.service.CodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/* 테스트 하는 방법
 * 코드목록얻기  
 * curl http://localhost:8090/codeList?grp_cd=lang
 * curl http://localhost:8091/codeList?grp_cd=lang
 * 코드 상세보기 
 * curl -X GET "http://localhost:8090/findByCd?grp_cd=lang&cd=java"
 * curl -X GET "http://localhost:8090/findByCd?grp_cd=lang&cd=jsp"
 * 코드 삭제보기 
 * curl -X GET "http://localhost:8090/deleteCode?grp_cd=lang&cd=java"
 * 코드목록얻기  
 * curl http://localhost:8090/codeList?grp_cd=lang
 * 코드 상세보기 
 * curl -X GET "http://localhost:8090/findByCd?grp_cd=lang&cd=java"
 * 
 * 
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class CodeController {

    private final CodeService codeService;
    
    @GetMapping("/codeList")
    public ResponseEntity<List<CodeVO>> codeList(CodeVO code){
    	log.info("CodeController.codeList-> code : {}", code);
        
        return ResponseEntity.status(HttpStatus.OK).body(
        		codeService.codeList(code));
    }
    
    @GetMapping("/findByCd")
    public ResponseEntity<CodeVO> findByCd(CodeVO code){
    	log.info("CodeController.findByCd-> code : {}", code);
        CodeVO result = codeService.findByCd(code);
        return ResponseEntity.status(result != null ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(result);
    }
    
    @GetMapping("/deleteCode")
    public ResponseEntity<Integer> deleteCode(@RequestParam(name="grp_cd") String grp_cd, @RequestParam(name="cd") String cd) throws Exception {
    	log.info("CodeController.deleteCode-> grp_cd : {}, cd : {}", grp_cd, cd);
        return ResponseEntity.status(HttpStatus.OK).body(
        		codeService.deleteCode(CodeVO.builder().grp_cd(grp_cd).cd(cd).build()));
    }
}