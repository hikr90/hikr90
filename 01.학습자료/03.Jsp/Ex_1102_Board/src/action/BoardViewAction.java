package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDAO;
import vo.BoardVO;

/**
 * Servlet implementation class BoardViewAction
 */
@WebServlet("/board/view.do")
public class BoardViewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 상세 보기 페이지로 이동하는 서블릿 (VIEW.DO?IDX=32)
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		// IDX에 해당하는 게시물 정보를 VO에 담아서 가져오기
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.selectone(idx);
		
		// 조회수 증가 (조회수의 의도적인 증가를 막는 SESSION영역)
		// show라는 세션영역은 저장한적이 없는데 가지고 올 경우 : 아직 안읽은 게시물이라고 판단한다.
		HttpSession session = request.getSession(); // 세션 영역 로드
		// SHOW 문자열이 NULL이면 읽어보지 않은 게시물
		// SHOW 문자열이 NULL이 아니라면 읽어본 게시물 
		String show = (String)session.getAttribute("show"); // 세션 영역에서 "SHOW" 명칭에 해당하는 키값의 데이터를 가져와서 show라는 문자열 공간에 저장한다. 세션은 문자열보다 공간이 더 크므로 문자열이라고 형변환을 해줘야한다.

		// 만약 문자열 SHOW가 NULL이라면 읽은적이 없는 게시물로 조회수가 오르면서 세션 SHOW영역에 값을 저장한다. (이 저장된 세션은 전체 목록 로드시에만 삭제되게 한다.)
		// 만약 문자열 SHOW가 NULL이 아니라면 아래의 IF문을 무시하여 조회수를 높이지 않는다.
		if(show==null) {
			dao.update_readhit(idx);
			// 세션 SHOW에 "HIT"이라는 값을 담는다. 홈페이지를 새로고침해도 SHOW는 이미 NULL이 아니므로 조회수는 증가하지 않는다. 
			session.setAttribute("show", "hit");
		}
				
		// BINDING & FORWARDING 
		request.setAttribute("vo", vo);
		
		RequestDispatcher disp = request.getRequestDispatcher("board_view.jsp");
		disp.forward(request, response);
	}
}