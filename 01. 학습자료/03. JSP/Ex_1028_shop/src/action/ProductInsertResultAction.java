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

import dao.ProductDAO;
import vo.ProductVO;

/**
 * Servlet implementation class ProductInsertResultAction
 */
@WebServlet("/shop/insert.do")
public class ProductInsertResultAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 입력 폼에서 넣은 정보를 처리하는 영역
		// 	입력 정보에 사진파일이 올라가기에 MULTIPART가 사용되어야한다.
		String web_path = "/images/";
		ServletContext application = getServletContext();
		String path = application.getRealPath(web_path);
		System.out.println(path);
		
		int max_size = 1024*1024*100;
		
		MultipartRequest mr = new MultipartRequest(request, path, max_size, "utf-8",
													new DefaultFileRenamePolicy());
		// 파일이 아닌 데이터 획득
		String category = mr.getParameter("category");
		String p_num = mr.getParameter("p_num");
		String p_name = mr.getParameter("p_name");
		String p_company = mr.getParameter("p_company");
		int p_price = Integer.parseInt(mr.getParameter("p_price"));
		int p_saleprice = Integer.parseInt(mr.getParameter("p_saleprice"));
		String p_content = mr.getParameter("p_content");
		
		// 업로드 완료된 파일들의 정보를 획득
		String img_s_name = "no_img";
		String img_l_name = "no_img";
		
		File f = mr.getFile("p_img_s");
		if(f!=null) {
			img_s_name = f.getName();
		}

		File f2 = mr.getFile("p_img_l");
		if(f2!=null) {
			img_l_name = f2.getName();
		}
		
		// 	너부 많은 변수가 있으므로 받은 정보를 VO에 통째로 저장한다.
		ProductVO vo = new ProductVO();
		vo.setCategory(category);
		vo.setP_num(p_num);
		vo.setP_name(p_name);
		vo.setP_company(p_company);
		vo.setP_price(p_price);
		vo.setP_saleprice(p_saleprice);
		vo.setP_image_s(img_s_name);
		vo.setP_image_l(img_l_name);
		vo.setP_content(p_content);
		
		// INSERT
		int res = ProductDAO.getInstance().insert(vo);
		// 상품이 등록되면 처음에 클릭했던 카테고리로 돌아가도록 해당 변수를 붙여서 전송한다.
		response.sendRedirect("list.do?category="+category);
	}
}
