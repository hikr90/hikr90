package ex1_buffered_input;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex1_BufferedInput {
	public static void main(String[] args) throws IOException {
		
		/* 버퍼 스트림 : 자신만의 전용 공간을 통해서 데이터를 입력하거나 출력하는 용도로 사용하는 스트림 (높은 속도)
		    일반 스트림과 버퍼 스트림을 연결하여 파일을 읽거나 쓸 때 버퍼링 작업을 수행하도록 한다.
		    버퍼링 : 출력하고자하는 데이터들을 버퍼라는 메모리 공간에 바이트배열로 미리 저장해두는 작업
			버퍼라는 영역은 입출력을 위한 마련된 기억장치의 한 부분으로서, 버퍼에 자료를 모아두면 입출력 속도 향상에 도움이 된다. (동영상 버퍼링 작업 = 따로 버퍼라는 영역에 모아서 저장한 뒤, 이어서 볼 수 있음)
			일반적인 스트림 : 1바이트씩 왔다갔다 데이터 전달
			버퍼 스트림 : 한번에 바이트배열에 모아두었다가 한 뭉치마다 전달
			공용 화장실 : 스트림
			남녀 화장실 : 버퍼 스트림 */
		
		String path = "C:/JAVA1_0713_KTH/test.txt";
		File f = new File(path);
		byte [] read = new byte[(int)f.length()];
		
		FileInputStream fis = null;
		
		// BufferedInputStream
		BufferedInputStream bis = null;
		
		try {
			
			fis = new FileInputStream(f);
			// 파일 인풋 스트림의 경로를 버퍼가 받아서 해당 경로에 있는 데이터를 받아올 준비를 한다. (중간 경로를 가로채는 개념)
			// 만약 fis2가 있고 fis2가 버퍼를 이용해서 오게되면 fis bis의 통로와는 다른 나만의 통로가 또 생긴다.  
			bis = new BufferedInputStream(fis);
			bis.read(read);
			
			System.out.println(new String(read));

		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			// close 할때는 생성된 역순으로 닫아주는 것이 좋다. (버퍼 -> 인풋스트림)
			bis.close();
			fis.close();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
