package ex1_method;

import java.util.Scanner;

public class Ex8_Work {

	public static void main(String[] args) {
		
		// ����
		// - ȸ������ �����ּ���.
		// - ȸ������ ������ �о �ڷ� �о �Ȱ��� ������ �����Դϴ�.

		// - �Է� : a1b1a
		// - ��� : a1b1a��(��) ȸ�����Դϴ�.
		
		// - �Է� : aabb
		// - ��� : aabb��(��) ȸ������ �ƴմϴ�.
		Scanner sc = new Scanner(System.in);
		System.out.println("�Է� : ");
		String ori = sc.next();
		String rev = "";				// �ؿ��� += �� ���� �ٿ�����ϹǷ� "" ó���� ������Ѵ�. (null : �������� ���� / "" : ����� ä���� ����)
		//
		for(int j=ori.length()-1;j>=0;j--) {
			rev += ori.charAt(j);
		}
		//
		if(ori.equals(rev)) {
			System.out.println(ori+"�� ȸ�����Դϴ�.");
		}else {
			System.out.println(ori+"�� ȸ������ �ƴմϴ�.");
		}
	}
}
