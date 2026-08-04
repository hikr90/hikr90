package com.intr.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.intr.vo.EmpVO;

public class Interceptor implements HandlerInterceptor {
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 요청 URI
		String requestURI = request.getRequestURI().substring(request.getContextPath().length());

		//  세션 체크 제외
		if (requestURI.equals("/") ||                                			 	// 첫화면
	        requestURI.equals("/intrMainInqy1010.do") ||             	// 로그인 화면으로 이동
	        requestURI.equals("/intrMainProc1010.do") ||             	// 로그인 처리
	        requestURI.equals("/intrPopupInqy1021.do") ||            	// 아이디 찾기
	        requestURI.equals("/intrPopupInqy1022.do") ||            // 비밀번호 찾기
	        requestURI.equals("/sendMail.do") ||            				// 메일 전송
	        requestURI.equals("/intrPopupInqy1023.do") ||            // 사원 정보 조회
	        requestURI.equals("/intrEmpProc1050.do") ||            	// 사원 비밀번호 수정 처리
	        requestURI.startsWith("/resources/") ||                  		// 정적 리소스
	        requestURI.startsWith("/error/") ||                      		// 에러 페이지
	        requestURI.startsWith("/ckeditor/")) {                   		// CKEditor
	        
	        // Controller 동작
	        return true; 
	    }
		
		// 세션 체크
		HttpSession session = request.getSession();
		EmpVO loginInfo = (EmpVO)session.getAttribute("empVO");
		
		if (loginInfo == null) {
            session.setAttribute("alertMsg", "세션 정보가 존재하지 않습니다.");
            response.sendRedirect(request.getContextPath() + "/intrMainInqy1010.do");
            return false;
        }
        // Controller 동작
        return true;
    }
	
	@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //
    }
	
	@Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
        //
    }
}
