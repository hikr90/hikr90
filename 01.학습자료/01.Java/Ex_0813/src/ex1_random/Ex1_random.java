package ex1_random;

import java.util.Random;

public class Ex1_random {
	
	public static void main(String[] args) {
		
		/*	����
		 *		- ���� Ŭ������ ������ �����ϴµ� ���ȴ�.
		 *		- ���� ���� java.util ���� Ŭ������ �ش� ��Ű���� import ó���Ǿ���Ѵ�.
		 */
		 
		// new Random().nextInt(������ ����) + ���� ��
		int num = new Random().nextInt(4) + 1;
		
		// 1 ~ 4 ������ ����
		System.out.println(num);
		
		// 1211 ~ 12134 ������ ����
		num = new Random().nextInt(12134-1211+1)+1211;
		System.out.println(num);
		
		// �ƽ�Ű�ڵ带 ����Ͽ� A ~ Z ������ ����
		int num2 = new Random().nextInt(90-65+1)+65;
		System.out.println((char)num2);
		
		// ���ڷ� ���� �߻�
		int num3 = new Random().nextInt('Z'-'A'+1)+'A';
		System.out.println((char)num3);

	}
}
