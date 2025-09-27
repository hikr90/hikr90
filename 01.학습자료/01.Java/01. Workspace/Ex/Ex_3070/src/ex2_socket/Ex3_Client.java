package ex2_socket;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class Ex3_Client {
	public static void main(String[] args) {
		// [����] TCP/IP Ŭ���̾�Ʈ ����
		try {
			String ip = "127.0.0.1";
			System.out.println("������ ���� ���Դϴ�. ���� IP : " + ip);
			
			// ���� ����
			Socket socket = new Socket(ip, 7777);
			
			// ���� �Է� ��Ʈ��
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			// �������κ��� ���� ������ ���
			System.out.println("�����κ��� ���� �޼��� : " + dis.readUTF());
			System.out.println("������ �����մϴ�.");
			
			// ���� ����
			dis.close();
			socket.close();
				
			System.out.println("������ ����Ǿ����ϴ�.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
