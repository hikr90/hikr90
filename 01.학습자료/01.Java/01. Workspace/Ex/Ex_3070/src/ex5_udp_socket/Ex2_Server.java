package ex5_udp_socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex2_Server {
	public void start() throws Exception {
		// 포트 7777을 사용하는 소켓 생성
		DatagramSocket socket = new DatagramSocket(7777);
		DatagramPacket inPacket, outPacket;
		
		byte [] inMsg = new byte[10];
		byte [] outMsg;
		
		while (true) {
			// 데이터 수신을 위한 패킷 생성
			inPacket = new DatagramPacket(inMsg, inMsg.length);
			
			// 패킷을 통해서 데이터 수신
			socket.receive(inPacket);
			
			// 수신한 패킷으로부터 client의 ip, port 수신
			InetAddress address = inPacket.getAddress();
			int port = inPacket.getPort();
			
			// 서버의 현재 시간을 시분초로 반환
			SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
			String time = sdf.format(new Date());
			outMsg = time.getBytes(); 	// time을 byte [] 로 반환
			
			// 패킷을 생성해서 client에게 전송
			outPacket = new DatagramPacket(outMsg, outMsg.length, address, port);
			socket.send(outPacket);
		}
	}
	
	public static void main(String[] args) {
		try {
			// UDP 서버 동작
			new Ex2_Server().start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
