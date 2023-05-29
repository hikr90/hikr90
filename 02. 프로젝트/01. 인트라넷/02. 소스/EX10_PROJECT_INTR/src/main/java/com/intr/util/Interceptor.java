package com.intr.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.intr.vo.EmpVO;

public class Interceptor extends HandlerInterceptorAdapter{
		
	// ���� ���� üũ
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//
		boolean resYn = true; // ���� �� (TRUE : ��Ʈ�ѷ��� �̵�, FALSE : �̵����� ����)
		String returnUrl = request.getRequestURI(); // ��û ��ü�� ���� �ּ�
		//
		HttpSession session = request.getSession();
		EmpVO empInfo = (EmpVO)session.getAttribute("empVO");

		// �α��� ȭ��, �α��� ó��, �α׾ƿ� ��
		if(returnUrl.equals("/") 
			|| returnUrl.contains("/intrLoginInqy1010") 
			|| returnUrl.contains("/intrLoginProc1010")
			|| returnUrl.contains("/intrLoginProc1030.do")) {
			return resYn;
		}

		// ���ҽ� ����� ��� ����
		// ȭ�� ������ ���Ǵ� CSS �� �ڹٽ�ũ��Ʈ ������ ���ͼ��� ����� ����� �ε���� ���ϴ� ������ ����
		if(returnUrl.contains("/resources")) {
			return resYn;
		}

		//
		if(empInfo==null) {
			// ���� ���� ������
			resYn = false;
			response.sendRedirect("intrLoginInqy1010.do");
			return resYn;
		}
		
		// ���� ���� ����
		return resYn;
	}
}
