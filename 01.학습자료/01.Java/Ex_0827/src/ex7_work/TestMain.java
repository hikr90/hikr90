package ex7_work;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
				
		/* ����
		  	Ű���忡�� �������� �Է¹ް� TestŬ������ �����ϸ� 
		 
		 run�޼��忡�� �Է¹��� ���ڸ� 1�� ���ҽ�Ű�ٰ� 
		 0�� �Ǿ��� ��, �����带 ������������ ó��
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("�Է� : ");
		int num = sc.nextInt();
				
		Test t = new Test(num);
		Thread th = new Thread(t);
		th.start();
		
		
		
		
		
		
		
		
	}
}
