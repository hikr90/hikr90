package ex1_random;

import java.util.Random;

public class Ex1_random {
	
	public static void main(String[] args) {
		
		/* 난수(random) 생성 
		 Random 클래스는 난수를 발생시킨다. 
		 Random은 개발자들이 만들어둔 스캐너같은 클래스므로 스캐너와 마찬가지로 위에 java.util이라는 패키지의 Ramdom을 import(사용 허가) 해야한다.
		 
		 예) 1에서 4 사이의 난수 발생 
		new Random().nextInt(발생할 난수의 범위수)+시작수 */
		int num = new Random().nextInt(4) + 1;
		
		// 1과 4 사이에 랜덤한 숫자가 나온다.
		System.out.println(num);
		
		// 1211 ~ 12134사이의 난수 발생
		// new Random().nextInt(큰 수 작은 수+1)+시작수
		num = new Random().nextInt(12134-1211+1)+1211;
		System.out.println(num);
		
		// 결과 : F(A부터 Z까지가 랜덤으로 나오게 하자)
		int num2 = new Random().nextInt(90-65+1)+65;
		System.out.println((char)num2);
		
		// 난수는 문자로도 가능하다.
		int num3 = new Random().nextInt('Z'-'A'+1)+'A';
		System.out.println((char)num3);

	}
}
