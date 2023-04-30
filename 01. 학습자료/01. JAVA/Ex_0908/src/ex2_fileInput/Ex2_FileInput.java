package ex2_fileInput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex2_FileInput {
	public static void main(String[] args) throws IOException {
		
		/*한글 읽어오도록 설정*/
		String path = "C:/JAVA1_0713_KTH/test.txt";		
		File f = new File(path);
		// byte배열이 낭비되지 않도록 고정값이 아닌 파일의 용량으로 맞추는 것이 좋다.
		byte [] b_read = new byte[(int)f.length()];
		
		// 아직 heap메모리에는 공간이 없는 상태
		FileInputStream fis = null;
		
		if(f.exists()) {
			 
			try {
				fis = new FileInputStream(f);
				
				// byte 배열로 받는다.
				// byte 배열에서 2바이트(두칸)에 걸쳐서 한글을 저장한다. 
				fis.read(b_read);
			
				// 출력
				// 한글이 담긴 byte[]을 String 타입으로 변경하여 출력이 가능하다. 
				String res = new String(b_read);
				System.out.println(res);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(fis!=null) {
					// 통로가 없어서 못닫는 오류가 발생할 가능성이 있다.
					// try-catch로 잡아도 되지만, 가독성의 문제로 보통은 add  IOException 처리하는 편이다.
					fis.close();
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
