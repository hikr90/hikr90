package ex1_work;

import java.util.Random;

public class Ex3_work {

	public static void main(String[] args) {
		
		/*���� : ���� money�� 10~5000������ ������ �߻����� �ֽ��ϴ�. 
		  ��, 3450, 2100... �� ���� 1�� �ڸ� ���ڴ� �ݵ�� ���� �ǵ��� ������ �������մϴ�.
		 �߻��� ���� money�� 500��, 100��, 50��, 10��¥�� �������� �ٲٸ� ���� ��� �Ž����������� �Ǵ��Ͻÿ�.
		 �� ������ �� ���� ���� ���� �������� �Ž��� �� ��
		 
		 ���
		 2590 <-- ������ �߻��� �ݾ�
		 500�� : 5
		 100�� : 0
		 50�� : 1
		 10�� : 4
		 */
		int money = 0;
		
		while(true) {
			money = new Random().nextInt(5000-10+1)+10;
			if(money%10==0) {
				break;
			}
		}
		System.out.println(money);
		
		int [] coin = {500,100,50,10};
		
		for(int i=0;i<coin.length;i++) {
			
			if(money/coin[i]!=0) {
				System.out.println(coin[i]+"�� : "+money/coin[i]);				
			}
			money %= coin[i];
		}
		
		/* ������ 
		int [] coin = {500,100,50,10};
		int money = new Random().nextInt(500)+10;
		money *= 10;
		System.out.println(money);
		
		for(int i=0;i<coin.length;i++) {
			int res = money / coin[i];
			
			if(res>0) {				
				System.out.println(coin[i]+"�� : "+res);
			}
			money %= coin[i];
		}

		  
		 */
		
		
		
		
	}
}
