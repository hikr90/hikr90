package ex1_control_statement;

import java.util.Scanner;

public class Ex2_if_else {
	public static void main(String[] args) {
		
		
		// if else ��
		// - �ϳ��� �������� ������ ���� ���� �� �ܿ� �ش��ϴ� ��� �ΰ����� ����� ���� �� �ִ� ����
		int n = 45;
		String str = "";
	
		if(++n >= 50) {
			str = "50�̻��� ��";
		} else {
			str = "50�̸��� ��";
		}
	
		System.out.println(str);
		
		System.out.println("------------------");
		
		// ���� 1
		// - ���� age�� ���̸� �����Ͽ� 30 �̻��� ���, "��Ǹ�ŭ ��̱���"
		// - �׷��� ���� ��� "���� ��ٸ��ž߰ڳ׿�." �� ����ϴ� if else �� �ۼ�
		int age = 0;
		String word = "";
		
		if(age>=30) {
			word = "��Ǹ�ŭ ��̱���.";
		}else {
			word = "���� ��ٸ��ž߰ڳ׿�.";
		}
		System.out.println(word);
		
		System.out.println("------------------");

		// ����2
		// - ���� if else���� ���׿����ڷ� ����
		String res = age >= 30 ? "��Ǹ�ŭ ��̱���." : "���� ��ٸ��ž߰ڳ׿�.";
		System.out.println(res);
		
		// ����3
		// - ���� ������ ��ĳ�� ������� ���� ���� �޴´�.
		Scanner sc = new Scanner(System.in);
		int age_s = 0;
		System.out.println("���̸� �Է��ϼ���. : ");
		
		age_s = sc.nextInt();
		
		if(age_s==30){
			System.out.println("��Ǹ�ŭ ��̱���.");
		}else {
			System.out.println("���� �� ��ٸ��ž߰ڳ׿�.");
		}
	}
}
