package ex1_control_statement;

public class Ex1_if {
	
	public static void main(String[] args) {
		
		/* 조건문
		 * 	- 프로그램 흐름 제어 문장으로, 제어문이라고 부른다.
		 * 	- 분기문과 반복문으로 구분한다.
		 * 
		 * 	- 분기문 : if, if else, else if, switch
		 * 	- 반복문 : for, while
		 */
		int n = 51;
		String str = "";
		// 분기문
		if(n==50) {
			// 조건이 참인 경우 아래의 코드를 실행한다.
			str = "n은 50입니다.";
		} 
		
		if(n!=50) {
			str = "n은 50이 아닙니다.";
		}
		
		System.out.println(str); 
	}
}
