package ex4_work;

import java.util.Scanner;

public class GuguMain {

	public static void main(String[] args) {
		
		// Ű���忡�� ����� ���� �Է¹޾�, �ش� ���� showTable()�� ���� ȭ�鿡 ����Ͻÿ�.
		// �������� 2�ܿ��� 9�ܸ� ���������ϰ� ���� �ش��ϴ� ���� ������ ������ "��Ȯ�� ���ڸ� �Է����ּ���."��� ���������ּ���.
		Scanner sc = new Scanner(System.in);
		System.out.println("�� : ");
		int dan = sc.nextInt();
		
		Gugudan gu = new Gugudan();
		
		gu.showTable(dan);
		
	}
}
