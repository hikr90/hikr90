package ex2_control_statement;

import java.util.Scanner;

public class Ex4_singleFor {

	public static void main(String[] args) {

		// ���� Ű���忡�� n1�� n2�� �������� �Է¹޴´�.
		// n1 ~ n2������ ���� ����Ͽ� ����� ���
		// 2�� 5�� �Է¹޾Ҵٸ� 14�� ���
		// ��, n1�� n2�� ���� �ݴ�� �ԷµǾ ����� �Ȱ��� �������� ó��

		// ��1 : 2
		// ��2 : 5
		// ��� : 14

		// for�� 2���� �ۼ�
		// Scanner sc = new Scanner(System.in);
		// System.out.println("��1 : ");
		// int num1 = sc.nextInt();
		//
		// System.out.println("��2 : ");
		// int num2 = sc.nextInt();
		//
		// int total = 0;
		//	
		// if(num1<num2) {
		// for(int i = num1;i<=num2;i++) {
		// total += i;
		// 	}
		// }else if(num1>num2) {
		// for(int j = num1;j>=num2;j--) {
		// total += j;
		// 	}
		// }
		// System.out.println("��� : "+total);

		// ������ ��ȯ�� ���� �ۼ�
		Scanner sc = new Scanner(System.in);
		System.out.println("��1 : ");
		int num1 = sc.nextInt();

		System.out.println("��2 : ");
		int num2 = sc.nextInt();
		int num3 = 0;
		int total = 0;

		// ������ ��ȯ (1�� 3����, 2�� 1��, 3�� 2�� �̵�
		if (num1 > num2) {
			num3 = num1;
			num1 = num2;
			num2 = num3;
		}
		for (int i = num1; i <= num2; i++) {
			total += i;
		}
		System.out.println(total);

		/*������
	 Scanner sc = new Scanner(System.in);
	 System.out.print("��1 : ");
	 int su1 = sc.nextInt();

	 System.out.print("��2 : ");
	 int su2 = sc.nextInt();
	 int su3 = 0;

	 int total = 0;

	 if(su1>su2){
	 	su3 = su1
	 	su1 = su2
	 	su2 = su3
	 }


	 for(int i = su1; i<=su2;i++){
	 	total += i;
	 }
	 System.out.print("��� : "+total);
		 */


	}

}
