package ex1_byte_stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex2_Buffered_Stream {
	public static void main(String[] args) throws IOException {
		/*	보조 스트림
		 * 		- 스트림의 기능을 향상시키거나 새로운 기능을 제공하는 보조 역할의 스트림을 뜻한다.
		 * 		- 데이터의 입출력 기능은 없으므로 스트림을 먼저 생성한 뒤에 이를 이용해서 보조 스트림을 생성한다.
		 * 		
		 * 		(1) 주요 보조 스트림
		 * 			(1.1) FilterInputStream, FilterOutputStream : 필터를 이용한 입출력 처리
		 * 			(1.2) BufferedInputStream, BufferedOutputStream : 버퍼를 이용한 입출력 출력 향샹
		 * 			(1.3) SequenceInputStream : 두개의 스트림을 하나로 연결
		 * 			(1.4) ObjectInputStream, ObjectOutputStream : 데이터를 객체 단위로 읽고 쓰는데 사용 (객체 직렬화와 연관)
		 * 			(1.5) PrintStream : 버퍼를 이용하며 추가적인 print관련 기능
		 * 
		 * 		(2) 버퍼
		 * 			- 입출력을 위해서 마련된 기억 장치의 일부분
		 * 			- 해당 영역에 자료를 따로 모아두면 입출력 속도 향상
		 * 				(ex.동영상 버퍼링 작업 : 영상 등의 입출력 데이터를 버퍼에 모아서 저장하여 인터넷 속도 상관없이 이어서 볼 수 있게 함)
		 * 
		 * 		(3) 버퍼 스트림
		 * 			- 버퍼 전용 공간을 통해서 데이터를 입력/출력하는 용도로 사용
		 * 			- 보조 스트림 중 하나로서 스트림의 속도 향상을 돕는다.
		 * 				(파일 스트림의 경로를 버퍼가 가로챈 뒤 해당 경로에 있는 데이터를 대신 받아온다.)
		 * 			- 버퍼 스트림 종료 시 스트림 생성의 역순으로 닫아준다. (버퍼 > 스트림)
		 * 
		 * 			[참고] 일반과 버퍼 스트림의 차이
		 * 				- 일반 : 1byte 단위로 왔다갔다하면서 데이터 전달
		 * 				- 버퍼 : byte[]에 한번에 모아서 한 뭉치씩 전달
		 * 
		 * 		(4) 버퍼 스트림 생성자
		 * 			(4.1) BufferdInputStream(InputStream in), BufferdOutputStream(OutputStream out)
		 * 				- 주어진 스트림의 인스턴스를 입력 소스로하며 버퍼의 크기를 지정해주지 않으므로 기본적으로 8192byte 크기의 버퍼를 갖는다.
		 * 
		 * 			(4.2) BufferdInputStream(InputStream in, int size), BufferdOutputStream(OutputStream out, int size)
		 * 				- 주어진 스트림의 인스턴스를 입력 소스로하며 지정된 크기 (byte)의 버퍼를 갖는 버퍼 스트림의 인스턴스를 생성한다.
		 */
		
		// (1) BuffredInputStream
		String p1 = "C:/JAVA1_0713_KTH/test.txt";
		File f1 = new File(p1);
		byte [] read = new byte[(int)f1.length()];
		//
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		//
		try {
			//
			fis = new FileInputStream(f1);
			bis = new BufferedInputStream(fis);
			bis.read(read);
			//
			System.out.println(new String(read));

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			//
			bis.close();
			fis.close();
		}
		
		// (2) BuffredOutputStream
		String p2 = "C:/JAVA1_0713_KTH/bufferedOutput.txt";
		File f2 = new File(p2);
		//
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		//
		try {
			// 파일 생성
			fos = new FileOutputStream(f2);
			bos = new BufferedOutputStream(fos);
			//
			String msg  = "Buf아웃풋 스트림의 exam";
			bos.write(msg.getBytes());
			
			// [참고] flush는 버퍼 내 데이터의 유무 상관없이 강제로 출력을 작업 완료 시키는 메소드이다.
			bos.flush();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// [참고] flush는 close가 역순으로 제대로 닫지 못한 상황을 대비한다.
			//	- (1) 역순으로 닫는다. (2) flush로 밀어낸다.
			bos.close();
			fos.close();
		}
	}
}
