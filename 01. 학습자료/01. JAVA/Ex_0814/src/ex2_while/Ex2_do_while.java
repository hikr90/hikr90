package ex2_while;

import java.util.Random;

public class Ex2_do_while {
	
	public static void main(String[] args) {
		
		/* do-while : ��ó�� ,�� ��
		����� �����ϰ� ;���� ������.
		
		do{
		���ǽ��� ���� �� ����Ǵ� ����
		}while(���ǽ�);
		
		
		while�� do-while��  ����
		while�� ���ǰ��� ������ ���, ���๮�� ��������������
		do while�� �ϴ� �ѹ� ó���� ��, �������� �Ǻ��ϹǷ� �����̴��� �ѹ��� ����ȴ�. 
		*/

		int i = 11;
		
		do {
			System.out.println(i);
			
		}while(i<=10);
	
	System.out.println("------------------");
	
	/* ���� java, jsp, android�� ������ �ô�. 
	 ������ ������ �������� 0~130���� �����Ѵ�.
	 �� ������ �˻縦 do-while�� �����ϴµ� 0~100������ ������ �ƴ� ��쿡�� �ݵ�� 0 ~ 100 ������ ���� ���� ������ �ڵ����� ����� ��ų ��
	 �̷��� �� ������ ������ 0���� 100���̰� �Ǹ� do while�� �������� ���� ������ ȭ�鿡 ���
	 
	java : 96
	jsp : 95
	android : 99 
	 */
	
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
	
		
	}while(java>100||jsp>100||and>100);
	
	
	
	}
}
