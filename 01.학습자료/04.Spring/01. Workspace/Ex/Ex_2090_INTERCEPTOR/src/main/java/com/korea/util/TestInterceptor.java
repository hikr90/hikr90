package com.korea.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.korea.vo.TestVO;

public class TestInterceptor extends HandlerInterceptorAdapter{
	/*	인터셉터
	 * 		- 브라우저 요청 시, 메소드 호출 전후의 요청과 응답을 가로채어 개발자가 원하는 작업을 수행하도록하는 기능을 뜻한다.
	 * 		- 전후의 요청과 응답은 DispatcherServlet이 컨트롤러의 동작 전후의 요청과 응답을 뜻한다.
	 * 		- 해당 기능은 HandlerInterceptorAdapter 클래스를 상속함으로서 사용한다.
	 * 		- 쿠키 제어 등의 작업에 사용된다.
	 * 
	 * 		메소드
	 * 			(1) preHandle : 컨트롤러 실행 전 호출되는 메소드로 참거짓을 반환한다.
	 * 				(1.1) true : 컨트롤러 맵핑 주소로 이동
	 * 				(1.2) false : 이동하지 않음
	 * 
	 * 			(2) postHandle : 컨트롤러 실행 후 DispatcherServlet이 뷰로 보내기 전 호출되는 메소드로 참거짓을 반환한다.
	 * 			(3) afterCompletion : 뷰가 수행되고난 뒤 호출되는 메소드로 참거짓을 반환한다.
 	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 
		boolean resYn = true; // 리턴 값
		String resUrl = request.getRequestURI(); // 요청 객체의 맵핑 주소
		//
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("loginVO");

		// 로그인 화면, 로그인 처리인 경우 제외
		if(resUrl.contains("/test_login") || resUrl.contains("/test_check")) {
			return resYn;
		}

		// 리소스 경로인 경우 제외
		// 화면 구성에 사용되는 CSS 및 자바스크립트 파일이 인터셉터 제어로 제대로 로드되지 못하는 현상을 방지
		if(resUrl.contains("/resources")) {
			return resYn;
		}

		//
		if(obj==null) {
			//
			resYn = false;
			System.out.println("세션 정보 미존재 : "+resYn);
			response.sendRedirect("test.do");
			return resYn;
			
		}
		
		// 
		System.out.println("세션 정보 존재 : "+resYn);
		return resYn;
	}
}
