package ex1_byte_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex1_Stream {
	public static void main(String[] args) throws IOException {
		
		/*	입출력
		 * 		- 입력 (Input)과 출력 (Output)으로 줄여서 입출력 (IO)라고 부른다.
		 * 		- 컴퓨터 내부 혹은 외부의 장치와 프로그램 간의 데이터를 주고 받는 작업을 뜻한다.
		 * 
		 * 		[참고] 입출력에서 기준은 Jvm이다.
		 * 			- output : 콘솔로 데이터 전송하는 작업, input : 외부에 있는 데이터를 이클립스의 콘솔로 가져오는 작업
		 * 			- 외부의 콘솔은 외장메모리, sd카드, c드라이브 등을 뜻한다.
		 * 
		 * 		(1) 스트림
		 * 			- 자바에서 입출력을 수행하기 위해서 데이터를 주고 받을 두 대상을 연결하고 데이터를 전송할 수 있는 일종의 통로를 뜻한다.
		 * 				(데이터를 전송하는데 사용되는 연결 통로)
		 * 
		 * 			- 단방향 통신만 가능하므로 입출력을 수행하기위해서는 입력 스트림과 출력 스트림이 필요하다.
		 * 			- 먼저 보낸 데이터를 먼저 받게 되어있으며 중간에 건너뜀없이 연속적으로 데이터를 주고 받는다.
		 * 		  	- 전달되는 데이터는 기본적으로 바이트 (byte)이다.
		 * 			- 객체 (스트림) 선언으로 통로를 오픈하고, close 메소드를 통해서 통로를 닫는다.
		 * 			- 파일을 찾지 못하거나 파일이 읽는 도중에 삭제되거나 잘못 가져올 가능성이 있으므로 try-catch를 사용한다.
		 * 			
		 * 			(1.1) 바이트 기반 스트림 (InputStream, OutputStream)
		 * 				- 파일 :FileInputStream, FileOutputStream
		 * 				- 메모리 (byte배열) : ByteArrayInputStream, ByteArrayOutputStream
		 * 				- 프로세스 (프로세스간 통신) : PipedInputStream, PipedOutputStream 
		 * 				- 오디오 장치 : AudioInputStream, AudioOutputStream
		 * 
		 * 				[참고] byte기반의 스트림은 1byte씩 데이터를 가져온다.
		 * 
		 * 		(2) 스트림의 읽고 쓰기 메소드
		 * 			- abstract int read() / abstract void write(int b)
		 * 			- int read(byte[] b) / void write(byte[] b)
		 * 			- int read(byte[] b, int off, int len) / void write(byte[] b, int off, int len)
		 * 
		 * 			[참고] 각각의 스트림들은 Input/Output Stream의 자손들이며 읽고 쓰는데 필요한 추상메소드를 자신에 맞게 구현해두었다. 
		 * 
		 * 		(3) FileStream 생성자
		 * 			(3.1) FileInputStream(String name), FileOuputStream(String name)
		 * 				 - 지정된 파일이름(name)을 가진 실제 파일과 연결된 스트림을 생성한다.
		 * 				
		 * 			(3.2) FileInputStream(File file), FileOutputStream(File file)
		 * 				- 파일의 이름이 String이 아닌 File인스턴스로 지정해주어야하는 점을 제외하고 (String name)과 같다.
		 */
		
		// (1) FileInputStream
		String p1 = "C:/JAVA1_0713_KTH/test.txt";
		File f1 = new File(p1);
		//
		if(f1.exists()) {
			//
			try {
				//
				FileInputStream fis= new FileInputStream(f1);
				int code = -1;
				
				/* read 메소드 
				 * 		- 스트림의 데이터를 읽고 반환하는 메소드
				 * 		- 더이상 읽을 것이 없는 상황에서 -1을 반환하며 이 지점을 eof (End Of File)이라고 부른다.
				 * 		- 즉, 아래의 while문을 통해서 파일이 eof를 만날 때까지 반복하여 스트림의 데이터를 정수로 읽어낸다.
				 */
				while((code=fis.read())!= -1) {
					System.out.print(code+" ");
				}
				//
				if(fis!=null) {
					// 스트림은 사용 후 반드시 닫아줘야 한다.
					fis.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// (2) FileOutputStream
		String p2 = "C:/JAVA1_0713_KTH/fileOutput.txt";
		File f2 = new File(p2);
		FileOutputStream fos = null;
		//
		try {
			//
			fos = new FileOutputStream(f2);
			//
			String msg = "file Output스트림의 예제";
			String msg2 = "\n두번째 줄, 한글도 잘 나온다.";
			
			/*	getBytes
			 *		- 문자열의 문자 인코딩을 다른 인코딩으로 변환하는 메소드
			 *		- 파라미터로 다른 타입의 인코딩 타입을 넣어 사용할 수 있다.
			 *
			 *			(1) byte [] utf8_str = "가".getBytes("UTF-8");		// 문자열 > UTF-8
			 *			(2) String str = new String(utf8_str, "UTF-8"); 	// byte [ ] > 문자열
			 */
			fos.write(msg.getBytes());		// String > byte [ ] 로 변경
			fos.write(msg2.getBytes());
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fos.close();
		}
	}
}
