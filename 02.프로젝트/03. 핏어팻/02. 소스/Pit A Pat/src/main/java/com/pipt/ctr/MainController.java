package com.pipt.ctr;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pipt.svc.MainService;
import com.pipt.svc.MemberService;
import com.pipt.utils.Path;

@Controller
public class MainController {
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;
	
	@Autowired
	MainService mainService;

	@Autowired
	MemberService memberService;
	
	// 메인 화면 조회
	@RequestMapping(value={"/","/piptMainInqy1010.do"})
	public String piptMainInqy1010(Model model) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메인 화면 조회
			//--------------------------------------------------------------------------------------------
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 메인 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH + "pipt_main_inqy_1010.jsp";
	}
	
	// 로그인 화면 조회
	@RequestMapping("/piptLoginInqy1010.do")
	public String piptLoginInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 로그인 화면 조회
			//--------------------------------------------------------------------------------------------
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 로그인 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.LOGIN_PATH + "pipt_login_inqy_1010.jsp";
	}
	
	// 로그인 처리
	@RequestMapping("/piptLoginInqy1011.do")
	public String piptLoginInqy1011(Model model, HashMap<String, Object> paramMap, HttpServletResponse response) throws Exception {
		//
		String returnUrl = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 회원정보 조회
			//--------------------------------------------------------------------------------------------
			paramMap = new HashMap<String, Object>();
			returnUrl = memberService.piptMemberInqy1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 로그인 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.LOGIN_PATH + returnUrl;
	}

	// 회원가입 화면 조회
	@RequestMapping("/piptLoginInqy1020.do")
	public String piptLoginInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 회원가입 화면 조회
			//--------------------------------------------------------------------------------------------
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 회원가입 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.LOGIN_PATH + "pipt_login_inqy_1020.jsp";
	}
	
	// 아이디 중복 체크
	@RequestMapping("/piptLoginProc1010.do")
	@ResponseBody
	public String piptLoginProc1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 아이디 중복 체크
			//--------------------------------------------------------------------------------------------
			defaultStr = memberService.piptMemberProc1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 아이디 중복 체크 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// 회원가입 처리
	@RequestMapping("/piptLoginProc1020.do")
	public String piptLoginProc1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 회원가입 처리
			//--------------------------------------------------------------------------------------------
			memberService.piptMemberProc1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 회원가입 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return "redirect:piptMainInqy1010.do";
	}
	
	// 로그아웃 처리
	@RequestMapping("/piptLoginProc1030.do")
	public String piptLoginProc1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 세션 제거
			//--------------------------------------------------------------------------------------------
			if(session.getAttribute("memberVO")!=null) {
				session.removeAttribute("memberVO");
			}
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 로그아웃 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return "redirect:/";
	}
	
	// 아이디 찾기 화면 조회
	@RequestMapping("/piptLoginInqy1030.do")
	public String piptLoginInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 아이디 찾기 화면 조회
			//--------------------------------------------------------------------------------------------
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 아이디 찾기 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.LOGIN_PATH + "pipt_login_inqy_1030.jsp";
	}
	
	// 아이디 찾기
	@RequestMapping("/piptLoginProc1040.do")
	@ResponseBody
	public String piptLoginProc1040(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 아이디 찾기
			//--------------------------------------------------------------------------------------------
			defaultStr = memberService.piptMemberProc1040(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 아이디 찾기 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// 비밀번호 찾기 화면 조회
	@RequestMapping("/piptLoginInqy1040.do")
	public String piptLoginInqy1040(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 비밀번호 찾기 화면 조회
			//------------------------------------------------	--------------------------------------------
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 비밀번호 찾기 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.LOGIN_PATH + "pipt_login_inqy_1040.jsp";
	}
		
	// 비밀번호 찾기
	@RequestMapping("/piptLoginProc1050.do")
	@ResponseBody
	public String piptLoginProc1050(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 비밀번호 찾기
			//--------------------------------------------------------------------------------------------
			defaultStr = memberService.piptMemberProc1050(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 비밀번호 찾기 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
}
