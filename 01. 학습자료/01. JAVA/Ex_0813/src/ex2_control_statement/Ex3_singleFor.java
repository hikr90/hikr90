package ex2_control_statement;

import java.util.Scanner;

public class Ex3_singleFor {

	public static void main(String[] args) {

		// ���� Ű���忡�� ����n�� �Է¹޽��ϴ�. 
		// 1���� n������ ���� ����Ͽ� ����� ����Ѵ�.
		// ���� 5�� �޾Ҵٸ� 1+2+3+4+5�� ����� 15�� ��µǸ� �ȴ�.
		// ���� : 4
		// ��� : 10

		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int num = sc.nextInt();
		int total = 0;


		for(int i=1;i<=num;i++) {
			total += i;
		}
		System.out.println("��� : "+total);

	
	/* ������
	 Scanner sc = new Scanner(System.in);
	 System.out.print("���� : ");
	 int n = sc.nextInt();
	 
	 // 1���� �Է°������� ���� ������ ����
	 int total = 0;
	 
	 for(int i=1;i<=n;i++){
		total += i;
	 }
	 System.out.print("��� : "+total);
	 */
	
	
	
	
	
	}
}
