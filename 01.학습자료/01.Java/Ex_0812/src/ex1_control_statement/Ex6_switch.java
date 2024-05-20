package ex1_control_statement;

public class Ex6_switch {
	
	public static void main(String[] args) {
		//
		char ch = '현';
		//
		switch (ch) {
		case '천' :
			System.out.println("하늘 천");
			break;

		case '지' :
			System.out.println("땅 지");
			break;
			
		case '현' :
			System.out.println("검을 현");
			break;
		
		default:
			System.out.println("천,지,현 중에서만 입력하세요.");
			break;
		}
		
	}
}
