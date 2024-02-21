package com.intr.ctr;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intr.svc.MainService;
import com.intr.svc.TempService;
import com.intr.svc.UtilService;

@Controller
public class UtilController {
	//
	@Autowired
	TempService tempService;

	@Autowired
	MainService mainService;
	
	@Autowired
	UtilService utilService;

	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* 명칭 : intrFileProc1020
	 * 작성자 : 김태현
	 * 작성일자 : 2022.12.17
	 * 내용 : 파일 다운로드
	 */
	@RequestMapping("/intrFileProc1020.do")
	public void intrFileProc1020(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 파일 다운로드
			//--------------------------------------------------------------------------------------------
			utilService.intrFileProc102010(model, paramMap, request, response);

			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 파일 다운로드 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	/* 명칭 : intrFileProc1030
	 * 작성자 : 김태현
	 * 작성일자 : 2023.06.06
	 * 내용 : 전체 다운로드
	 */
	@RequestMapping("/intrFileProc1030.do")
	public void intrFileProc1030(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 전체 다운로드
			//--------------------------------------------------------------------------------------------
			utilService.intrFileProc103010(model, paramMap, request, response);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 파일 다운로드 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}

	/* 명칭 : intrMailProc1010
	 * 작성자 : 김태현
	 * 작성일자 : 2023.05.14
	 * 내용 : 메일 전송
	 */
	@RequestMapping(value="/intrMailProc1010.do", method=RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String intrMailProc1010(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메일 전송
			//--------------------------------------------------------------------------------------------
			defaultStr = utilService.intrMailProc101010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 메일 전송 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
}
