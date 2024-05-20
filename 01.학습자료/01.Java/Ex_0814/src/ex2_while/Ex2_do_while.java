package ex2_while;

import java.util.Random;

public class Ex2_do_while {
	
	public static void main(String[] args) {
		
		/*	do-while
		 *		- ó�� �ѹ��� ������ �����ϴ� ��ó�� �� �� ����� while��
		 *		- ��� �� �����ϰ� ; ���� ������.
		 *		
		 *		do {
		 *				���ǽ��� ���� �� �����ϴ� ����
		 *		} while (���ǽ�)
		 *
		 *	[����] while�� do-while�� ����
		 *		- while�� ���� ���� ������ ��� ���๮�� �������� ������
		 *		- do-while�� �� ó�� �� �� ����̹Ƿ� ������ �����̶� ó�� �ѹ��� �����ϰ� �ȴ�.
		 *
		 */
		int i = 11;
		
		do {
			System.out.println(i);
			
		} while(i<=10);
	
		System.out.println("------------------");

		// ����
		// - java, jsp, android�� ������ �����߽��ϴ�.
		// - �� ���� ������ 0 ~ 130���� ������ ���ɴϴ�.
		// - �� ������ �˻縦 do-while�� �����ϴµ� 0 ~ 100 ������ ������ �ƴ� ���� 0 ~ 100 ������ ���� ���� ������ ��� �ݺ��ؾ��մϴ�.
		// - �ݺ� �۾��� ���ؼ� �� ������ ������ 0 ~ 100 ���̰� �Ǹ� do while�� �������� ���� ������ ȭ�鿡 �����ּ���.
		int java = 0;
		int jsp = 0;
		int and = 0;
		
		do {
	
			java = new Random().nextInt(130-0+1)+0;
			jsp = new Random().nextInt(130-0+1)+0;
			and = new Random().nextInt(130-0+1)+0;
					
			System.out.println("java : "+java);
			System.out.println("jsp : "+jsp);
			System.out.println("and : "+and);
			
		} while(java>100||jsp>100||and>100);
	}
}
