package ex3_overload;

public class Ex1_Overload {

	public static void main(String[] args) {
		/* 오버로딩
		 * 	- 한 클래스 내, 같은 이름의 메소드를 여러개 정의하는 것.
		 * 	- 오버로딩은 메소드명과 파라미터의 차이에 의해서만 구현이되며 반환 타입은 어떤 영향도 없다.
		 * 	- 대표적으로 println 메소드가 있다.
		 * 	- 같은 기능의 여러 메소드가 하나의 명칭으로 정의되어 오류의 발생을 줄이고 메소드 명칭의 절약이 되어 고민을 줄이는데 도움이 된다.
		 * 
		 * 	작성 규칙
		 *  	(1) 메소드의 이름은 대소문자를 포함하여 반드시 같아야한다.
		 * 		(2) 메소드의 이름이 같기에 인자의 수가 달라야한다.
		 * 		(3) 인자의 개수가 같을 경우 타입이 달라야한다.
		 * 		(4) 인자의 개수가 2개 이상인 경우 순서가 달라야한다.
		 */
		
		// 메소드 선언
		Ex2_1_Overload ov = new Ex2_1_Overload();
		
		// - 같은 메소드 수행 시, 파라미터의 여부, 파라미터의 순서 등에따라서 다른 메소드가 사용된다.
		ov.result();
		ov.result(20);
		ov.result('A');
		ov.result("dd",10);
		ov.result(10,"dd");
		
		// - System.out.println 역시 오버로딩의 대표적인 메소드이다.
		// - 여러 타입의 파라미터를 받을 수 있으며 변수가 있지 않은 경우도 받을 수 있다.
		System.out.println();
	}
}

class Ex2_1_Overload {
	public void result() {System.out.println("인자가 없는 메서드");}
	public void result(int n) {System.out.println("정수를 인자로 받는 메서드");}
	public void result(char c) {System.out.println("문자를 인자로 받는 메서드");}
	public void result(String s, int n) {System.out.println("문자열, 정수 순으로 받는 메서드");}
	public void result(int i, String s) {System.out.println("정수, 문자열 순으로 받는 메서드");}
}