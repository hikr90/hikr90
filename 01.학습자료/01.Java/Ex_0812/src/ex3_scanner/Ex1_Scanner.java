package ex3_scanner;

// IMPORT�� ���� ���� ��� CTRL+SHIFT+O�� IMPORT�� �����ϴ�.
import java.util.Scanner;


public class Ex1_Scanner {
	public static void main(String[] args) {
		
		/* 
		Scanner : �Է°��� �޴� Ŭ����
		:: Ű���忡�� ���� �Է¹޾� �����ϱ� ���� Ŭ����
		:: �Է¹޴� ���� sc�� �����Ѵ�.
		:: scanner Ŭ������ java.utll.scanner��� ��Ű���� �ִ�, �׷��� �����پ������ؼ� import��� ������ �־���Ѵ�.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		// ����� ���Ǹ� ���� �Է°������� ����
		System.out.print("������ �Է��ϼ���. : ");
		
		// Ű���� �����κ��� �������� �޾�, n�̶�� ������ ����
		int n = sc.nextInt();
		// ������ �� 
		System.out.print("�Է¹��� �� : "+n);
	
		// scanner�� ���ڿ����� StringŸ�Ը� �޴´�.
		System.out.print("������ �Է����ּ���. : ");
		// Ű���尪���κ��� ���ڸ� �޾�(����� ������� ���ڷ� �޴´�.), s������ ����
		String s = sc.next();
		
		System.out.print("�Է¹��� �� : "+s);
	}
}
