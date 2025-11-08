package ex2_tcp_socket;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class Ex3_Client {
	public static void main(String[] args) {
		// [예제] TCP/IP 클라이언트 구현
		try {
			String ip = "127.0.0.1";
			System.out.println("서버에 연결 중입니다. 서버 IP : " + ip);
			
			// 소켓 생성
			Socket socket = new Socket(ip, 7777);
			
			// 소켓 입력 스트림
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			// 소켓으로부터 받은 데이터 출력
			System.out.println("서버로부터 받은 메세지 : " + dis.readUTF());
			System.out.println("연결을 종료합니다.");
			
			// 소켓 종료
			dis.close();
			socket.close();
				
			System.out.println("연결이 종료되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
