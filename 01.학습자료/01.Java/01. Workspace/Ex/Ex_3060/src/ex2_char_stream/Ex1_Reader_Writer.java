package ex2_char_stream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex1_Reader_Writer {
	public static void main(String[] args) throws IOException {
		/*	Reader & Writer 
		 *		- 문자기반 스트림
		 *		- 한글은 한 글자에 2byte로 구성되어 있으므로 InputStream을 사용하는 경우 한글자를 배열에 나눠서 담아야한다는 불편함이 있다.
		 *		- 일반적으로는 2byte의 처리가 가능한 char기반의 스트림인 Reader, Writer를 사용한다.
		 *		- 문자 데이터를 다루는데 필요한 여러 종류의 인코딩과 자바에서 사용하는 유니코드 간의 변환을 자동적으로 처리해준다.
		 *			(Reader는 특정 인코딩을 읽어서 유니코드로 변환하고, Writer는 유니코드를 특정 인코딩으로 변환하여 저장한다.)
		 */
		
		// (1) Reader
		String path1 = "C:/JAVA1_0713_KTH/fileOutput.txt";
		File f = new File(path1);
		FileReader fr = null;
		//
		try {
			//
			fr = new FileReader(f);
			int code = -1;
			//
			while((code=fr.read())!=-1) {
				System.out.print((char)code);
			}
			
		} catch (Exception e) {

		} finally {
			fr.close();
		}
	
		// (2) Writer
		String path2 = "C:/JAVA1_0713_KTH/fileWriter예제.txt";
		FileWriter fw = null;
		//
		try {
			//
			fw = new FileWriter(path2);
			String str1 = "저는 FileWriter의 예제입니다.\n";
			String str2 = "저도 같은 예제입니다.";
			
			// write 메소드를 통해서 외부장치에 출력한다.
			fw.write(str1);
			fw.write(str2);
			//
			fw.flush();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			fw.close();
		}
	}
}
