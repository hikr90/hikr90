package ex5_work;

import java.util.Scanner;

public class Ex2_Work {

	public static void main(String[] args) {
		
		// Ű���忡�� ����� ���� �Է¹޾�, �ش� ���� showTable()�� ���� ȭ�鿡 ����Ͻÿ�.
		// �������� 2�ܿ��� 9�ܸ� ���������ϰ� ���� �ش��ϴ� ���� ������ ������ "��Ȯ�� ���ڸ� �Է����ּ���."��� ���������ּ���.
		Scanner sc = new Scanner(System.in);
		System.out.println("�� : ");
		int dan = sc.nextInt();
		
		Ex1_Work gu = new Ex1_Work();
		
		gu.showTable(dan);
		
	}
}
