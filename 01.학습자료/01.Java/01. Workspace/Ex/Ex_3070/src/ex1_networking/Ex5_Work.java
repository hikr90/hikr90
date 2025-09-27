package ex1_networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Ex5_Work {
	public static void main(String[] args) {
		// [����] URL�� �����Ͽ� �� ������ �о���� ����
		URL url = null;
		BufferedReader input = null;
		String address = "http://www.codechobo.com/sample/hello.html";
		String line = "";
		
		try {
			url = new URL(address);
			
			// [����] openStream�� openConnection�� ȣ�� �� URLConnection�� ���� ���� ���⿡ �ٽ� getInputStream�� ȣ���� �Ͱ� ����.
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
