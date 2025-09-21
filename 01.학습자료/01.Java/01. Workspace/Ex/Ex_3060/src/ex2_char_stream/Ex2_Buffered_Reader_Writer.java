package ex2_char_stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex2_Buffered_Reader_Writer {
	public static void main(String[] args) throws IOException {
		// (1) Buffered Reader
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
		
		// (2) Buffered Writer
		String path2 = "C:/JAVA1_0713_KTH/BufferedWriter예제.txt";
		File f = new File(path2);
		//
		FileWriter fw = null;
		BufferedWriter bw = null;
		//
		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			//
			String str = "기억하자abc";
			bw.write(str);
			
			// newLine
			// - 한 라인을 자동으로 띄워주는 기능이다.
			// - buffered Writer에서만 사용 가능하다.
			bw.newLine();
			bw.write("갑돌이와 갑순이sss");
			bw.flush();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			bw.close();
			fw.close();
		}
	}
}
