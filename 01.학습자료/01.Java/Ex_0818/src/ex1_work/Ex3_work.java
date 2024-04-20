package ex1_work;

import java.util.Random;

public class Ex3_work {

	public static void main(String[] args) {
		
		/*문제 : 변수 money에 10~5000사이의 난수를 발생시켜 넣습니다. 
		  단, 3450, 2100... 과 같이 1의 자리 숫자는 반드시 영이 되도록 난수를 만들어야합니다.
		 발생한 난수 money를 500원, 100원, 50원, 10원짜리 동전으로 바꾸면 각각 몇개씩 거슬러지는지를 판단하시오.
		 단 가능한 한 가장 적은 수의 동전으로 거슬러 줄 것
		 
		 결과
		 2590 <-- 난수로 발생한 금액
		 500원 : 5
		 100원 : 0
		 50원 : 1
		 10원 : 4
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
				System.out.println(coin[i]+"원 : "+money/coin[i]);				
			}
			money %= coin[i];
		}
		
		/* 선생님 
		int [] coin = {500,100,50,10};
		int money = new Random().nextInt(500)+10;
		money *= 10;
		System.out.println(money);
		
		for(int i=0;i<coin.length;i++) {
			int res = money / coin[i];
			
			if(res>0) {				
				System.out.println(coin[i]+"원 : "+res);
			}
			money %= coin[i];
		}

		  
		 */
		
		
		
		
	}
}
