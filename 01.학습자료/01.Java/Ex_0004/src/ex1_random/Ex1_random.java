package ex1_random;

import java.util.Random;

public class Ex1_random {
	
	public static void main(String[] args) {
		
		/*	난수
		 *		- 랜덤 클래스는 난수를 생성하는데 사용된다.
		 *		- 난수 역시 java.util 내의 클래스로 해당 패키지가 import 처리되어야한다.
		 */
		 
		// new Random().nextInt(난수의 범위) + 시작 수
		int num = new Random().nextInt(4) + 1;
		
		// 1 ~ 4 사이의 난수
		System.out.println(num);
		
		// 1211 ~ 12134 사이의 난수
		num = new Random().nextInt(12134-1211+1)+1211;
		System.out.println(num);
		
		// 아스키코드를 사용하여 A ~ Z 사이의 난수
		int num2 = new Random().nextInt(90-65+1)+65;
		System.out.println((char)num2);
		
		// 문자로 난수 발생
		int num3 = new Random().nextInt('Z'-'A'+1)+'A';
		System.out.println((char)num3);

	}
}
