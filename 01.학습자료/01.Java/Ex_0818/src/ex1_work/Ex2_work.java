package ex1_work;

import java.util.Scanner;

public class Ex2_work {

	public static void main(String[] args) {
		
		/* ���� 
		��� 
		�迭�� ���� : 5
		��� �Է��ϸ� 5���� �迭�� �־ ���������� ���ĺ��� �־�����Ѵ�. 
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�迭�� ���� : ");
		int num = sc.nextInt();
		char n = 'A';
		
		for(int i=0;i<num;i++) {
			int [] len = new int[num];
			len[i] = n++;
			System.out.print((char)len[i]);
		} */
		
		 /* ������  (�ƽ�Ű�ڵ� ���� ���) */
		 Scanner sc = new Scanner(System.in);
		 System.out.print("�迭�� ���� : ");
		 int n = sc.nextInt();
		 char c = 'A';
		 
		 char[] ch = new char[n];
		
		 for(int i=0;i<n;i++) {
			 System.out.print(ch[i]=(char)(c+i));
			
		 }
		
	}
}
