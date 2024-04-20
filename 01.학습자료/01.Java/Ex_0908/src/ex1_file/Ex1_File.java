package ex1_file;

import java.io.File;

public class Ex1_File {
	public static void main(String[] args) {
		
		/* io(input, output)
		 * io는 입출력 스트림을 입력한다.
		 * 스트림이란 데이터를 입출력하기위한 일종의 통로
		 * 프로그램에서 파일을 읽어들이거나 콘솔의 값을 가져오는 등의 작업이 가능하다.
		 * 
		 * 콘솔 : 이클립스 바깥쪽 영역 전부를 뜻한다. (외장메모리, sd카드, 키보드, 마우스, c드라이브등)
		 * 
		 * 자바에는 기본적으로 jvm(이클립스)이 있는데 c드라이브로 데이터를 보내고 받기위한 일종의 통로를 가지고있는데 이를 스트림이라고 한다.
		 * 반대(받는것)의 개념에서도 마찬가지다.
		 * 
		 * 가상머신(jvm)에서 콘솔로 값을 보내는 경우
		 * 보내는 모든 작업을 output이라고 한다.
		 * 
		 * 반대로 외부(콘솔)에 있는 이클립스의 콘솔창으로 가져오는 작업은 input이라고 한다.
		 * 
		 * file 클래스 선언 후, 작업공간의 드라이브안에 test 텍스트 파일 생성 파일안에 안녕하세요abc입력
		 * 다른이름으로 저장후 안시로 저장
		 * 경로를 복사한 뒤, path에 \를 /로 변경하여 입력
		 * 
		 * */
		
		// input
		// io를 사용하기위한 가장 대표적인 클래스
		String path = "C:/JAVA1_0713_KTH/test.txt"; // 파일
		// 파일클래스로부터 패스 경로까지 읽을 준비가 되었다는 뜻
		File f = new File(path);
		
		// isFile은 클래스가 접근하고싶은 콘솔의 데이터가 파일인 경우에는 참, 아닌 경우 거짓으로 반환한다.
		// !f.isDirectory() 로도 가능하다.
		if(f.isFile()) {
			// f.length()로 파일의 크기를 반환할 수 있다.
			System.out.println("파일의 크기 : "+f.length()+"byte");
		}
		
	
		
		
		
		
		
		
	}
}
