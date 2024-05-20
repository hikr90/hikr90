package ex4_char_stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex3_BufferedReader {
	public static void main(String[] args) throws IOException {
		//
		String path = "C:/JAVA1_0713_KTH/test.txt";
		FileReader fr = null;
		BufferedReader br = null;
		//
		try {
			// 파일 클래스없이 바로 경로를 넣어도 문제가 발생하지 않는다. 
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			
			// readLine
			// - buffered reader에서 스트림의 데이터를 한 라인씩 가져오는 메소드
			// - 더이상 읽을 수 있는 데이터가 없을 경우 null 을 반환한다.
			String msg = "";
			//
			while((msg = br.readLine())!=null) {
				// 한 라인씩 가져오므로 굳이 형변환을 할 필요가 없다.
				System.out.println(msg);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			br.close();
			fr.close();
		}
	}
}
