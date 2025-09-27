package ex1_networking;

import java.net.URL;
import java.net.URLConnection;

public class Ex4_URLConnection {
	public static void main(String[] args) {
		/*		URLConnection
		 * 		- ���ø����̼ǰ� URL���� ��ſ����� ��Ÿ���� Ŭ������ �ֻ��� Ŭ����
		 * 		- �ش� Ŭ������ ����Ͽ� �����ϰ����ϴ� �ڿ��� �����ϰ� �а� ���⸦ �� �� �ִ�.
		 */
		URL url = null;
		String address = "http://www.codechobo.com/sample/hollo.html";
		
		try {
			//
			url = new URL(address);
			URLConnection conn = url.openConnection();		// HttpURLConnection ��ȯ
			
			System.out.println("conn.toString() : " + conn);		// ���� �ּ� ��ȯ
			System.out.println("getAllowUserInteraction() : " + conn.getAllowUserInteraction());	// UserInteraction�� ��� ���� ��ȯ
			System.out.println("getConnectionTimeout() : " + conn.getConnectTimeout());		// ��������ð� (õ���� ����) ��ȯ
			System.out.println("getContent : " + conn.getContent());		// Content ��ü ��ȯ
			System.out.println("getContentEncoding() : " + conn.getContentEncoding());	// Content ���ڵ� ��ȯ
			System.out.println("getContentType() : " + conn.getContentType());		// Content Ÿ���� ��ȯ
			System.out.println("getURL() : " + conn.getURL());		// URL ��ȯ
			System.out.println("getUseCaches() : " + conn.getUseCaches()); 		// ĳ�� ��� ���� ��ȯ
			System.out.println("getPermission() : " + conn.getPermission());		// ��� ���� ��ȯ
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
