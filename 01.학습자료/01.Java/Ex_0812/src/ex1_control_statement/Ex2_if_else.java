package ex1_control_statement;

import java.util.Scanner;

public class Ex2_if_else {
	public static void main(String[] args) {
		
		/*
		 if-else �� : �ϳ��� ������ ������ �ΰ����� ����� ���� �� �ִ�.
		 
		 if(���ǽ�){
		 ���ǽ��� ���� ��� ����Ǵ� ����
		 }else{
		 ���ǽ��� ������ ��� ����Ǵ� ����
		 }
		 */

	int n = 45;
	String str = "";
	
	if(++n >= 50) {
		str = "50�̻��� ��";
	}else {
		str = "50�̸��� ��";
	}
	
	System.out.println(str);
	
	System.out.println("------------------");
	
	// ���� :: ���� age�� ���̸� �����ϰ�, 30�� �̻��̸� "��Ǹ�ŭ ��̱���."��, �׷��� ������ "���� ��ٸ��ž߰ڳ׿�."�� ����ϴ� if���� �ۼ�
	int age = 0;
	String word = "";
	
	if(age>=30) {
		word = "��Ǹ�ŭ ��̱���.";
	}else {
		word = "���� ��ٸ��ž߰ڳ׿�.";
	}
	System.out.println(word);
	
	System.out.println("------------------");

	// ���� :: �ٷ� ���� ���� �ڵ带 ���� �����ڷ� �ٲٽÿ�.
	// ���ڿ�(String) "" / ����(char) ''
	String res = age >= 30 ? "��Ǹ�ŭ ��̱���." : "���� ��ٸ��ž߰ڳ׿�.";
	System.out.println(res);
	
	
	// Scanner�� ���ؼ� ���̸� ���� �޴� ���
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
