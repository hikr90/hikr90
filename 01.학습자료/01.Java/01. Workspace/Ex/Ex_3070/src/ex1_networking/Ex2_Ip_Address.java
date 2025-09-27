package ex1_networking;

import java.net.InetAddress;
import java.util.Arrays;

public class Ex2_Ip_Address {
	public static void main(String[] args) {
		/*		Ip Address
		 * 			- ��ǻ�� (host)�� �����ϴµ� ���Ǵ� ������ ��
		 * 			- CMD���� ipconfig ��ɾ�� ��ȸ �����ϴ�.
		 */
		InetAddress ip = null;
		InetAddress[] ipArr = null;
		
		try {
			// ������(host)�� ���ؼ� IP�ּҸ� �޴´�.
			ip = InetAddress.getByName("www.naver.com");
			System.out.println("getHostName : " + ip.getHostName());				// ȣ��Ʈ ��
			System.out.println("getHostAddress : " + ip.getHostAddress());		// ȣ��Ʈ �ּ�
			System.out.println("toString : " + ip.toString());
			
			byte [] ipAddr = ip.getAddress();
			System.out.println("getAddress : " + Arrays.toString(ipAddr));
			
			String result = "";
			for (int i = 0; i < ipAddr.length; i++) {
				result += (ipAddr[i] < 0) ? ipAddr[i] + 256 : ipAddr[i];
				result += ".";
			}
			
			System.out.println("getAddress + 256 :  " + result);
			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		try {
			// ���� ȣ��Ʈ�� IP�ּҸ� ��ȯ�Ѵ�.
			ip = InetAddress.getLocalHost();
			System.out.println("getHostName : " + ip.getHostName());
			System.out.println("getHostAddress : " + ip.getHostAddress());
			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		try {
			// ������ (host)�� ������ ��� ȣ��Ʈ�� IP�ּҸ� �迭�� ��� ��ȯ�Ѵ�.
			ipArr = InetAddress.getAllByName("www.naver.com");
			
			for (int i = 0; i < ipArr.length; i++) {
				System.out.println("ipArr[" + i + "] : " + ipArr[i]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
