package ex2_work;

import java.util.Scanner;

public class Ex2_work {

	public static void main(String[] args) {

		/*
		 ���� :: switch���� �̿��� ����
		 �� 1 : 15
		 ��2 : 5
		 ������ : + 
		 15 + 5 = 20
		 (����ġ ���)
		 */

		Scanner sc = new Scanner(System.in);
		System.out.println("��1 : ");
		int num1 = sc.nextInt();

		System.out.println("��2 : ");
		int num2 = sc.nextInt();

		System.out.println("������ : ");
		String s = sc.next();

		switch (s) {
		case "+":
			System.out.println(num1+num2);
			break;

		case "-":
			System.out.println(num1-num2);
			break;

		case "/" :
			System.out.println(num1/num2);
			break;

		case "*" :
			System.out.println(num1*num2);
			break;
		
		default:
			System.out.println("��Ȯ�� �����ڸ� �Է����ּ���.");
			break;
		}

	}
}
