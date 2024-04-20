package ex1_graph;

import java.util.Random;

public class MyGraph {
	
	/*0���� 9������ ������ 100���� �����.
	 * �߻��� ������ ���� �Ʒ��� ����� ����
	 * 
	 * ��� : 1240912850198309128310901 <-- ���� 100��
	 * 0�� ����:### 3
	 * 1�� ����:##### 5
	 * 2�� ����:# 1
	 * ....
	 * 9�� ����:#### 4*/
	
	public static void main(String[] args) {
		
		String numbers = "";
		for(int i=0;i<100;i++) {
			
			numbers += new Random().nextInt(10);
		}

		System.out.println(numbers);
	
		int [] nArr = new int[10];
		
		for(int i=0;i<numbers.length();i++) {
			
			// ù��° ���ڰ� ""�� ������ ���ڿ��� �ȴ�.
			// String.valueOf(numbers.charAt(i)); �ε� �ȴ�.
			String s = ""+numbers.charAt(i);
			
			
			nArr[Integer.parseInt(s)]++;
			
		}
	
		// nArr�迭�� �׷����� �׷��ִ� Ŭ����
		PrintGraph pg = new PrintGraph();
		
		// �Ķ���ͷ� �迭�� �������� ������ �迭�� �޾ƾ��Ѵ�. 
		pg.print(nArr);
	
	
	
	
	
	
	
	}
}
