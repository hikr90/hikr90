package com.intr.ctr;


import java.io.PrintWriter;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.comm.Page;
import com.intr.comm.Path;
import com.intr.dao.EmpDao;
import com.intr.svc.AprvService;
import com.intr.svc.AuthService;
import com.intr.svc.BoardService;
import com.intr.svc.MainService;
import com.intr.svc.EmpService;
import com.intr.svc.TempService;
import com.intr.vo.EmpVO;

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
	
	/* 명칭 : intrLoginInqy1010
	 * 작성자 : 김태현
	 * 작성일자 : 2022.11.12
	 * 내용 : 로그인 화면 조회
	 */
	@RequestMapping(value={"/","/intrLoginInqy1010.do"})
	public String intrLoginInqy1010(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		String returnUrl = request.getRequestURI();
		HttpSession session = request.getSession();
		EmpVO empInfo = (EmpVO)session.getAttribute("empVO");
		//
		try {
			// LOGIN 제외 컨트롤러의 경우
			if(!returnUrl.contains("Login") 
			&& !returnUrl.equals("/intr/") && !returnUrl.equals("/")	
			&& empInfo==null) {
				// ALERT 호출
				response.setContentType("text/html; charset=UTF-8");
	            PrintWriter pw = response.getWriter();
	            pw.println("<script>alert('로그인 정보가 없습니다.');</script>");
	            pw.flush(); 	
			}

			//--------------------------------------------------------------------------------------------
			// 로그인 권한 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy104010(model);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 로그인 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_LOGIN + Page.INTR_LOGIN_INQY_1010;
	}

	/* 명칭 : intrMainInqy1020
	 * 작성자 : 김태현
	 * 작성일자 : 2022.11.26
	 * 내용 : 메인(사용자) 이동
	 */
	@RequestMapping("/intrMainInqy1020.do")
	public String intrMainInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 세션 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101020("0");
			
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 공지사항 조회
			//--------------------------------------------------------------------------------------------
			boardService.intrBoardInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 나의 기안 목록
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy103010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 나의 결재 목록
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy103011(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 사용자 메인 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_MAIN + Page.INTR_MAIN_INQY_1010;
	}

	/* 명칭 : intrMainInqy1030
	 * 작성자 : 김태현
	 * 작성일자 : 2022.11.26
	 * 내용 : 메인(관리자) 이동
	 */
	@RequestMapping("/intrMainInqy1030.do")
	public String intrMainInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 세션 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101020("1");

			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 부서 사원 수 조회
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy104010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 템플릿 목록 조회
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqy103010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy301020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 메인 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_MAIN + Page.INTR_MAIN_INQY_2010;
	}
	
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
			defaultStr = mainService.intrLoginProc101010(model, paramMap);	
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 로그인 처리 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
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
