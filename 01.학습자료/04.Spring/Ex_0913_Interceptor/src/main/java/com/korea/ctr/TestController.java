package com.korea.ctr;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.korea.service.TestService;
import com.korea.vo.TestVO;

@Controller
public class TestController {
	//
	public static final String VIEW_PATH = "/WEB-INF/views/test/";
	//
	@Autowired
	TestService test_service;
	
	@Autowired
	HttpSession session;
	
	// 로그인 테스트 화면
	@RequestMapping(value= {"/","/test_login.do"})
	public String testLogin(Model model) throws Exception {
		//
		return VIEW_PATH + "test_login.jsp";
	}
	
	
	// 로그인 처리
	@RequestMapping("/test_check.do")
	@ResponseBody
	public String testCheck(Model model, TestVO vo) throws Exception{
		//
		String resStr = ""; // 결과 값을 담을 JSON 형태의 문자열
		
		// 검색
		resStr = test_service.testServiceCheck(model, vo);
		return resStr;
	}
	
	// 메인 화면
	@RequestMapping("/test_main.do")
	public String testMain(Model model) throws Exception {
		
		return VIEW_PATH + "test_main.jsp";
	}
	
	// 로그아웃 처리
	@RequestMapping("/test_logout.do")
	public String testLogout(HttpSession session) throws Exception{
		// 세션 제거
		session.removeAttribute("loginVO");
		// 로그인 정보 세션 삭제 후 로그인 화면으로 이동
		return "redirect:test_login.do";
	}
}