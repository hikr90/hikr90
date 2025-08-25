package ex6_overload;

public class Ex_Overload {
	
	/* Overloading
	 * 	- 메소드의 중복 정의
	 * 	- 기본적으로 메소드는 중복된 이름을 사용할 수 없다.
	 * 	- 오버로딩은 같은 이름의 메소드를 생성 및 사용할 수 있게 한다.
	 * 	- 하나의 클래스에서 같은 이름을 가진 메소드가 여러개 정의되도록 한다.
	 * 
	 * 	- 메소드의 이름은 대소문자를 포함하여 반드시 같아야한다.
	 * 	- 메소드의 이름이 같기에 인자의 수가 달라야한다.
	 * 	- 인자의 개수가 같을 경우 타입이 달라야한다.
	 * 	- 인자의 개수가 2개 이상인 경우 순서가 달라야한다.
	 */
	public void result() {
		System.out.println("인자가 없는 메서드");
	}
	
	public void result(int n) {
		System.out.println("정수를 인자로 받는 메서드");
	}
	
	public void result(char c) {
		System.out.println("문자를 인자로 받는 메서드");
	}
	
	public void result(String s, int n) {
		System.out.println("문자열, 정수 순으로 받는 메서드");
	}
	
	public void result(int i, String s) {
		System.out.println("정수, 문자열 순으로 받는 메서드");
	}
}
