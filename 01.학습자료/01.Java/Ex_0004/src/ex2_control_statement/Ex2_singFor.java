package ex2_control_statement;

import java.util.Scanner;

public class Ex2_singFor {

	public static void main(String[] args) {
		
		// ����
		// - Ű���忡�� 2 ~ 9 ������ ���ڸ� �Է¹ް� �Է¹��� ������ �������� �ֿܼ� �����ּ���.
		// - �� ���� ���� 2 ~ 9 ������ ���ڰ� �ƴ� ��� "2 ~ 9 ������ ���ڸ� �Է����ּ���." ��� ������ �����ּ���.
		 Scanner sc = new Scanner(System.in);
		 System.out.print("�� : ");
		 int dan = sc.nextInt();
		 
		 if(dan<=1 || dan>=10){
		 	System.out.println("2 ~ 9������ ���ڸ� �Է��ϼ���.");
		 }else{
		 	for(int i=1;i<=9;i++){
		 		System.out.printf("%d * %d = %d\n",dan,i,dan*i);
		 	}
		 }
	}
}
