package ex1_string;

import java.util.Scanner;

public class Ex3_StringWork {

	public static void main(String[] args) {
		
		
		/* ���� 
		 Ű���忡�� next�� ���ؼ� ������ �Է¹ް� �Է¹��� ���忡�� �ҹ��� a�� � �ִ����� �������
		 
		 ���
		 �Է� : sdfkleisdalsldkaa
		 
		 a�� ���� : 2 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�Է� : ");
		String s = sc.next();
		int count = 0;
		
		for(int i=0;i<s.length();i++) {
			
			if(s.charAt(i)=='a') {
				count++;
			}
		}
		
		System.out.println("a�� ���� : "+count); 
		
		/* ������ 
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
		
		*/
		
		
		
	}
}
