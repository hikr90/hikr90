package ex1_networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Ex5_Work {
	public static void main(String[] args) {
		// [예제] URL에 연결하여 그 내용을 읽어오는 예제
		URL url = null;
		BufferedReader input = null;
		String address = "http://www.codechobo.com/sample/hello.html";
		String line = "";
		
		try {
			url = new URL(address);
			
			// [참고] openStream은 openConnection을 호출 뒤 URLConnection을 얻은 다음 여기에 다시 getInputStream을 호출한 것과 같다.
			// 		- URLConnection conn = url.openConnetion();
			// 		- InputStream in = conn.getInputStream();
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while ((line=input.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}
}
