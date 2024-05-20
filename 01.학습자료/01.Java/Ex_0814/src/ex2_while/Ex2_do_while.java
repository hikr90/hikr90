package ex2_while;

import java.util.Random;

public class Ex2_do_while {
	
	public static void main(String[] args) {
		
		/*	do-while
		 *		- 처음 한번은 무조건 동작하는 선처리 후 비교 방식의 while문
		 *		- 제어문 중 유일하게 ; 으로 끝난다.
		 *		
		 *		do {
		 *				조건식이 참일 때 동작하는 영역
		 *		} while (조건식)
		 *
		 *	[참고] while과 do-while의 차이
		 *		- while은 조건 값이 거짓인 경우 실행문을 동작하지 않으나
		 *		- do-while은 선 처리 후 비교 방식이므로 조건이 거짓이라도 처음 한번은 동작하게 된다.
		 *
		 */
		int i = 11;
		
		do {
			System.out.println(i);
			
		} while(i<=10);
	
		System.out.println("------------------");

		// 문제
		// - java, jsp, android의 시험을 진행했습니다.
		// - 각 과목별 점수는 0 ~ 130점의 난수가 나옵니다.
		// - 각 과목의 검사를 do-while로 진행하는데 0 ~ 100 사이의 난수가 아닌 경우는 0 ~ 100 사이의 값이 나올 때까지 계속 반복해야합니다.
		// - 반복 작업을 통해서 세 과목의 점수가 0 ~ 100 사이가 되면 do while을 빠져나와 과목별 점수를 화면에 보여주세요.
		int java = 0;
		int jsp = 0;
		int and = 0;
		
		do {
	
			java = new Random().nextInt(130-0+1)+0;
			jsp = new Random().nextInt(130-0+1)+0;
			and = new Random().nextInt(130-0+1)+0;
					
			System.out.println("java : "+java);
			System.out.println("jsp : "+jsp);
			System.out.println("and : "+and);
			
		} while(java>100||jsp>100||and>100);
	}
}
