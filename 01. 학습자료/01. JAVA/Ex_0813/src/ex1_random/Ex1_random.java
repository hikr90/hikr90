package ex1_random;

import java.util.Random;

public class Ex1_random {
	
	public static void main(String[] args) {
		
		/* ����(random) ���� 
		 Random Ŭ������ ������ �߻���Ų��. 
		 Random�� �����ڵ��� ������ ��ĳ�ʰ��� Ŭ�����Ƿ� ��ĳ�ʿ� ���������� ���� java.util�̶�� ��Ű���� Ramdom�� import(��� �㰡) �ؾ��Ѵ�.
		 
		 ��) 1���� 4 ������ ���� �߻� 
		new Random().nextInt(�߻��� ������ ������)+���ۼ� */
		int num = new Random().nextInt(4) + 1;
		
		// 1�� 4 ���̿� ������ ���ڰ� ���´�.
		System.out.println(num);
		
		// 1211 ~ 12134������ ���� �߻�
		// new Random().nextInt(ū �� ���� ��+1)+���ۼ�
		num = new Random().nextInt(12134-1211+1)+1211;
		System.out.println(num);
		
		// ��� : F(A���� Z������ �������� ������ ����)
		int num2 = new Random().nextInt(90-65+1)+65;
		System.out.println((char)num2);
		
		// ������ ���ڷε� �����ϴ�.
		int num3 = new Random().nextInt('Z'-'A'+1)+'A';
		System.out.println((char)num3);

	}
}
