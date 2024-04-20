package ex2_fileInput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ex1_FileInput {
	public static void main(String[] args) {
		
		// 영어
		// input
		// fileinput stream
		String path = "C:/JAVA1_0713_KTH/test.txt";
		// 통로 오픈
		File f = new File(path);
		
		if(f.exists()) {
			
			// FileInputStream : 파일과 연결된 input stream(통로)을 생성
			// path 경로까지 접근해서, 파일 내용을 읽어오기위한 통로를 생성한다. file클래스가 알려준 경로를 가지고 
			// file not found exception이라는 예외변수가 생기는데 이름을 찾지못해 생기는 오류(예외)이다.
			// 읽으려고하는 순간 주소가 사라질 가능성이 있으니 
			try {
				
				// 스트림의 종류
				// .... Stream : byte기반의 스트림 (데이터를 로드할 때, 1바이트씩만 가져올 수 있다.)
				// .... Reader, .... Writer : char기반의 스트림 (데이터를 로드할 때, 2바이트씩 가져올 수 있다.)
				FileInputStream fis= new FileInputStream(f);
				
				int code = -1;
				
				// 주소를 읽을 것인데 읽어, 
				// 읽는 도중에 삭제가되거나 새롭게 저장되면 잘못 가져올 수 있다는 예외가 있다. 
				// read시마다 다음글자씩.. 스트림은 더이상 읽을 것이 없는 상황일때  -1을 반환한다. 이것을 EOF(END OF FILE)이라고 한다. 
				// 현재의 while문은 eof를 만날때까지 반복하며 아스키코드형태의 데이터를 정수로 읽어들이고 있다.
				// <코드가 -1이 아닐때까지만 반복하니 읽을 것이 있으면 없을 때까지 읽어라>
				while((code=fis.read())!= -1) {
					
					// 안녕하세요abc 출력
					// stream이므로 1byte씩 가져오는데 한글은 2byte이므로 나눠버린다. (합친다고 그 글자가 아님)
					// char(code)를 하는 순간 '안' 한글자가 두개로 나뉘어 져있는게 따로 아스키코드가 되서 이상하게 나온다. 
					System.out.print(code+" ");
					
				}	// while
				
				// 통로 막음
				// file을 new로 만들었으므로 true값이다.
				if(fis!=null) {
					// 스트림을 new로 열어서 사용한 다음에는 close를 통해 반드시 닫아주자.
					fis.close();
				}
				
				// 위의 fis.read에서 발생할 수 있는 ioexception(기존 정보가 변경되어 닫히지 않을 수 있음)을 not found(파일을 못찾을수있음)와 같이 볼 수 있도록 하나로 통합
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // try-catch
		
		
		
		
		
		
		
		
		
		
	}
}
