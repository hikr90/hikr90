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
		
		/*	페이징 처리 
				nowPage는 현재 페이지로서 다른 JSP 페이지에서 DML등의 작업이 진행되었을 경우 동일한 페이지에 머무를 수 있도록 유지하기위한 변수명이다.
				
				PAGE변수는 타 PAGE에서 어느 페이지인지에대한 정보를 담는 변수로서, 
				첫 실행등의 상황에서는 값이 존재하지 않으므로 처음에는 유무를 파악하기위해서 NULL체크를 위해서 String으로 받는다. 
		*/
		int nowPage = 1;
		String page = request.getParameter("page");
		
		// PAGE가 NULL이거나 공백인 경우 첫 실행이라고 판단하고 NOWPAGE의 숫자인 1페이지를 보여주는 것으로 지정
		// 그렇지 않는 경우 nowPage에 파라미터로 받아온 page변수의 값을 대입하여 해당 페이지로 돌아가도록 지정
		if(page!=null && !page.isEmpty()) {
			nowPage = Integer.parseInt(page);
		}
		
		// 한 페이지에 표시될 게시물의 시작과 끝 번호를 계산 (공식)
		int start = (nowPage - 1) * Common.Board.BLOCKLIST + 1; 
		int end = start + Common.Board.BLOCKLIST -1;
		
		// HASH MAP으로 SELECTLIST(START,END)를 보내주자
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start",start);
		map.put("end",end);
		
		// NOWPAGE에 따라서 글 목록을 받아올 수 있도록 SELECTLIST 준비
		List<BoardVO> list = null;
		BoardDAO dao = BoardDAO.getInstance();
		
		// 페이징에 따라서 전체 목록 가져오기 (DAO에 존재하는 MAP을 파라미터로 받는 오버로딩된 SELECTLIST 동작)
		list = BoardDAO.getInstance().selectlist(map);
		
		// 전체 게시물 수 가져오기
		int row_total = dao.getRowToal();
		
		// PAGING클래스에 있는 GETPAGING메소드를 통해서 페이지 메뉴 생성
		// (현재 페이지의 URL, 현재 페이지, 전체게시물 수, 한페이지에서 보여줄 게시글 수, 한페이지에서 보여줄 페이지 메뉴의 수)
		// 해당 메소드는 HTML의 형식으로 값을 리턴한다.
		String pageMenu = Paging.getPaging("list.do", nowPage, row_total, Common.Board.BLOCKLIST, Common.Board.BLOCKPAGE);
		
		// JSP 페이지에 LIST값과 PAGE MENU를 같이 뿌리도록 REQUEST SCOPE에 저장한다. (BINDING)
		request.setAttribute("list", list);
		request.setAttribute("pageMenu", pageMenu);
		
		// 조회수 처리
		// 		기본적으로 특정 페이지에 들어가면 조회수가 올라가지만, 페이지에서 새로고침을 해서 조회수를 올릴 수 없도록 "SHOW"라는 명칭의 SESSION SCOPE영역에 값을 저장하고
		// 		값이 저장되어있는 동안에는 게시물 페이지에서는 조회수를 올리지 못하게 해두는데
		//		전체 목록으로 나오게된 뒤 다시 게시물 상세보기하면 조회수가 올라가야하기에 SHOW 영역을 삭제한다.
		request.getSession().removeAttribute("show");
	
		// 포워딩
		RequestDispatcher disp = request.getRequestDispatcher("board_list.jsp");
		disp.forward(request, response);
	}
}
