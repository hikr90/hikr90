package ex5_anonymous;

import java.util.Random;
import java.util.Scanner;

public class Ex1_Anony {
	
	public static void main(String[] args) {

		/* �͸� Ŭ���� 
		 * 	- �̸��� ���� Ŭ����
		 * 	- ����� ���ÿ� ��ü�� �����Ѵ�.
		 * 	- �̸��� ��� �����ڸ� ������ �� ������ �� �ϳ��� �������̽��� Ŭ������ ��� �� ������ �����ϴ�.
		 * 
		 * 	- ����ؼ� �޸𸮸� ����ϴ� �Ϲ����� Ŭ���� ����� �ٸ��� ��ȸ������ ��� �����ϴٴ� ������ ������, �ڵ� �������� �������ٴ� ������ �ִ�.
		 * 	- �ѹ��� ���� �������� ���� �͸�Ŭ������ ����, ���������� ���Ǵ� ���̶�� �Ϲ����� Ŭ������ �����Ͽ� ����ϴ� ���� ����.
		 */
		// ��ĳ��
		// (1) �Ϲ����� Ŭ����
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		// (2) �͸� Ŭ����
		int a = new Scanner(System.in).nextInt();

		// ����
		// (1) �Ϲ����� Ŭ����
		Random random = new Random(); 
		int rnd = random.nextInt(10)+1; 
		
		// (2) �͸� Ŭ����
		int r = new Random().nextInt(10)+1;
		r = new Random().nextInt(10)+1;
	}
}
