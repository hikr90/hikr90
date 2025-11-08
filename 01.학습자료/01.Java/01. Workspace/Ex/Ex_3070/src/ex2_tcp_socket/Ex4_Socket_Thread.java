package ex2_tcp_socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class Ex4_Socket_Thread implements Runnable {
	ServerSocket serverSocket;
	Thread [] threadArr;
	
	public static void main(String[] args) {
		/*		[예제] 소켓의 쓰레드를 이용한 병렬 작업 처리	
		 * 			- 서버에 접속하는 클라이언트의 수가 많은 경우에는 쓰레드를 사용해서 클라이언트의 요청을 병렬적으로 처리한다.
		 * 			- 쓰레드를 사용하지 않는 경우 서버가 접속을 요청한 순서대로 처리하기 때문에 늦게 접속을 요청한 클라이언트는 오랜 시간을 기다릴 수도 있다.
		 */
		
		// 쓰레드 5개 생성
		Ex4_Socket_Thread server = new Ex4_Socket_Thread(5);
		server.start();
	}
	
	public Ex4_Socket_Thread(int num) {
		try {
			//  서버 소켓을 생성하여 7777번 포트와 결합
			serverSocket = new ServerSocket(7777);
			System.out.println(getTime() + " 서버가 준비되었습니다.");
			
			// 쓰레드 동작
			threadArr = new Thread[num];

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		for(int i=0;i<threadArr.length;i++) {
			threadArr[i] = new Thread(this);
			threadArr[i].start();
		}
	}
	
	
	@Override
	public void run() {
		while (true) {
			try {
				System.out.println(getTime() + " 연결요청을 기다립니다.");
				
				Socket socket = serverSocket.accept();
				System.out.println(getTime() + " " + socket.getInetAddress() + "로부터 연결 요청이 들어왔습니다.");
				
				// 소켓의 출력 스트림 생성
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				// 원격 소켓에 데이터 전송
				dos.writeUTF("[Notice] Test Message1 from Server.");
				System.out.println(getTime() + " 데이터를 전송했습니다.");
				
				// 소켓 종료
				dos.close();
				socket.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//
	static String getTime() {
		String name = Thread.currentThread().getName();
		SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
		return sdf.format(new Date()) + name;
	}

}
