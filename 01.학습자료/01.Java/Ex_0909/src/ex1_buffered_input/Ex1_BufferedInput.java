package ex1_buffered_input;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex1_BufferedInput {
	public static void main(String[] args) throws IOException {
		
		/*	버퍼
		 * 	- 입출력을 위해서 마련된 기억 장치의 일부분으로서, 버퍼에 자료를 미리 모아두면 입출력 속도 향상에 도움이 된다.
		 * 	- (동영상 버퍼링 작업 = 따로 버퍼라는 영역에 모아서 저장한 뒤 이어서 볼 수 있게 함)
		 * 	
		 * 버퍼링
		 * 	- 영상 등의 입출력 데이터(바이트 배열)를 버퍼라는 영역에 모아서 저장하는 행위
		 * 
		 * 버퍼 스트림
		 * 	- 버퍼 전용 공간을 통해서 데이터를 입력, 출력하는 용도로 사용
		 * 	- 속도 측면에서 좋다.
		 * 	-  파일 스트림의 경로를 버퍼가 가로채서 해당 경로에 있는 데이터를 받아올 준비한다.
		 * 
		 *  각 스트림 차이
		 * 	(1) 일반 스트림 : 1바이트 단위로 왔다갔다하며 데이터 전달
		 * 	(2) 버퍼 스트림 : 한번에 바이트 배열에 모아서 한 뭉치씩 전달
		 * 
		 * [참고] 스트림을 종료할 때는 생성된 역순으로 닫아준다. (버퍼 - 스트림)
		 * 
		 */
		
		String path = "C:/JAVA1_0713_KTH/test.txt";
		File f = new File(path);
		byte [] read = new byte[(int)f.length()];
		//
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		//
		try {
			//
			fis = new FileInputStream(f);
			bis = new BufferedInputStream(fis);
			bis.read(read);
			//
			System.out.println(new String(read));

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// 역순으로 닫아준다.
			bis.close();
			fis.close();
		}
	}
}
