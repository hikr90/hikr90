package ex1_work;

import java.util.Random;

public class Ex1_work {

	/* 1���� 45������ ������ ����Ͽ� �ߺ����� �ʴ� �ζ� ��ȣ�� ����ϼ���. */
	
	public static void main(String[] args) {
		
		int [] lotto = new int[6];
		
		outer : for(int i=0;i<lotto.length;) {
			
			lotto[i] = new Random().nextInt(45) + 1;
			
			// ����� ��(�ߺ�üũ)�� ���� �ݺ���
			for(int j=0;j<i;j++) {
				if(lotto[i]==lotto[j]) {
					continue outer;
				}				
			}
			System.out.println(lotto[i]+" ");
			i++;
			
		}
		
		
		
		
		
	}
}
