package com.intr.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.intr.vo.EmpVO;

public class Interceptor extends HandlerInterceptorAdapter{
		
	// 세션 여부 체크
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//
		boolean resYn = true; // 리턴 값 (TRUE : 컨트롤러로 이동, FALSE : 이동하지 않음)
		/*
		 * String returnUrl = request.getRequestURI(); // 요청 객체의 맵핑 주소 // HttpSession
		 * session = request.getSession(); EmpVO empInfo =
		 * (EmpVO)session.getAttribute("empVO");
		 * 
		 * // Login 관련 팝업 if(returnUrl.equals("/intr/") || returnUrl.contains("Login")
		 * || returnUrl.contains("intrPopupInqy102")) { return resYn; }
		 * 
		 * // 리소스 경로인 경우 제외 // 화면 구성에 사용되는 CSS 및 자바스크립트 파일이 인터셉터 제어로 제대로 로드되지 못하는 현상을 방지
		 * if(returnUrl.contains("/resources")) { return resYn; }
		 * 
		 * // Login이 아닌 경우 if(!returnUrl.equals("/intr/") // 첫 화면 &&
		 * !returnUrl.contains("Login") // 로그인 관련 && empInfo==null) { // 세션 정보 미존재 resYn
		 * = false; response.sendRedirect("intrMainInqy1010.do"); return resYn; }
		 */
		
		// 세션 정보 존재
		return resYn;
	}
}
