package ex1_work;

import java.util.Scanner;

public class Ex2_work {

	public static void main(String[] args) {
		
		// ����
		// - �迭�� ���� ���� �־��ָ� ���������� ���ĺ��� �����ּ���.
		// - �迭�� ���� : 5
		// - ABCDE
		 Scanner sc = new Scanner(System.in);
		 System.out.print("�迭�� ���� : ");
		 int n = sc.nextInt();
		 char c = 'A';
		 //
		 char[] ch = new char[n];
		 //
		 for(int i=0;i<n;i++) {
			 System.out.print(ch[i]=(char)(c+i));
		 }
	}
}
