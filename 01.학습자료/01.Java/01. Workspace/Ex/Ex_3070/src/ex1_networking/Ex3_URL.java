package ex1_networking;

import java.net.MalformedURLException;
import java.net.URL;

public class Ex3_URL {
	public static void main(String[] args) throws Exception {
		/*		URL
		 * 		- Uniform Resource Locator, 인터넷에 존재하는 여러 서버들이 제공하는 자원에 접근할 수 있는 주소
		 * 
		 * 		(1) URL의 형태
		 * 			[예시] http://www.test.com:80/test/test.html?value=test1#index
		 * 					  (1)            (2)            (3)  (4)       (5)              (6)          (7)
		 * 	
		 * 				(1.1) 프로토콜 		: 자원에 접근하기 위해 서버와 통신하는데 사용되는 통신 규약 (http)
		 * 				(1.2) 호스트명 		: 자원을 제공하는 서버의 이름 (www.test.com)
		 * 				(1.3) 포트 번호 		: 통신에 사용되는 서버의 포트 번호 (80)
		 * 				(1.4) 경로명 			: 접근하려는 자원이 저장된 서버상의 위치 (/test/)
		 * 				(1.5) 파일명 			: 접근하려는 자원의 이름 (test.html)
		 * 				(1.6) 쿼리 				: URL에서 '?' 이후의 부분 (value=test1)
		 * 				(1.7) 참조 				: URL에서 '#" 이후의 부분 (index)
		 * 			
		 * 			[참고] URL에서 포트번호, 쿼리, 참조는 생략 가능하다.
		 * 				- http 프로토콜에서는 80번 포트를 사용하므로 URL에서 포트번호를 생략하는 경우 80으로 간주한다.
		 * 				- 각 프로토콜에 따라서 통신에 사용하는 포트번호가 다르며 생략되면 각 프로토콜의 가본 포트가 사용된다.
		 */
		URL url = new URL("http://www.codechobo.com:80/sample/" + "hello.html/referer=codechobo#index1");
		
		System.out.println("url.getAuthority() : " + url.getAuthority());
		System.out.println("url.getContent() : " + url.getContent());
		System.out.println("url.getDefaultPort() : " + url.getDefaultPort());
		System.out.println("url.getPort() : " + url.getPort());
		System.out.println("url.getFile() : " + url.getFile());
		System.out.println("url.getHost() : " + url.getHost());
		System.out.println("url.getPath() : " + url.getPath());
		System.out.println("url.getProtocol() : " + url.getProtocol());
		System.out.println("url.getQuery() : " + url.getQuery());
		System.out.println("url.getRef() : " + url.getRef());
		System.out.println("url.getUserInfo() : " + url.getUserInfo());
		System.out.println("url.toExternalForm() : " + url.toExternalForm());
		System.out.println("url.toURI() : " + url.toURI());
	}
}
