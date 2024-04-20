package ex3_buffered_output;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex1_BufferedOutput {
	public static void main(String[] args) throws IOException {
		
		String path = "C:/JAVA1_0713_KTH/bufferedOutput.txt";
		File f = new File(path);
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			
			// 파일 생성
			fos = new FileOutputStream(f);
			
			bos = new BufferedOutputStream(fos);
			
			String msg  = "Buf아웃풋 스트림의 exam";
			bos.write(msg.getBytes());
			
			// bos가 close될 때, 알아서 flush(내용을 물리적으로 기록하기위한 메서드)메서드가 내부적으로 호출된다. 
			// 역순이여서, 기록이 안되는 상황이 발생하지 않도록 미리 물리적으로 데이터를 저장하는 방식 (안전장치)
			// 정순으로 닫아도 값은 기록이 된다.
			bos.flush();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			// fos가 경로를 bos에 넘기는데, 만약 fos를 먼저 닫아버리면 어느 경로로 가는지 어떤 값을 입력하는지 알수가 없어져 오류가 난다.
			// 스트림의 많아, 역순으로 못닫는 경우도 있다. 
			// close에서 물리적으로 값이 입력되며 마무리되는데 데이터가 기록되지 않도록 역순, flush를 항상 써두자.
			bos.close();
			fos.close();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
