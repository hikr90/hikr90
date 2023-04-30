package ex2_fileInput;

import java.io.File;
import java.io.FileInputStream;

public class Ex4_FileInput {
	public static void main(String[] args) {
		
		// 스캐너 없이 입력값 받는 방법
		// 경로 : C:\\JAVA1_0713_KTH/test.txt
		// ab수박이박수ba
		FileInputStream fis = null;
		byte [] read = new byte[100]; 
		byte [] console = new byte[100]; 
		
		try {
			
			System.out.println("경로 : ");
			
			// 키보드에서 넘어온 값을 byte []에 담는다. 
			// 표준입력장치에서 넘어온 값을 system.in 스트림을 통해서 바로 읽어올 수 있다.
			System.in.read(console);
			
			// 문자열에 저장
			String path = new String(console); // 키보드에서 받은 값을 
			
			// FileInputStream에는 문자열로 받아서 접근하는 방법도 있다.
			fis = new FileInputStream(path.trim());
			fis.read(read);
			
			String res = new String (read);
			System.out.println(res);
			
		} catch (Exception e) {

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
