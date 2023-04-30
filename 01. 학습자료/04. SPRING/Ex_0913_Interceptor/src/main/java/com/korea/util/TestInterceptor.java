package com.korea.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.korea.vo.TestVO;

public class TestInterceptor extends HandlerInterceptorAdapter{
	/*	인터셉터가 동작하는 클래스 	
			- SERVLET-CONTEXT에서 지정한 MVC:MAPPING PATH에 따라서
			
			# 인터셉터 관련 메소드
				- PREHANDLE : 컨트롤러 실행 전 호출
				- POSTHANDLE : 컨트롤러 실행 후 DISPATCHERSERVLET이 뷰로 보내기 전 호출
				- AFTERCOMPLETION : 뷰가 수행되고 난 뒤 호출
				
			# PREHANDLE의 리턴값은 BOOLEAN타입으로 반환 값에대한 처리는 아래와 같다.
				- TRUE : 컨트롤러 맵핑 주소로 이동
				- FALSE : 이동하지 않음
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
			response.sendRedirect("test_login.do");
			return resYn;
			
		}
		
		// 
		System.out.println("세션 정보 존재 : "+resYn);
		return resYn;
	}
}
