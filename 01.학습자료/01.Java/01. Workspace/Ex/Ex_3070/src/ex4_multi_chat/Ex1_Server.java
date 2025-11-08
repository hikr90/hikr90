package ex4_multi_chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Ex1_Server {
	// [예제] 쓰레드를 이용한 멀티 채팅
	HashMap clients;
	
	Ex1_Server() {
		clients = new HashMap();
		Collections.synchronizedMap(clients); // 동기화 처리
	}
	
	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다.");
			
			while (true) {
				socket = serverSocket.accept();
				System.out.println("[" + socket.getInetAddress() + "] " + socket.getPort() + "에서 접속했습니다.");
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 목록 (map)에 저장된 모든 클라이언트에게 메세지를 전달
	void sendToAll(String msg) {
		Iterator it = clients.keySet().iterator();
		
		while (it.hasNext()) {
			try {
				DataOutputStream out = (DataOutputStream)clients.get(it.next());
				out.writeUTF(msg);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new Ex1_Server().start();;
	}
	
	// 클라이언트가 추가될 때마다 동작
	// 클라이언트의 입력을 서버에 접속된 모든 클라이언트에게 전송
	class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream in;
		DataOutputStream out;
		
		ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void run() {
			String name = "";
			
			try {
				name = in.readUTF();
				sendToAll("#" + name + "님이 들어오셨습니다.");
				
				clients.put(name, out);
				System.out.println("현재 서버 접속자 수는 " + clients.size() + "입니다.");
				
				while (in != null) {
					sendToAll(in.readUTF());
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//
				sendToAll("#" + name + "님이 나가셨습니다.");
				clients.remove(name);	// 접속자 (map) 목록에서 제거
				System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "] 에서 접속을 종료하였습니다.");
				System.out.println("현재 서버 접속자 수는 " + clients.size() + "입니다.");
			}
		}
	}
}
