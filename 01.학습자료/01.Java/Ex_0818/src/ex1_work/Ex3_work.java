package ex1_work;

import java.util.Random;

public class Ex3_work {

	public static void main(String[] args) {
		
		// ����
		// - ���� money �� 10 ~ 5000 ������ ������ �����Ѵ�.
		// - �� 3450, 2100... �� ���� 1�� �ڸ� ���ڴ� �ݵ�� 0�� �Ǵ� ������ �������մϴ�.
		// - �߻��� ���� money�� 500��, 100, 50��, 10���� ������ ��� �Ž������µ� �����ּ���.
		// - �� ������ ���� ���� ���� �������� �Ž����ּ���.
		
		// - ���
		// - �Է� : 2590
		// - 500�� : 5
		// - 100�� : 0
		// - 50�� : 1
		// - 10�� : 4
		int [] coin = {500,100,50,10};
		int money = new Random().nextInt(500)+10;
		money *= 10;
		System.out.println(money);
		//
		for(int i=0;i<coin.length;i++) {
			int res = money / coin[i];
			//
			if(res>0) {				
				System.out.println(coin[i]+"�� : "+res);
			}
			money %= coin[i];
		}
	}
}
