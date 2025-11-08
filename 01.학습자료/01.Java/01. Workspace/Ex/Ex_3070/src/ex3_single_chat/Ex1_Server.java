package ex3_single_chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ex1_Server {
	public static void main(String[] args) {
		// [예제] 쓰레드를 사용한 1:1 채팅
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			// 서버 소켓을 생성하여 포트 7777과 결합
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다.");
			
			// 외부 소켓 <> 내부 소켓 연동
			socket = serverSocket.accept();
			
			// 발신/수신 쓰레드 생성
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

// 발신자
class Sender extends Thread {
	Socket socket;
	DataOutputStream out;
	String name;
	
	public Sender(Socket socket) {
		this.socket = socket;
		try {
			// 데이터 전송
			out = new DataOutputStream(socket.getOutputStream());
			name = "[" + socket.getInetAddress() + ":" + socket.getPort() + "]";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		// 채팅이 전송되는한 유지
		while (out!=null) {
			try {
				out.writeUTF(name + " " + scanner.nextLine());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

// 수신자
class Receiver extends Thread {
	Socket socket;
	DataInputStream in;
	
	public Receiver(Socket socket) {
		this.socket = socket;
		try {
			in = new DataInputStream(socket.getInputStream());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while (in!=null) {
			try {
				System.out.println(in.readUTF());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}