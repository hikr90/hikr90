package ex2_control_statement;

import java.util.Scanner;

public class Ex4_singleFor {

	public static void main(String[] args) {
		
		// ����
		// - Ű���忡�� n1�� n2�� ������ �޽��ϴ�.
		// - n1 ~ n2 ������ ���� ����Ͽ� ����� �����ݴϴ�.
		// - ����, 2�� 5�� �Է¹޾Ҵٸ� ����� 14�� ��ȯ�մϴ�.
		// - ��, n1�� n2�� ���� �ݴ�� �ԷµǾ ����� �Ȱ��� ���;��մϴ�.
		
		// - ��1 : 2
		// - ��2 : 5
		// - ��� : 14

		// ������ ��ȯ�� ���� �ۼ�
		Scanner sc = new Scanner(System.in);
		System.out.println("��1 : ");
		int num1 = sc.nextInt();

		System.out.println("��2 : ");
		int num2 = sc.nextInt();
		int num3 = 0;
		int total = 0;

		// ������ ��ȯ (1�� 3����, 2�� 1��, 3�� 2�� �̵�)
		if (num1 > num2) {
			num3 = num1;
			num1 = num2;
			num2 = num3;
		}
		
		for (int i = num1; i <= num2; i++) {
			total += i;
		}
		
		System.out.println(total);
	}
}
