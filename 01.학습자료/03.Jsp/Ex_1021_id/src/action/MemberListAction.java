package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class MemberListAction
 */
// member로 할 경우 실행은 되지만 나중에 다른 곳에서 url이 member_list가 되어있는 경우 오류가 난다. 
@WebServlet("/member/member_list.do")
public class MemberListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 자바 코드 입력공간으로 스크립트릿에서 하던 작업을 여기서 한다.
		// 회원 목록 가져오기
		List<MemberVO> list = MemberDAO.getInstance().selectList();
		
		
		// list의 정보를 jsp로 보내줘야한다.
		// body에서 출력처리하는 것이 편하기 때문이다.
		
		// requestScope를 사용한다. request는 두가지 페이지에서 공유가 가능하다.
		// 어디서 쓸 것인지 결정하는 작업을 바인딩, 어디서에 같이 공유할것인지를 포워딩이라고 한다.
		
		// request영역에 list객체를 바인딩
		request.setAttribute("list", list);
		
		// 위에서 바인딩된 객체를 el표기법으로 사용할 페이지로 포워딩
		// set으로 list를 저장했는데 그것을 disp에 주는데 ()안에서 쓸 수 있게 해준다.
		RequestDispatcher disp = request.getRequestDispatcher("member_list.jsp");
		
		// 값을 가진 상태로 가져가야하므로 foward를 쓴다. 지금 여기식에서는 요청받은 request : list를 가지고 member_list.jsp에서 응답한다.  
		// member_list로 request(list)를 넘겼기에 여기서 실행해도 member_list화면이 뜬다.
		disp.forward(request, response);
	
	
		

	
	}

}
