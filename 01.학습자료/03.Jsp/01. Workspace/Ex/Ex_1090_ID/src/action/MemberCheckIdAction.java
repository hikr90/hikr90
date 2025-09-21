package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class MemberCheckIdAction
 */
@WebServlet("/member/check_id.do")
public class MemberCheckIdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		request.setCharacterEncoding("utf-8");
		//
		String id = request.getParameter("id");
		// - selectList : 목록 조회
		// - selectOne 	: 단건 조회
		MemberVO vo = MemberDAO.getInstance().selectOne(id);
		//
		String res = "no";
		// 
		if(vo==null) {
			res = "yes";
		}
		
		// Json 값을 통해서 결과를 콜백메소드로 전송
		response.setContentType("text/plain;charset=UTF-8");			// 한글 값을 위한 인코딩
		String resultStr = String.format("[{'result':'%s'},{'id':'%s'}]", res,id);
		response.getWriter().println(resultStr);
	}
}
