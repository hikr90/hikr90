package ex1_control_statement;

public class Ex4_switch {
	
	public static void main(String[] args) {
		
		/* 
		switch(case문) : 비교값과 조건값을 통해서 결과를 실행하는 제어문
		:: case문은  내부에 최소 1개 이상의 case가 있어야한다, case의 수는 제한이 없으나 중복이 될 수 없다. 
		:: switch는 조건식이 들어갈 수 없다.
		:: 비교값과 조건값은 반드시 같은 자료형 타입이여야한다.
		
		else if와  case문의 차이
		:: else if는 위에서부터 일치할 때까지 비교하지만, case는 일치하는 비교값만 찾아서 그대로 나온다. (속도측면에서 case가 더 좋음)
		:: case문은 조건문을 사용할 수 없으므로 범위에대한 조건 및 비교가 불가능하다.
		
		switch(비교값){
			case 조건값 : 
				비교값과 조건값이 일치하는 경우, 실행되는 영역
				break;
		
			default(비교값과 조건값이 한개도 일치하지 않을 때, 반드시 실행되는 영역) :
				실행되는 영역
				break;
		}
		
		*/
	
		// 정수타입은 byte, short, int만 담을 수 있고 long은 못담는다.
		// switch문은 정수, 문자, 문자열 딱 3종류의 타입만 담을 수 있다.
		int n = 3324;
		
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
