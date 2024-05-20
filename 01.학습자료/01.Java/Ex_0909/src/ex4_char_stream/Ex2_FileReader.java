package ex4_char_stream;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ex2_FileReader {
	public static void main(String[] args) throws IOException {
		
		// 문제
		// - test.txt 의 내용을 file reader로 읽은 뒤, 대문자와 소문자가 각각 몇개 있는지 보여주세요.
		// - 결과
		// - 대문자 : 몇 개
		// - 소문자 : 몇 개
		String path = "C:/JAVA1_0713_KTH/test.txt";
		File f = new File(path);
		FileReader fr = null;
		//
		try {
			//
			fr =  new FileReader(f);
			int code = -1;
			int upper = 0;
			int lower = 0;
			//
			while((code=fr.read())!=-1) {
				//
				if(code>='A'&&code<='Z'){
					upper++;
				}
				//
				if(code>='a'&&code<='z') {
					lower++;
				}
			}
			//
			System.out.println("대문자 : "+upper);
			System.out.println("소문자 : "+lower);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			fr.close();
		}
	}
}
