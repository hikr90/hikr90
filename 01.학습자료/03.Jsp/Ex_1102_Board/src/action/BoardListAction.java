package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.Common;
import dao.BoardDAO;
import util.Paging;
import vo.BoardVO;

/**
 * Servlet implementation class BoardListAction
 */
@WebServlet("/board/list.do")
public class BoardListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 페이징 처리
		int nowPage = 1;
		String page = request.getParameter("page");
		
		// - 페이지가 NULL이거나 비어있는 경우 첫 실행으로 판단
		// - 페이지가 비어있지 않은 경우 nowPage에 파라미터에서 받아온 page 값을 대입한다.
		if(page!=null && !page.isEmpty()) {
			nowPage = Integer.parseInt(page);
		}
		
		// - 한 페이지에 표시될 게시물의 시작과 끝 번호를 계산 (공식)
		int start = (nowPage - 1) * Common.Board.BLOCKLIST + 1; 
		int end = start + Common.Board.BLOCKLIST -1;
		
		// - 시작페이지와 종료 페이지 값을 저장
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start",start);
		map.put("end",end);
		
		// 목록 조회
		List<BoardVO> list = null;
		BoardDAO dao = BoardDAO.getInstance();
		list = BoardDAO.getInstance().selectlist(map);
		
		// 전체 게시물 수 가져오기
		int row_total = dao.getRowToal();
		
		// 페이징 메뉴 구성
		// 	- Paging클래스에 있는 getPaging 메소드를 통해서 페이징 메뉴 구성
		// 	- getPaging(현재 페이지의 url, 현재 페이지, 전체 게시물 수, 한페이지에서 보여줄 게시글 수, 한페이지에서 보여줄 페이지 넘버의 수)
		//	- Html 형식의 결과를 반환한다.
		String pageMenu = Paging.getPaging("list.do", nowPage, row_total, Common.Board.BLOCKLIST, Common.Board.BLOCKPAGE);
		//
		request.setAttribute("list", list);
		request.setAttribute("pageMenu", pageMenu);
		
		// 조회수 처리
		//	- 기본적으로 특정 페이지에 진입하면 조회수가 올라가나 새로고침을 통해서는 조회수가 오르지 않도록
		//	- 화면 진입 시 Show라는 세션 명칭에 값을 부여한다.
		//	- 값이 저장된 동안에는 화면에서 새로고침을 해도 조회수를 올리지 못하도록 막는다.
		//	- 목록으로 다시 나온 경우에는 세션의 값을 제거한다.
		request.getSession().removeAttribute("show");
		//
		RequestDispatcher disp = request.getRequestDispatcher("board_list.jsp");
		disp.forward(request, response);
	}
}
