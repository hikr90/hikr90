package com.intr.ctr.inqy;


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

import com.intr.constant.IntrConstant;
import com.intr.svc.inqy.CoreInqyService;
import com.intr.svc.inqy.LoginInqyService;
import com.intr.vo.EmpVO;

@Controller
public class LoginInqyController {
	//
	@Autowired
	LoginInqyService loginInqyService;
	
	@Autowired
	CoreInqyService coreInqyService;
	
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
			&& !returnUrl.equals("/intr/")	
			&& empInfo==null) {
				// ALERT 호출
				response.setContentType("text/html; charset=UTF-8");
	            PrintWriter pw = response.getWriter();
	            pw.println("<script>alert('로그인 정보가 없습니다.');</script>");
	            pw.flush(); 	
			}
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 로그인 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConstant.VIEW_PATH_LOGIN + IntrConstant.INTR_LOGIN_INQY_1010;
	}

	/* 명칭 : intrMainInqy1020
	 * 작성자 : 김태현
	 * 작성일자 : 2022.11.26
	 * 내용 : 사용자 메인 화면 이동
	 */
	@RequestMapping("/intrMainInqy1020.do")
	public String intrMainInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 세션 저장
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101020("0");
			
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 사용자 메인 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConstant.VIEW_PATH_MAIN + IntrConstant.INTR_MAIN_INQY_1010;
	}

	/* 명칭 : intrMainInqy1030
	 * 작성자 : 김태현
	 * 작성일자 : 2022.11.26
	 * 내용 : 관리자 메인 화면 조회
	 */
	@RequestMapping("/intrMainInqy1030.do")
	public String intrMainInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 세션 저장
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101020("1");

			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 메인 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConstant.VIEW_PATH_MAIN + IntrConstant.INTR_MAIN_INQY_2010;
	}

}
