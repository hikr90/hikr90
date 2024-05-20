package ex2_fileInput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ex1_FileInput {
	public static void main(String[] args) {
		
		// 영어 내용 파일
		String path = "C:/JAVA1_0713_KTH/test.txt";	
		File f = new File(path);	// 파일 객체화
		//
		if(f.exists()) {
			
			/*	스트림
			 *		- 입출력 장치와 프로그램 사이의 흐름이자, 두가지를 연결하는 단방향의 통로이다.
			 *		- 전달되는 데이터는 기본적으로 바이트 (byte) 이다.
			 *		- 입력을 담당하는 input file stream과 출력을 담당하는 output file stream이 존재한다.
			 *		- 스트림 객체 선언으로 통로를 오픈하고, close 메소드를 통해서 통로를 닫는다.
			 *		- 파일을 찾지 못하거나, 파일이 읽는 도중에 삭제되거나 잘못 가져올 가능성이 있으므로 try - catch 로 감싸서 사용한다.
			 *		
			 *		(1) file steam
			 *				- byte 기반의 스트림으로 1byte씩 데이터를 가져온다.
			 *				- file input stream, buffered input stream, file output stream, buffered output stream
			 * 
			 * 	(2) char stream
			 *				- char 기반의 스트림으로 2byte씩 데이터를 가져온다.
			 *				- file input stream, buffered input stream, file output stream, buffered output stream
			 * 	
			 * 	[참고] 한글은 한 자에 2byte 로 구성되어있으므로 input stream 을 사용하는 경우 한 글자를 배열에 반으로 나눠서 담으므로, char stream을 많이 사용한다.
			 * 
			 */
			try {
				//
				FileInputStream fis= new FileInputStream(f);
				int code = -1;
				
				//  read
				// - 스트림의 데이터를 읽고 반환하는 메소드
				// - read 메소드는 더이상 읽을 것이 없는 상황일 때 -1을 반환한다.
				// - 이 것을 eof (end of file) 이라고 부른다.
				// - 아래 코드의 while문은 스트림이 eof 를 만날 때까지 반복하여 스트림의 데이터를 정수로 읽는다.
				// - 즉, 파일을 끝까지 읽어라. 라는 뜻이다. 
				while((code=fis.read())!= -1) {
					System.out.print(code+" ");
				}	// while
				
				// 스트림을 New 키워드로 생성했으므로, true 값
				if(fis!=null) {
					// 스트림은 사용 후 반드시 닫아줘야 한다.
					fis.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // try-catch
	}
}
