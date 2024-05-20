// FILEDOWNLOAD를 그대로 못가져온다. 한글이 깨짐
// FILEDOWNLOAD를 메모장에 넣은다음 복사해서 서블릿에 붙여넣기
// 매핑주소만 수정하자
// 다운받기위한 어떤 경로, 어떤 파일명을 다운받을건지가 중요 
package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/photo/download.do")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청으로부터 파라미터 저장
		String dir = request.getParameter("dir");
		String fullpath = getServletContext().getRealPath(dir);
		String filename = "";
		filename = request.getParameter("filename");
		String fullpathname = String.format("%s/%s", fullpath,filename);
		//
		File file = new File(fullpathname);
		byte [] b = new byte[1024*1024*4];
		
		// 클라이언트 브라우저 가져오기
		//	- getHeader("User-Agent") : 브라우저 값을 가져온다. 	
        String strAgent = request.getHeader("User-Agent");
        String userCharset = request.getCharacterEncoding();
        //
        if(userCharset==null)userCharset="utf-8";
        String value = "";
        // IE 일 경우
        if (strAgent.indexOf("MSIE") > -1) 
        {
            // IE 5.5 일 경우
            if (strAgent.indexOf("MSIE 5.5") > -1) 
            {
                value = "filename=" + filename ;
            }
            // 그 밖의 상황
            else if (strAgent.indexOf("MSIE 7.0") > -1) 
            {
                if ( userCharset.equalsIgnoreCase("UTF-8") ) 
                {
                	filename = URLEncoder.encode(filename,userCharset);
                	filename = filename.replaceAll("\\+", " ");
                    value = "attachment; filename=\"" + filename + "\"";

                }    
                else 
                {
                    value = "attachment; filename=" + new String(filename.getBytes(userCharset), "ISO-8859-1");
                }
            }
            else{
            	// IE 8.0이상에서는 2회 호출된다.
            	if ( userCharset.equalsIgnoreCase("UTF-8") ) 
                {
                	filename = URLEncoder.encode(filename,"utf-8");
                	filename = filename.replaceAll("\\+", " ");
                    value = "attachment; filename=\"" + filename + "\"";
                }    
                else 
                {
                    value = "attachment; filename=" + new String(filename.getBytes(userCharset), "ISO-8859-1");
                }
            }
            
        }else if(strAgent.indexOf("Firefox") > -1){
        	// Firefox : 공백문자이후은 인식이 안된다.
        	value = "attachment; filename=" + new String(filename.getBytes(), "ISO-8859-1");
        }
       else {
            // IE 를 제외한 브라우저
            value = "attachment; filename=" + new String(filename.getBytes(), "ISO-8859-1");
        }
        // Html에서 받는 정보의 캐시를 캐시에서 불러오지 않고 최신의 페이지만 보여주도록 한다.
        response.setContentType("Pragma: no-cache"); 

		// 전송 데이터가 스트림에서 처리되도록 : 웹상전송 문자셋은 : 8859_1
		response.setContentType("application/octet-stream;charset=8859_1;");

		// 모든 파일에대하여 다운로드 대화상자가 열리게 설정
		// 	- Content-Disposition : attachment
		response.setHeader("Content-Disposition", value);
		
		// 전송타입은 바이너리 타입으로 설정
		response.setHeader("Content-Transfer-Encoding", "binary;");
		//
		if(file.isFile())
		{
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			int i=0;
			try
			{
				while((i=bis.read(b))!=-1)
				{
					bos.write(b,0,i);
				}
			} catch(Exception e){
				//e.printStackTrace();
			} finally {
				if(bos!=null)bos.close();
				if(bis!=null)bis.close();
			}
		}
	}
}