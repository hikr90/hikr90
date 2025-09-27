package ex2_socket;

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
		/*		[����] ������ �����带 �̿��� ���� �۾� ó��	
		 * 			- ������ �����ϴ� Ŭ���̾�Ʈ�� ���� ���� ��쿡�� �����带 ����ؼ� Ŭ���̾�Ʈ�� ��û�� ���������� ó���Ѵ�.
		 * 			- �����带 ������� �ʴ� ��� ������ ������ ��û�� ������� ó���ϱ� ������ �ʰ� ������ ��û�� Ŭ���̾�Ʈ�� ���� �ð��� ��ٸ� ���� �ִ�.
		 */
		
		// ������ 5�� ����
		Ex4_Socket_Thread server = new Ex4_Socket_Thread(5);
		server.start();
	}
	
	public Ex4_Socket_Thread(int num) {
		try {
			//  ���� ������ �����Ͽ� 7777�� ��Ʈ�� ����
			serverSocket = new ServerSocket(7777);
			System.out.println(getTime() + " ������ �غ�Ǿ����ϴ�.");
			
			// ������ ����
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
				System.out.println(getTime() + " �����û�� ��ٸ��ϴ�.");
				
				Socket socket = serverSocket.accept();
				System.out.println(getTime() + " " + socket.getInetAddress() + "�κ��� ���� ��û�� ���Խ��ϴ�.");
				
				// ������ ��� ��Ʈ�� ����
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				// ���� ���Ͽ� ������ ����
				dos.writeUTF("[Notice] Test Message1 from Server.");
				System.out.println(getTime() + " �����͸� �����߽��ϴ�.");
				
				// ���� ����
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
