package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GogekDAO;
import vo.GogekVO;

/**
 * Servlet implementation class GogekListAction
 */
@WebServlet("/gogek/gogek_list.do")
public class GogekListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		response.setCharacterEncoding("utf-8");
		//
		String search = "all";
		String str_goaddr = request.getParameter("search");
		// 
		if(str_goaddr!=null && !str_goaddr.isEmpty()) {
			search = str_goaddr;
		}
		//
		List<GogekVO> list = null;
		//
		if(search.equals("all")) {
			list = GogekDAO.getInstance().select();
		}else {
			list = GogekDAO.getInstance().select(str_goaddr);
		}
		//
		request.setAttribute("list", list);
		RequestDispatcher disp = request.getRequestDispatcher("gogek_list.jsp");
		disp.forward(request, response);
	}
}
