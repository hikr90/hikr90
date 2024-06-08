package com.intr.ctr;


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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intr.svc.AprvService;
import com.intr.svc.AuthService;
import com.intr.svc.BoardService;
import com.intr.svc.MainService;
import com.intr.svc.EmpService;
import com.intr.svc.TempService;
import com.intr.util.Jsp;
import com.intr.util.Path;

@Controller
public class MainController {
	//
	@Autowired
	BoardService boardService;
	
	@Autowired
	MainService mainService;
	
	@Autowired
	EmpService empService;

	@Autowired
	AprvService aprvService;

	@Autowired
	TempService tempService;

	@Autowired
	AuthService authService;
	
	@Autowired
	HttpSession session;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	// 로그인 화면 조회
	@RequestMapping(value={"/","/intrLoginInqy1010.do"})
	public String intrLoginInqy1010(Model model) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 로그인 권한 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1040(model);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 로그인 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_LOGIN + Jsp.INTR_LOGIN_INQY_1010;
	}

	// 사용자 메인 조회
	@RequestMapping("/intrMainInqy1020.do")
	public String intrMainInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 세션 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1030("0");
			
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 공지사항 조회
			//--------------------------------------------------------------------------------------------
			boardService.intrBoardInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 나의 기안 목록
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy1040(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 나의 결재 목록
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy1050(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 사용자 메인 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_MAIN + Jsp.INTR_MAIN_INQY_1010;
	}

	// 관리자 메인 조회
	@RequestMapping("/intrMainInqy1030.do")
	public String intrMainInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 세션 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1030("1");

			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 부서 사원 수 조회
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy1070(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 템플릿 목록 조회
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqy1030(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy1050(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 관리자 메인 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_MAIN + Jsp.INTR_MAIN_INQY_2010;
	}
	
	// 로그인 처리
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
			defaultStr = mainService.intrLoginProc1010(model, paramMap);	
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 로그인 처리 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return defaultStr;
	}
	
	// 로그아웃 처리
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
			logger.debug("Exception : 로그아웃 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return "redirect:/";

	}

}
