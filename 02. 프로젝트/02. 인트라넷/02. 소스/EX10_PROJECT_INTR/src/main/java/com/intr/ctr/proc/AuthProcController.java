package com.intr.ctr.proc;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intr.svc.proc.AuthProcService;
import com.intr.svc.proc.TempProcService;

@Controller
public class AuthProcController {
	//
	@Autowired
	AuthProcService authProcService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* 명칭 : intrAuthProc1010
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.26
	 * 내용 : 권한 등록 처리
	 */
	@RequestMapping("/intrAuthProc1010.do")
	@ResponseBody
	public String intrAuthProc1010(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 권한 등록
			//--------------------------------------------------------------------------------------------
			defaultStr = authProcService.intrAuthProc101010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 권한 등록 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	/* 명칭 : intrAuthProc1020
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.26
	 * 내용 : 권한 수정 처리
	 */
	@RequestMapping("/intrAuthProc1020.do")
	@ResponseBody
	public String intrAuthProc1020(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 공통코드 수정
			//--------------------------------------------------------------------------------------------
			defaultStr = authProcService.intrAuthProc102010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 권한 수정 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

	/* 명칭 : intrAuthProc1030
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.26
	 * 내용 : 권한 삭제 처리
	 */
	@RequestMapping("/intrAuthProc1030.do")
	@ResponseBody
	public String intrAuthProc1030(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 권한 삭제
			//--------------------------------------------------------------------------------------------
			defaultStr = authProcService.intrAuthProc103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 권한 삭제 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	/* 명칭 : intrAuthProc2010
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.28
	 * 내용 : 메뉴 권한 저장 처리
	 */
	@RequestMapping("/intrAuthProc2010.do")
	@ResponseBody
	public String intrAuthProc2010(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 권한 저장
			//--------------------------------------------------------------------------------------------
			defaultStr = authProcService.intrAuthProc201010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 메뉴 권한 저장 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	/* 명칭 : intrAuthProc3010
	 * 작성자 : 김태현
	 * 작성일자 : 2023.02.12
	 * 내용 : 사용자 권한 저장 처리
	 */
	@RequestMapping("/intrAuthProc3010.do")
	@ResponseBody
	public String intrAuthProc3010(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사용자 권한 저장
			//--------------------------------------------------------------------------------------------
			defaultStr = authProcService.intrAuthProc301010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 사용자 권한 저장 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

}
