package ex1_try_catch;

import java.util.Scanner;

public class Ex3_Try_Catch {
	
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
