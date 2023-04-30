package action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.PhotoDAO;
import vo.PhotoVO;

/**
 * Servlet implementation class PhotoInsertAction
 */
@WebServlet("/photo/insert.do")
public class PhotoInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String web_path = "/upload/";
		ServletContext application = request.getServletContext();
		
		String path = application.getRealPath(web_path);
		System.out.println(path);
		
		int max_size = 1024*1024*100;
		// 파일을 포함하고있는 request정보를 업로드 처리하기위한 객체
		// 5분에서 9분까지
		MultipartRequest mr = new MultipartRequest(request, path, max_size, "utf-8",
									new DefaultFileRenamePolicy());
		
		// 실제로 DB에 들어가는 내용
		String filename = "no_file";
		// 업로드된 파일의 정보를 얻음 (실제로는 서버(PC)에 들어가지, 데이터베이스에 들어가지 않음)
		File f = mr.getFile("photo");
		
		if(f!=null) {
			filename = f.getName();
		}
		
		// 파일 이외의 일반적인 파라미터 수신
		String title = mr.getParameter("title");
		String pwd = mr.getParameter("pwd");
		// ip는 직접 가지고와야한다.
		String ip = request.getRemoteAddr();
		
		// 쉽게 줄 수 있도록 vo 클래스에 담아서 주자
		PhotoVO vo = new PhotoVO();
		vo.setTitle(title);
		vo.setFilename(filename);
		vo.setPwd(pwd);
		vo.setIp(ip);
		
		
		PhotoDAO.getInstance().insert(vo);
		response.sendRedirect("list.do");
	}

}
