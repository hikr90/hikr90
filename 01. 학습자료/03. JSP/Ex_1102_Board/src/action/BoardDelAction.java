package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import vo.BoardVO;

/**
 * Servlet implementation class BoardDelAction
 */
@WebServlet("/board/del.do")
public class BoardDelAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 삭제하는데 필요한 파라미터 수신 (IDX, PWD)
		int idx = Integer.parseInt(request.getParameter("idx"));
		String pwd = request.getParameter("pwd");
		
		// 삭제가 가능한지 비번을 불러와서 확인
		BoardDAO dao = BoardDAO.getInstance();
		
		// SELECTONE메소드는 이미 있지만 IDX만 받는것만 있으니까 오버 로딩해서 두개 받는 SELECTONE도 만든다.
		BoardVO baseVO = dao.selectone(idx, pwd);
		
		// JSON과 JSON에 담는 결과 변수 생성
		String resultStr = "";
		String result = "no";
		
		// 삭제가 불가능한 경우
		if(baseVO==null) {
			resultStr = String.format("[{'res':'%s'}]", result);
			response.getWriter().print(resultStr);
			// 삭제가 불가능하므로 더이상 진행되지 않도록 RETURN
			return;
		}
		
		// 삭제가 가능한 경우, 지워진 것처럼 보이도록 내용을 수정
		baseVO.setSubject("삭제된 게시물입니다.");
		baseVO.setName("unknown");
		
		// UPDATE를 통해서 DB에서 삭제된 것처럼 보이게한다.
		int res = dao.del_update(baseVO); 
		
		// 업데이트가 완료되면 확실하게 삭제 유무를 알 수 있으니 RESULTSTR에 결과를 담아준다.
		if(res==1) {
			result = "yes";
		}
		
		resultStr = String.format("[{'res':'%s'}]", result);
		response.getWriter().print(resultStr);
	}
}
