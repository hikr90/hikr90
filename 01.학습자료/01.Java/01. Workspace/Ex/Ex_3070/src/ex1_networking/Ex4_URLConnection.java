package ex1_networking;

import java.net.URL;
import java.net.URLConnection;

public class Ex4_URLConnection {
	public static void main(String[] args) {
		/*		URLConnection
		 * 		- 어플리케이션과 URL간의 통신연결을 나타내는 클래스의 최상위 클래스
		 * 		- 해당 클래스를 사용하여 연결하고자하는 자원에 접근하고 읽고 쓰기를 할 수 있다.
		 */
		URL url = null;
		String address = "http://www.codechobo.com/sample/hollo.html";
		
		try {
			//
			url = new URL(address);
			URLConnection conn = url.openConnection();		// HttpURLConnection 반환
			
			System.out.println("conn.toString() : " + conn);		// 연결 주소 반환
			System.out.println("getAllowUserInteraction() : " + conn.getAllowUserInteraction());	// UserInteraction의 허용 여부 반환
			System.out.println("getConnectionTimeout() : " + conn.getConnectTimeout());		// 연결종료시간 (천분의 일초) 반환
			System.out.println("getContent : " + conn.getContent());		// Content 객체 반환
			System.out.println("getContentEncoding() : " + conn.getContentEncoding());	// Content 인코딩 반환
			System.out.println("getContentType() : " + conn.getContentType());		// Content 타입의 반환
			System.out.println("getURL() : " + conn.getURL());		// URL 반환
			System.out.println("getUseCaches() : " + conn.getUseCaches()); 		// 캐쉬 사용 여부 반환
			System.out.println("getPermission() : " + conn.getPermission());		// 허용 권한 반환
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
