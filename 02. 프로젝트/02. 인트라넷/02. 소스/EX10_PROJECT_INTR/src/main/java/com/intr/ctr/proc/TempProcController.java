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
import com.intr.svc.proc.TempProcService;

@Controller
public class TempProcController {
	//
	@Autowired
	TempProcService tempProcService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* 명칭 : intrTempProc1010
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.09
	 * 내용 : 템플릿 등록 처리
	 */
	@RequestMapping("/intrTempProc1010.do")
	@ResponseBody
	public String intrTempProc1010(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 템플릿 등록
			//--------------------------------------------------------------------------------------------
			defaultStr = tempProcService.intrTempProc101010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 템플릿 등록 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	/* 명칭 : intrTempProc1020
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.13
	 * 내용 : 템플릿 수정 처리
	 */
	@RequestMapping("/intrTempProc1020.do")
	@ResponseBody
	public String intrTempProc1020(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 템플릿 수정
			//--------------------------------------------------------------------------------------------
			defaultStr = tempProcService.intrTempProc102010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 템플릿 수정 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

	/* 명칭 : intrTempProc1030
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.13
	 * 내용 : 템플릿 삭제 처리
	 */
	@RequestMapping("/intrTempProc1030.do")
	@ResponseBody
	public String intrTempProc1030(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 템플릿 삭제
			//--------------------------------------------------------------------------------------------
			defaultStr = tempProcService.intrTempProc103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 템플릿 삭제 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

}
