package ex4_char_stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex3_BufferedReader {
	public static void main(String[] args) throws IOException {
		
		String path = "C:/JAVA1_0713_KTH/test.txt";
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			// file 클래스 없이 path 경로를 집어넣어도 문제가 없다.
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			
			// 버퍼 리더는 한글자씩하는 기존의 단어와 다르게, 한 줄씩 가지고온다.
			// readline은 더이상 읽을 것이 없을 경우 null이라는 값이 반환된다.
			String msg = "";
			
			while((msg = br.readLine())!=null) {
				// 한줄씩 가지고오니 굳이 캐스팅할 필요가 없다.
				System.out.println(msg);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			br.close();
			fr.close();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
