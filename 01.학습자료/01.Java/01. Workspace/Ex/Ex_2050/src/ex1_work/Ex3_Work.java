package ex1_work;

import java.util.Scanner;

public class Ex3_Work {
	
	// ����
	// - ������ �޾��ְ� ����� �����ּ���.
	// - ���� : aa
	// - ��� : aa��(��) ������ �ƴմϴ�.
	public static void main(String[] args) {
		//
		Scanner sc = new Scanner(System.in);
		System.out.println("���� : ");	
		String num = sc.next();
		//
		try {			
			//
			Integer.parseInt(num);
			System.out.println("��� : "+num);
		
		} catch (Exception e) {
			System.out.println(num+"��(��) ������ �ƴմϴ�.");
		}
	}
}
