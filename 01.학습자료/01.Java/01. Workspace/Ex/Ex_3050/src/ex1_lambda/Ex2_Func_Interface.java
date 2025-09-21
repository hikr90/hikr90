package ex1_lambda;

public class Ex2_Func_Interface {
	public static void main(String[] args) {
		/* 함수형 인터페이스
		 * 		- 람다식은 익명 클래스의 객체와 동일하다.
		 * 		- 익명 클래스는 참조변수가 있어야 객체의 메소드를 호출할 수 있다.
		 * 		- 참조변수는 클래스나 인터페이스가 해당된다.
		 * 
		 * 		[참고] 람다식을 익명객체로 대체 가능한 이유
		 * 			(1) 람다식이 실제로 익명 객체이기도 하고
		 * 			(2) myFunction 인터페이스를 구현한 익명 객체의 메소드 max와 람다식의 매개변수, 타입, 개수가 일치하므로
		 */
		
		// 참조변수 객체 생성
		getFunction f = (int a, int b) -> a > b ? a : b;
		int big = f.max(1, 3);
	}
}

@FunctionalInterface	// 메소드를 호출할 때 람다식을 참조하는 참조변수를 매개변수로 지정해야 한다.
interface getFunction {
	// 함수형 인터페이스는 단 한개의 추상 메소드만 정의되어 있어야 한다.
	public abstract int max(int a, int b);
}