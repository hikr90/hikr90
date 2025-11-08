package ex5_udp_socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Ex1_Client {
	public static void main(String[] args) {
		/*		UDP 소켓 프로래밍
		 * 		- 단방향 프로토콜
		 * 		- DatagramSocket에 데이터를 DatagramPacket에 담아서 전송
		 * 
		 *  		# DatagramPacket
		 *  			- 헤더, 데이터로 구성
		 *  			- 헤더에는 패킷을 수신할 호스트의 정보 (주소, 포트) 가 저장되어있다.
		 */
		 try {
			new Ex1_Client().start();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void start() throws Exception {
		DatagramSocket datagramSocket= new DatagramSocket();
		InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
		
		// 데이터가 저장된 공간으로 byte [] 를 생성한다.
		byte [] msg = new byte[100];
		
		DatagramPacket outPacket = new DatagramPacket(msg, 1, serverAddress, 7777);
		DatagramPacket inPacket = new DatagramPacket(msg,  msg.length);
		
		datagramSocket.send(outPacket);
		datagramSocket.receive(inPacket);
		
		System.out.println("current server time : " + new String(inPacket.getData()));
		
		datagramSocket.close();
	}
}
