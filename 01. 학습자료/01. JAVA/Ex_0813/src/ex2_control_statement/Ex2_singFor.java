package ex2_control_statement;

import java.util.Scanner;

public class Ex2_singFor {

	public static void main(String[] args) {

		// ���� : Ű���忡�� 2 ~ 9�� �Ѱ����� �Է¹ް� �Է¹��� ������ �ش�Ǵ� �������� ����ϼ���.
		// �� 2~9���� ���ڰ� �Էµ��� �ʾ��� ��� "2~9������ ���ڸ� �Է����ּ���."

		Scanner sc = new Scanner(System.in);
		System.out.print("�� : ");
		int i = sc.nextInt();

		if(i>=2&&i<=9) {

			for(int j=1;j<=9;j++) {
				System.out.printf("%d * %d = %d\n",i,j,i*j);
			}
		}else {
			System.out.println("2 ~ 9 ������ ���ڸ� �Է��ϼ���.");
		}

	/* ������
	 Scanner sc = new Scanner(System.in);
	 System.out.print("�� : ");
	 int dan = sc.nextInt();
	 
	 if(dan<=1||dan>=10){
	 	System.out.println("2 ~ 9������ ���ڸ� �Է��ϼ���.");
	 }else{
	 	for(int i=1;i<=9;i++){
	 		System.out.printf("%d * %d = %d\n",dan,i,dan*i);
	 	}
	 }
	 */
	
	
	}
}
