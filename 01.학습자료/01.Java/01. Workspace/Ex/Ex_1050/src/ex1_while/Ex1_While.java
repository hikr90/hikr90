package ex1_while;

public class Ex1_While {
	public static void main(String[] args) {
		
		/*	while
		 *		- 조건식과 비교 후 처리 방식의 제어문
		 *		- 의도적인 반복을 내는데 용이하다.
		 *		- 선 비교 후 처리 방식으로 동작한다.
		 *
		 * 	while (조건식) {
		 * 		조건식이 참인 경우 실행되는 영역
		 * 	}
		 * 
		 * 	- (1) 조건식이 참 (2) 실행문 수행 (3) 다시 비교 (4) 참인 경우 다시 수행
		 * 	- 조건이 맞을 때까지 반복을 수행한다.
		 */
		int num = 1;
		
		while(num<=3) {
			System.out.println(num);
			num++;
		}
		
		System.out.println("---------------");
		
		// 조건문에 참 값이 들어가는 경우 무한 반복하게 된다.
		// while(true) {
			// System.out.println("안녕");
		// }
		
		// 무한 반복 역시 일종의 에러이므로 무한 반복이 도는 순간 그 밑의 코드에는 도달하지 못한다.
		// System.out.println("---------------");
	}
}
