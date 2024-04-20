package ex1_work;

import java.util.Random;

public class Ex1_work {

	/* 1에서 45사이의 난수를 출력하여 중복되지 않는 로또 번호를 출력하세요. */
	
	public static void main(String[] args) {
		
		int [] lotto = new int[6];
		
		outer : for(int i=0;i<lotto.length;) {
			
			lotto[i] = new Random().nextInt(45) + 1;
			
			// 경우의 수(중복체크)를 위한 반복문
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
