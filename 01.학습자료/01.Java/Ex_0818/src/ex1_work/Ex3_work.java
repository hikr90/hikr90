package ex1_work;

import java.util.Random;

public class Ex3_work {

	public static void main(String[] args) {
		
		// 문제
		// - 변수 money 에 10 ~ 5000 사이의 난수를 저장한다.
		// - 단 3450, 2100... 과 같이 1의 자리 숫자는 반드시 0이 되는 난수를 만들어야합니다.
		// - 발생한 난수 money를 500원, 100, 50원, 10원의 단위로 몇개가 거슬러지는데 보여주세요.
		// - 단 가능한 가장 적은 수의 동전으로 거슬러주세요.
		
		// - 결과
		// - 입력 : 2590
		// - 500원 : 5
		// - 100원 : 0
		// - 50원 : 1
		// - 10원 : 4
		int [] coin = {500,100,50,10};
		int money = new Random().nextInt(500)+10;
		money *= 10;
		System.out.println(money);
		//
		for(int i=0;i<coin.length;i++) {
			int res = money / coin[i];
			//
			if(res>0) {				
				System.out.println(coin[i]+"원 : "+res);
			}
			money %= coin[i];
		}
	}
}
