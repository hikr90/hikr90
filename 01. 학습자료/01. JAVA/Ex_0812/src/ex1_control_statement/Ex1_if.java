package ex1_control_statement;

public class Ex1_if {
	
	public static void main(String[] args) {
		
		/* 
		제어문 : 프로그램의 흐름을 제어하는 문장
		분기문과 반복문으로 나뉜다.
		
		분기문 : if, switch
		
		단순 if문
		if(조건식){
		조건식이 참값인 경우 실행문
		} 
		*/
		
		// String : ""안에 여러 글자(문자열)들을 저장할 수 있는 자료형(엄밀하게는 자료형은 아니지만, 자료형이라고 부르는 경우도 많다.)
		// 앞글자가 대문자이므로 클래스이다. String 자료형은 아무 값도 넣지 않는 경우, ""으로 초기화를 한다. (상수는 0으로 초기화)
		int n = 51;
		String str = "";
		
		if(n==50) {
			// 조건이 참인 경우 아래의 코드를 실행한다.
			str = "n은 50입니다.";
		} 
		
		if(n!=50) {
			str = "n은 50이 아닙니다.";
		}
		
		System.out.println(str); 
		
		
		
		// 반복문 : for, while
	}
}
