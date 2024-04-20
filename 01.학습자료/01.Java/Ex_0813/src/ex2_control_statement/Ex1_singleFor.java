package ex2_control_statement;

public class Ex1_singleFor {
	public static void main(String[] args) {
		/* 단일 for문
		 반복문 : 특정 문장을 여러번 반복할 수 있도록 해주는 제어문

		 for(초기식;조건식;증감식;){
		 	조건식이 참일 경우 실행되는 영역
		 }		 */

		// 전역변수
		// main문에서 사용한 변수는 전역변수로서 만약 i를 전역변수로 선언하면 main안의 어떠한 영역에서도 따로 사용할 수 없다.
		// 대신 전역변수는 main영역에서 선언되면 main 메서드안에 있는 모든 제어문과 for문 안에서도 사용할 수 있다. 

		// 지역변수
		// for문 혹은 if문안에서 사용한 변수는 지역변수로서 for문안에서만 사용이 가능하다. 


		// 1부터 3까지 자동으로 반복하는 for문 생성
		for(int i=1;i<=3;i++) {
			System.out.println(i);
		}

		System.out.println("---------------");

		// 10부터 1까지 감소하는 값을 출력하는 for문 생성
		for(int i=10;i>=1;i--) {
			System.out.println(i);
		}

		System.out.println("---------------");

		// for문은 의도적으로 증감식을 사용하지 않을수도 있다.
		// 증감식이 없는 경우, 조건식으로 넘어가는데 위 경우 무한루프식이 된다.
		// 조건식도 없는 경우도 무한 루프식이 된다. 
		for(int i=0;i<5;) {
			System.out.println(i);
			// 증감식의 역할을 한다. 
			i++;
		}

		System.out.println("---------------");

		// 문제  1부터 100까지 반복하는 for문을 만들고 3의 배수만 화면에 출력하십시오.
		for(int i=1;i<=100;i++) {
			if(i%3==0) {
				System.out.println(i);
			}
		}

	}
}
