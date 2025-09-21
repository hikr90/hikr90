package ex3_control_statement;

public class Ex1_Multi_For {
	public static void main(String[] args) {
		
		/*	다중 for문 
		 *		- 이중 for문이라고도 한다.
		 *		- for문 내 for문이 포함되어있는 형태이다.
		 *		- 상위 for문을 outer라고 부르며 하위 for문을 inner라고 부른다.
		 *
		 *		- 다중 for문은 행과 열의 데이터가 처리 가능하다.
		 *
		 * 	- 상위 for문에서 사용한 변수는 하위 for문에서 사용할 수 있다.
		 * 	- 상위 for문의 변수가 하위 for문에서는 전역 변수처럼 사용된다.
		 */
		for(int i=1;i<=4;i++) { 			// y축
			for(int j=1;j<=5;j++) { 		// x축
				System.out.print(j + " ");
			}
			System.out.println();
		}
	
		System.out.println("------------------");
		
		// 문제
		// - A B C D
		// - E F G  H 
		// - I  J  K  L
		// 위의 문장을 콘솔에 보여주세요.
		int a = 65;
		
		for(int i=1;i<=3;i++) {
			for(int j=1;j<=4;j++) {
				System.out.print((char)a+" ");
				a++;
			}
			System.out.println();
		}
	}
}
