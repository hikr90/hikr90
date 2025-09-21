package ex1_lambda;

public class Ex4_Lambda_Casting {
	public static void main(String[] args) {
		/* 람다식의 타입과 형변환 
		 *		- 람다식은 익명 객체이고, 익명 객체는 타입이 존재하지 않는다.
		 *			(정확히는 타입은 있지만 컴파일러가 임의로 이름을 정하므로 알 수 없다.)
		 *
		 * 			myFunction f = (myFuntion) (() -> { System.out.print("method"); })
		 * 	
		 * 			
		 */
		
		// [참고] 람다식의 형변환
		//		- 람다식은 인터페이스를 직접 구현하진 않지만 이 인터페이스를 구현한 클래스의 객체와 완전히 동일하므로 아래와 같은 형변환을 허용한다.
		ex4_1_myFunction f = (ex4_1_myFunction) (() -> { System.out.println("f.method()"); });
		Object obj = (ex4_1_myFunction) (() -> { System.out.println("obj.method()"); });
		String str = ((Object)(ex4_1_myFunction) () -> { System.out.println("str.method()"); }).toString();
		
		f.method();
		System.out.println(obj);
		System.out.println(str);
	}
}

interface ex4_1_myFunction {
	void method();
}