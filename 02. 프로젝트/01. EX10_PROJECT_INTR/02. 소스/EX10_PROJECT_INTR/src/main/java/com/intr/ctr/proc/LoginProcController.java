package com.intr.ctr.proc;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.svc.proc.LoginProcService;

@Controller
public class LoginProcController {
	//
	@Autowired
	HttpSession session;
	
	@Autowired
	LoginProcService loginProcService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* 명칭 : intrLoginProc1010
	 * 작성자 : 김태현
	 * 작성일자 : 2022.11.16
	 * 내용 : 로그인 처리
	 */
	@RequestMapping("/intrLoginProc1010.do")
	@ResponseBody
	public String intrLoginProc1010(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 로그인 처리
			//-------------------------------------------------------------------------------------------
			defaultStr = loginProcService.intrLoginProc101010(model, paramMap);	
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 로그인 처리 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return defaultStr;
	}
	
	/* 명칭 : intrLoginProc1020
	 * 작성자 : 김태현
	 * 작성일자 : 2022.11.20
	 * 내용 : 기초데이터 업로드
	 */
	@RequestMapping("/intrLoginProc1020.do")
	@ResponseBody
	public String intrLoginProc1020(Model model, @RequestParam HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 기초데이터 업로드
			//--------------------------------------------------------------------------------------------
			defaultStr = loginProcService.intrLoginProc102010(model, paramMap, request);	
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 기초데이터 업로드 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return defaultStr;
	}
	
	/* 명칭 : intrLoginProc1030
	 * 작성자 : 김태현
	 * 작성일자 : 2022.11.26
	 * 내용 : 로그아웃 처리
	 */
	@RequestMapping("/intrLoginProc1030.do")
	public String intrLoginProc1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 세션 제거
			//--------------------------------------------------------------------------------------------
			if(session.getAttribute("empVO")!=null) {
				session.removeAttribute("empVO");
			}
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 로그아웃 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return "redirect:/";

	}

}
