package ex2_socket;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex2_Server {
	public static void main(String[] args) {
		// [����] TCP/IP ���� ����
		ServerSocket serverSocket = null;
		
		try {
			// ���������� �����Ͽ� 7777 ��Ʈ�� ����
			serverSocket = new ServerSocket(7777);
			System.out.println(getTime() + " ������ �غ�Ǿ����ϴ�.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		while(true) {
			try {
				System.out.println(getTime() + " �����û�� ��ٸ��ϴ�.");
				
				// ��û �ð� ��� (��û �ð����� ���� ��û�� ������ SocketTimeoutException)
				// ���� 0�� ���, ���ѽð����� ����Ѵ�.
				serverSocket.setSoTimeout(5*1000);
				
				// ���� ���� ����
				Socket socket = serverSocket.accept();
				
				System.out.println(getTime() + socket.getInetAddress() + "�κ��� ���� ��û�� ���Խ��ϴ�.");
				System.out.println("getPort() : " + socket.getPort());		// ���� (Ŭ���̾�Ʈ) ������ ��Ʈ (��밡���� ������ ��Ʈ ��ȣ)
				System.out.println("getLocalPort() : " + socket.getLocalPort()); 	// ���� �ڽ��� ����ϴ� ��Ʈ
				
				// ���� ������ ��� ��Ʈ�� ����
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				// ���� ���Ͽ� ������ ����
				dos.writeUTF("[Notice] Test Message1 from Server.");
				System.out.println(getTime() + " �����͸� �����߽��ϴ�.");
				
				// ���� ����
				dos.close();
				socket.close();

			} catch (SocketTimeoutException e) {
				System.out.println("������ �ð����� ���� ��û�� ����, ������ �����մϴ�.");
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
