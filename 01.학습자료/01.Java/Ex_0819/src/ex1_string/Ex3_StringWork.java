package ex1_string;

import java.util.Scanner;

public class Ex3_StringWork {

	public static void main(String[] args) {
		
		// ����
		// - Ű���忡�� ������ �Է¹ް� ���忡�� �ҹ��� a�� � �ִ��� ǥ�����ּ���.
		// - �Է� : sdfkleisdalsldkaa
		// - ��� : a�� ���� : 2
		Scanner sc = new Scanner(System.in);
		int cnt = 0; 
		
		System.out.print("�Է� : ");
		String str = sc.next();
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='a') {
				cnt++;
			}
		}
		System.out.println("a�� ���� : "+cnt);
	}
}
