package ex3_work;

import java.util.Scanner;

public class Ex1_Work {

	public static void main(String[] args) {
		
		// ����
		// - Ű���忡�� ������ �Է¹޽��ϴ�.
		// - �� ���� �Ҽ� (����� 1�� �ڱ��ڽŸ� �����ϴ� ��) ������ �Ǵ��մϴ�.
		
		// - ���� : 3
		// - ��� : 3��(��) �Ҽ��Դϴ�.
		
		// - ���� : 4
		// - ��� : 4��(��) �Ҽ��� �ƴմϴ�. 
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int n = sc.nextInt();
		int i = 0;
		//
		for(i=2;i<=n;i++) {
			//
			if(n%i==0) {
				break;
			}
		}
		//
		if(i==n) {
			System.out.println(n+"�� �Ҽ��̴�.");
		}else {
			System.out.println(n+"�� �Ҽ��� �ƴϴ�.");
		}
	}
}
