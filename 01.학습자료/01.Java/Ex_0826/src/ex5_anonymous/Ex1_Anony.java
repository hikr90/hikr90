package ex5_anonymous;

import java.util.Random;
import java.util.Scanner;

public class Ex1_Anony {
	
	public static void main(String[] args) {

		/* 익명 클래스 
		 * 	- 이름이 없는 클래스
		 * 	- 선언과 동시에 객체를 생성한다.
		 * 	- 이름이 없어서 생성자를 선언할 수 없으며 단 하나의 인터페이스나 클래스만 상속 및 구현이 가능하다.
		 * 
		 * 	- 계속해서 메모리를 사용하는 일반적인 클래스 선언과 다르게 일회용으로 사용 가능하다는 장점이 있으나, 코드 가독성이 떨어진다는 단점이 있다.
		 * 	- 한번만 쓰고 버려지는 값은 익명클래스가 좋고, 지속적으로 사용되는 값이라면 일반적인 클래스로 선언하여 사용하는 것이 좋다.
		 */
		// 스캐너
		// (1) 일반적인 클래스
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		// (2) 익명 클래스
		int a = new Scanner(System.in).nextInt();

		// 랜덤
		// (1) 일반적인 클래스
		Random random = new Random(); 
		int rnd = random.nextInt(10)+1; 
		
		// (2) 익명 클래스
		int r = new Random().nextInt(10)+1;
		r = new Random().nextInt(10)+1;
	}
}
