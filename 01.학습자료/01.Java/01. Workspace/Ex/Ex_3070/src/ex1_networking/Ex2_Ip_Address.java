package ex1_networking;

import java.net.InetAddress;
import java.util.Arrays;

public class Ex2_Ip_Address {
	public static void main(String[] args) {
		/*		Ip Address
		 * 			- 컴퓨터 (host)를 구별하는데 사용되는 고유한 값
		 * 			- CMD에서 ipconfig 명령어로 조회 가능하다.
		 */
		InetAddress ip = null;
		InetAddress[] ipArr = null;
		
		try {
			// 도메인(host)을 통해서 IP주소를 받는다.
			ip = InetAddress.getByName("www.naver.com");
			System.out.println("getHostName : " + ip.getHostName());				// 호스트 명
			System.out.println("getHostAddress : " + ip.getHostAddress());		// 호스트 주소
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
			// 지역 호스트의 IP주소를 반환한다.
			ip = InetAddress.getLocalHost();
			System.out.println("getHostName : " + ip.getHostName());
			System.out.println("getHostAddress : " + ip.getHostAddress());
			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		try {
			// 도메인 (host)에 지정된 모든 호스트의 IP주소를 배열에 담아 반환한다.
			ipArr = InetAddress.getAllByName("www.naver.com");
			
			for (int i = 0; i < ipArr.length; i++) {
				System.out.println("ipArr[" + i + "] : " + ipArr[i]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
