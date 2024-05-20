package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/login.do")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		request.setCharacterEncoding("utf-8");
		//
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// 아이디 중복 확인
		MemberVO user = MemberDAO.getInstance().selectOne(id);
		
		// 아이디가 일치하지 않을 경우 결과를 담아줄 변수 생성
		String param = "";
		String resultStr = "";
		
		// 아이디 확인
		if(user==null) {
			param = "no_id";
			resultStr = String.format("[{'param':'%s'}]", param);
			response.getWriter().print(resultStr);
			return;
		}
		
		// 비밀번호 확인 
		if(!user.getPwd().equals(pwd)) {
			param = "no_pwd";
			resultStr = String.format("[{'param':'%s'}]", param);
			response.getWriter().print(resultStr);
			return;
		}
		
		/* HttpSession
		 * 	- 세션에 저장하는 인터페이스
		 * 	- request는 서블릿 시작 시 객체 생성없이 자동으로 실행되는 내장객체이다. (평소에는 NULL로 메모리 할당을 받지 않음)
		 * 	- getSession은 현재 세션정보를 가져오는 메소드로 메모리 할당이 필요하다.
		 * 	- 세션 객체가 생성되면 setAttribute를 통해서 유저 정보를 세션에 저장한다.
		 * 
		 * 		메소드
		 * 			(1) getSession()
		 * 				- request.getSession의 방식으로 요청
		 * 				- 객체에 지정된 세션 객체를 생성
		 * 
		 * 			(2) getSession(Boolean create)
		 * 					- true : 현재 세션이 존재하는 경우 세션 리턴, 없으면 새로 생성 (default)
		 * 					- false : 현재 세션이 존재하는 경우 세션 리턴, 없으면 NULL 리턴
		 * 
		 * 			(3) setAttribute(String name, Object value)
		 * 					- name의 명칭으로 value데이터 저장
		 * 
		 * 			(4) getAttribute(String name)
		 * 					- name의 명칭으로 value데이터 조회
		 * 
		 * 			(5) setMaxInactiveInterval(int second)
		 * 					- 세션의 유지시간 지정
		 * 					- 파라미터는 초단위이며 기본 값은 30분이다.
		 * 					- 60 * 60 (한 시간)
		 * 
		 * 			(6) removeAttribute(String name)
		 * 					- name의 명칭인 데이터 기준 삭제
		 */
		HttpSession session = request.getSession();
		session.setAttribute("user", user); 
		session.setMaxInactiveInterval(60*60);
		
		// 로그인은 정상처리되었으므로 콜백 함수로 파라미터를 보내준다.
		param = "clear";
		resultStr = String.format("[{'param':'%s'}]", param);
		response.getWriter().print(resultStr);
	}
}
