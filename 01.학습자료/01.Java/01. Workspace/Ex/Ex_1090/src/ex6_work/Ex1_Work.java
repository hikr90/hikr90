package ex6_work;

import java.util.Random;

public class Ex1_Work {

	public static void main(String[] args) {
		
		// ����
		// 	- 0 ~ 9 ������ ������ 100�� �����Ѵ�.
		// 	- �߻��� ������ ���ؼ� �Ʒ��� ����� �����Ѵ�.
		// 
		// 	- ��� : 1240912850198309128310901...
		// 	- 0�� ���� : ### 3
		// 	- 1�� ���� : ##### 5
		// 	- 2�� ���� : # 1 
		// 	- ....
		// 	- 9�� ���� : #### 4
		String numbers = "";
		//
		for(int i=0;i<100;i++) {
			numbers += new Random().nextInt(10);
		}
		//
		System.out.println(numbers);
		int [] nArr = new int[10];
		//
		for(int i=0;i<numbers.length();i++) {
			// ù��° ���ڰ� ""�� ������ ���ڿ��� �ȴ�.
			// String.valueOf(numbers.charAt(i)); �ε� �ȴ�.
			String s = ""+numbers.charAt(i);
			nArr[Integer.parseInt(s)]++;
		}
	
		// �迭�� �׷����� �׷��ִ� Ŭ����
		Ex2_Work pg = new Ex2_Work();
		
		// �Ķ���ͷ� �迭�� �������� ������ �迭�� �޾ƾ��Ѵ�. 
		pg.print(nArr);
	}
}
