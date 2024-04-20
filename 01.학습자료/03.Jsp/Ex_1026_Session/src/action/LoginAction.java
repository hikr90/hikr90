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
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// 아이디가 중복되는지 먼저 확인
		MemberVO user = MemberDAO.getInstance().selectOne(id);
		
		// 아이디가 일치하지 않을 경우 결과를 담아줄 변수 생성
		String param = "";
		String resultStr = "";
		
		// 아이디 확인
		if(user==null) {
			param = "no_id";
			resultStr = String.format("[{'param':'%s'}]", param);
			response.getWriter().print(resultStr);
			// 아이디가 틀렸으니 하단의 비밀번호정보까지 확인할 필요없으니 return으로 강제 종료
			return;
		}
		
		// 비밀번호 확인 
		if(!user.getPwd().equals(pwd)) {
			param = "no_pwd";
			resultStr = String.format("[{'param':'%s'}]", param);
			response.getWriter().print(resultStr);
			return;
		}
		
		// 만약 다 통과해서 아이디와 비밀번호가 중복되지 않으면 session에 저장시켜서 탭이 살아있는 한 계속 정보가 유지되게 하자
		// 유저의 정보는 세션에 저장하는 경우가 대부분이지만 세션은 서버상의 메모리를 사용하기 때문에 많은 데이터, 너무 자주 사용할 시 브라우저를 느리게 만들기 때문에 반드시 필요한 곳에서 사용할 수 있도록 해야한다.
		// HttpSession 세션에 저장하는 인터페이스
		// 현재 페이지의 정보가 request에 담겨있는데 session의 영역에 저장할 준비 (50분)
		// requset는 서블렛 시작시 객체 생성 없이 자동으로 실행되는 객체인데 평상시에는 null로 메모리를 잡아먹지 않는다.
		// getsession이 실행되는 순간 session영역을 사용하기 위해서 메모리 할당이 필요하므로 객체가 생성되고
		// 이 session 객체가 생성되면서 그 후 session.set을 통해서 user정보가 저장된다.
		HttpSession session = request.getSession(); // getsession을 하기위한 메모리할당 
		session.setAttribute("user", user); 
		
		// setMaxInactiveInterval : 세션 유지시간 (초 단위), 기본값은 30분
		session.setMaxInactiveInterval(60*60); // 60 * 60 : 한 시간
		
		
		// 로그인이 정상적으로 되었으니 콜백으로 로그인 잘 된 것으로 넘겨주자
		param = "clear";
		resultStr = String.format("[{'param':'%s'}]", param);
		response.getWriter().print(resultStr);
		
		
	}

}
