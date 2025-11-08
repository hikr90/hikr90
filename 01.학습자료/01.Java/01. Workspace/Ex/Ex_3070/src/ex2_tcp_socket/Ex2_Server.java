package ex2_tcp_socket;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex2_Server {
	public static void main(String[] args) {
		// [예제] TCP/IP 서버 구현
		ServerSocket serverSocket = null;
		
		try {
			// 서버소켓을 생성하여 7777 포트와 결합
			serverSocket = new ServerSocket(7777);
			System.out.println(getTime() + " 서버가 준비되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		while(true) {
			try {
				System.out.println(getTime() + " 연결요청을 기다립니다.");
				
				// 요청 시간 대기 (요청 시간동안 접속 요청이 없으면 SocketTimeoutException)
				// 값이 0인 경우, 제한시간없이 대기한다.
				serverSocket.setSoTimeout(5*1000);
				
				// 내부 소켓 생성
				Socket socket = serverSocket.accept();
				
				System.out.println(getTime() + socket.getInetAddress() + "로부터 연결 요청이 들어왔습니다.");
				System.out.println("getPort() : " + socket.getPort());		// 원격 (클라이언트) 소켓의 포트 (사용가능한 임의의 포트 번호)
				System.out.println("getLocalPort() : " + socket.getLocalPort()); 	// 소켓 자신이 사용하는 포트
				
				// 내부 소켓의 출력 스트림 생성
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				// 내부 소켓에 데이터 전송
				dos.writeUTF("[Notice] Test Message1 from Server.");
				System.out.println(getTime() + " 데이터를 전송했습니다.");
				
				// 소켓 종료
				dos.close();
				socket.close();

			} catch (SocketTimeoutException e) {
				System.out.println("지정된 시간동안 접속 요청이 없어, 서버를 종료합니다.");
				System.exit(0);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//
	static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
		return sdf.format(new Date());
	}
}
