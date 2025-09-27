package ex1_networking;

import java.net.MalformedURLException;
import java.net.URL;

public class Ex3_URL {
	public static void main(String[] args) throws Exception {
		/*		URL
		 * 		- Uniform Resource Locator, ���ͳݿ� �����ϴ� ���� �������� �����ϴ� �ڿ��� ������ �� �ִ� �ּ�
		 * 
		 * 		(1) URL�� ����
		 * 			[����] http://www.test.com:80/test/test.html?value=test1#index
		 * 					  (1)            (2)            (3)  (4)       (5)              (6)          (7)
		 * 	
		 * 				(1.1) �������� 		: �ڿ��� �����ϱ� ���� ������ ����ϴµ� ���Ǵ� ��� �Ծ� (http)
		 * 				(1.2) ȣ��Ʈ�� 		: �ڿ��� �����ϴ� ������ �̸� (www.test.com)
		 * 				(1.3) ��Ʈ ��ȣ 		: ��ſ� ���Ǵ� ������ ��Ʈ ��ȣ (80)
		 * 				(1.4) ��θ� 			: �����Ϸ��� �ڿ��� ����� �������� ��ġ (/test/)
		 * 				(1.5) ���ϸ� 			: �����Ϸ��� �ڿ��� �̸� (test.html)
		 * 				(1.6) ���� 				: URL���� '?' ������ �κ� (value=test1)
		 * 				(1.7) ���� 				: URL���� '#" ������ �κ� (index)
		 * 			
		 * 			[����] URL���� ��Ʈ��ȣ, ����, ������ ���� �����ϴ�.
		 * 				- http �������ݿ����� 80�� ��Ʈ�� ����ϹǷ� URL���� ��Ʈ��ȣ�� �����ϴ� ��� 80���� �����Ѵ�.
		 * 				- �� �������ݿ� ���� ��ſ� ����ϴ� ��Ʈ��ȣ�� �ٸ��� �����Ǹ� �� ���������� ���� ��Ʈ�� ���ȴ�.
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
