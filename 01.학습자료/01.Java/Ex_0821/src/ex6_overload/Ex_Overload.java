package ex6_overload;

public class Ex_Overload {
	
	// 오버로딩 : 매서드의 중복정의
	// 기본적으로 메서드는 중복된 이름을 사용할 수 없다.
	// 오버로딩은 같은 이름의 메서드를 생성, 사용할 수 있도록 돕는다.
	// 하나의 클래스 내에서 같은 이름을 가진 메서드가 여러개 정의되도록하는 것이다.
	
	/*[오버로딩의 정의]
	 * 1 메서드의 이름은 대소문자를 포함하여 반드시 같아야한다.
	 * 2 메서드의 이름이 같기 때문에 인자의 갯수가 달라야한다.
	 * 3 인자의 갯수가 같을 경우 타입이 달라야한다.
	 * 4 인자의 갯수가 2개 이상일 때 순서가 달라야한다.
	 */
	
	
	// 인자가 있거나, 숫자 하나의 인자가 있는 경우
	public void result() {

		System.out.println("인자가 없는 메서드");
	}
	
	public void result(int n) {
		
		System.out.println("정수를 인자로 받는 메서드");
	}
	
	// 인자의 갯수가 같으나 타입이 다른 경우
	public void result(char c) {
		System.out.println("문자를 인자로 받는 메서드");
	}
	
	// 인자의 수가 2개 이상일 때, 인자 타입을 받는 순서가 다른 경우
	// 오버로딩으로 인정받는다.
	public void result(String s, int n) {
		System.out.println("문자열, 정수 순으로 받는 메서드");
	}
	
	public void result(int i, String s) {
		System.out.println("정수, 문자열 순으로 받는 메서드");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
