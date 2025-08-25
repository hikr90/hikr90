package ex3_buffered_output;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex1_BufferedOutput {
	public static void main(String[] args) throws IOException {
		//
		String path = "C:/JAVA1_0713_KTH/bufferedOutput.txt";
		File f = new File(path);
		//
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		//
		try {
			// 파일 생성
			fos = new FileOutputStream(f);
			bos = new BufferedOutputStream(fos);
			//
			String msg  = "Buf아웃풋 스트림의 exam";
			bos.write(msg.getBytes());
			
			/*	flush 
			 *		- 버퍼에 데이터가 있던 없던 상관없이 버퍼에서 완전히 밀어내는 메소드
			 *		- 밀어낸다는 의미는 입력, 출력에서 남아있는 데이터를 강제로 완전히 작업 완료 시킨다는 뜻이다.
			 *		- 내용을 물리적으로 기록하기위한 일종의 안전장치이다.
			 */
			bos.flush();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// - flush는 close가 역순으로 제대로 닫지 못한 상황을 대비한다.
			// - 스트림 사용 시에는 꼭 (1) 역순으로 닫을 것 (2) flush로 밀어낼 것 을 기억하자.
			bos.close();
			fos.close();
		}
	}
}
