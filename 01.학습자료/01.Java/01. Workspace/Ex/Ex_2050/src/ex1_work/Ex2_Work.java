package ex1_work;

import java.util.Scanner;

public class Ex2_Work {

	public static void main(String[] args) {
		
		// ����
		// - Ű���忡�� ���� ���� �Է¹޽��ϴ�.
		// - ���� ���̸� �����, 
		// - ������ �ƴ� ���� �Է��Ѵٸ� "������ �Է��� �� �ֽ��ϴ�." ��� ������ ������ּ���.
		Scanner sc = new Scanner(System.in);
		System.out.println("���� : ");
		int num = 0;
		//
		try {
			//
			num = sc.nextInt();
			System.out.println("��� : "+num);
		
		} catch (Exception e) {
			System.out.println("������ �Է��� �� �ֽ��ϴ�.");
		}
	}
}
