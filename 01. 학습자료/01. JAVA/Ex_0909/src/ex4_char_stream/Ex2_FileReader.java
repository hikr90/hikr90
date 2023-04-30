package ex4_char_stream;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ex2_FileReader {
	public static void main(String[] args) throws IOException {

		/* 문제
		 * test.txt의 내용을 filereader로 읽어온 후, 대문자와 소문자가 각각 몇개씩 존재하는지 출력하시오.
		 * 
		 * 결과
		 * 대문자 : 
		 * 소문자 : */

		String path = "C:/JAVA1_0713_KTH/test.txt";
		File f = new File(path);

		FileReader fr = null;

		try {

			fr =  new FileReader(f);
			int code = -1;
			int upper = 0;
			int lower = 0;

			while((code=fr.read())!=-1) {

				if(code>='A'&&code<='Z'){
					upper++;
				}

				if(code>='a'&&code<='z') {
					lower++;
				}
			}

			System.out.println("대문자 : "+upper);
			System.out.println("소문자 : "+lower);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			fr.close();
		}
















	}
}
