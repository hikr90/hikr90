package ex1_control_statement;

public class Ex4_switch {
	
	public static void main(String[] args) {

		/*	switch문
		 * 	- case문이라고도 부른다.
		 * 	- 비교 값과 조건 값을 통해서 결과를 실행하는 제어문
		 * 	- 내부에 최소 1개 이상의 case가 있어야하며 case 수의 제한은 없으나 중복 생성은 불가능하다.
		 * 	- switch 영역에는 조건문이 들어가지 않고 변수만 들어간다.
		 * 	- 비교 값과 조건 값은 반드시 같은 자료형이여야 한다.
		 * 	- default 영역은 else 영역과 동일하게 비교 값과 조건 값이 일치하지 않을 때 동작하는 영역이다.
		 * 
		 * 	- 각 영역의 break가 존재하지 않는 경우 일치하는 영역에 들어간 이후 switch이 종료되지 않고 다음 비교 값을 찾게 된다.
		 * 	
		 * [참고] else if 와 case문의 차이
		 * 	- else if는 위에서부터 일치 할 때 까지 비교하는 방식이며
		 * 	- case는 비교 값만 찾아서 그대로 나오기 때문에 속도 측면에서 더 빠르다.
		 * 	- 단 case는 조건문을 사용할 수 없으므로 범위에 대한 조건 및 비교가 불가능하다.
		 */
		int n = 3324;
		//
		switch(n) {
			case 1 :
				System.out.println("게임 시작");
				break;
			
			case 2 :
				System.out.println("게임 소개");
				break;
				
			case 3 :
				System.out.println("게임 종료");
				break;
			
			default :
				System.out.println("잘못된 값입니다.");
				break;
		}
	}
}
