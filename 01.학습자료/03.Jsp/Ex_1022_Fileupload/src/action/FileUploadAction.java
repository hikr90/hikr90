package action;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileUploadAction
 */
@WebServlet("/upload.do")
public class FileUploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// multipart를 할 경우 request.setCharacterEncoding("utf-8"); 을 쓰지 않는다.
		
		// 서버(PC) 어느 폴더에 저장할지에대한 경로 (상대경로)
		String web_path = "/upload/";
		
		// ServletContext : 현재 웹 애플리케이션을 관리하는 객체
		ServletContext applicaion = request.getServletContext();
		// 프로젝트상의 상대경로를 절대경로로 변환하는 코드
		String path = applicaion.getRealPath(web_path); // (절대경로)
		System.out.println("경로 : "+path);
		
		
		// MAX_SIZE : 파일의 최대 업로드 용량 (높이,너비,최대용량 ) (서버가 허락하는한 더 크게 잡을 수 있다.)
		// BUFFERED STREAM을 사용해서 업로드할 때만 일시적으로 공간을 잡는 것이여서 최대 100MB를 잡는 것이지 1MB 파일을 올리면 1MB의 공간만 잡게된다.
		int max_size = 1024*1024*100; 
		
		// MultipartRequest : 파일을 포함하고 있는 데이터를 수신하고 처리하기위한 클래스
		// cos라이브러리를 다운받아 넣지 않았다면 MutipartRequest는 사용할 수 없다. (import com.oreilly.servlet.MultipartRequest; : cos의 라이브러리)
		
		// MultipartRequest(요청처리객체 request, 업로드위치, 최대업로드 용량, 인코딩 타입, 동일파일명정책)
		// <re는 일반파라미터는 받아도 파일형식을 못받는다. 그래서 파일을 받을 수 있도록 MultipartRequest 객체를 줄테니 참고해서 mr로 받아줘 (request위임)>
		// 동일 파일명 정책  : 파일명이 중복되었을 때, 넘버링해서 자동으로 파일명을 바꿔주는 클래스
		MultipartRequest mr = new MultipartRequest(request, path, max_size, "utf-8",
				new DefaultFileRenamePolicy());
		
		
		// 업로드된 파일정보(제목, 파일명) 얻어오기
		String filename = "no_file";
		
		// 파일의 경로를 받음
		// 파일을 받을때는 파일형태로 받아야하므로 (Multipart)mr.getfile로 받아야한다. (c:/upload/파일명.jpg (파일명이 아닌 파일의 정보를 가지고옴))
		File f = mr.getFile("photo");
		
		// 파일이 정상적으로 업로드되었다 : !=null
		if(f!=null) {
			// f.getName : 파일의 명칭
			filename = f.getName();
		}
		
		// 파일의 제목을 받음
		// Multipart로 파일을 보내는 순간부터는 절대로 일반 파라미터받듯이 request.getparameter로 못받는다. (일반파라미터도 request로 담겨져 Multipart로 위임하여 처리하는 것으로 약속했기때문이다.)
		String title = mr.getParameter("title");
		
		// 바인딩
		// 파일명과 제목의 값을 받았으니 result.jsp에서 el표기법으로 사용할 수 있도록 바인딩(저장)시킨다.
		request.setAttribute("title", title);
		request.setAttribute("filename", filename);
		
		// 포워딩
		// 위에서 바인딩 해놓은 값을 result.jsp에서 el표기법으로 가져다 사용할 수 있게 만든다.
		RequestDispatcher disp = request.getRequestDispatcher("result.jsp");
		disp.forward(request, response);
		
	}

}
