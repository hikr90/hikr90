package ex6_work;

import java.util.Scanner;

public class Ex1_Work {
	public static void main(String[] args) {
			
		// ����
		// - Ű���忡�� ���� ���� �Է¹ް� Test Ŭ������ �����Ͽ�
		// - run �޼ҵ忡�� �Է¹��� ���� 1�� ���ҽ�Ű�ٰ� 0�� �Ǿ��� �� �����带 �������� ó�����ּ���.
		Scanner sc = new Scanner(System.in);
		System.out.println("�Է� : ");
		int num = sc.nextInt();
		//
		Ex2_Work t = new Ex2_Work(num);
		Thread th = new Thread(t);
		th.start();
	}
}
