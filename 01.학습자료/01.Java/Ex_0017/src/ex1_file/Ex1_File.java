package ex1_file;

import java.io.File;

public class Ex1_File {
	public static void main(String[] args) {
		
		/*	입출력
		 *		- 입출력 스트림을 뜻한다.
		 *		- 스트림이란, 가상머신에서 데이터를 입출력하기위한 통로로서 파일을 읽어들이거나 콘솔의 값을 가져오는 역할을 한다.
		 *		- (콘솔은 이클립스의 외부 영역인 외장메모리, sd카드, 키보드, 마우스, c드라이브 등을 뜻한다.) 
		 * 
		 * 	- 입출력에서 기준은 jvm이다.
		 * 		output : 콘솔로 데이터를 전송하는 작업
		 * 		input : 외부에 있는 데이터를 이클립스의 콘솔로 가져오는 작업
		 */
		//
		String path = "C:/JAVA1_0713_KTH/test.txt"; 		// 파일 경로
		File f = new File(path);		// 파일 클래스 객체화
		
		// isFile은 해당 객체가 파일인지를 참, 거짓으로 반환한다. (디렉토리의 경우 isDirectory 메소드로 판별한다.)
		if(f.isFile()) {
			System.out.println("파일의 크기 : "+f.length()+"byte");	// length 함수는 파일의 사이즈를 반환한다.
		}
	}
}
