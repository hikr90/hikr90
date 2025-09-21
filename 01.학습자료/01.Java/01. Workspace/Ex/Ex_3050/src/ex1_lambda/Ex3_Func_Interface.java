package ex1_lambda;

// (1), (2) public abstract void run(); 
@FunctionalInterface
interface myFunction {
	void run();
}

public class Ex3_Func_Interface {
	// (4) 매개변수의 타입이 참조변수 (myFunction) 인 메소드
	// 	- 람다식을 참조변수로 받을 수 있다는 것은 메소드를 통해서 람다식을 주고받을 수 있다는 것을 뜻한다.
	static void execute(myFunction f) {
		f.run();
	}
	
	// (3) 반환 타입이 참조변수 (myFunctoin)인 메소드
	static myFunction getFunction() {
		myFunction f = () -> System.out.println("f3.run()");
		return f;
	}
	
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
		
		// (1) 람다식으로 fun1의 run 구현
		myFunction f1 = () -> System.out.println("f1.run()");
	
		// (2) 익명클래스로 fun1의 run 구현
		myFunction f2 = new myFunction() {
			
			@Override
			public void run() {
				System.out.println("f2.run()");
			}
		};
				
		// (3) 람다식을 반환하는 메소드 동작
		myFunction f3 = getFunction();
		
		f1.run();
		f2.run();
		f3.run();
		System.out.println("-----------------------");
		
		// (4) 람다식을 파라미터로 받는 메소드
		execute(f1);											// f1은 람다식이므로 파라미터로 사용 가능
		execute(() -> System.out.println("f4.run()"));			// 람다식 자체도 파라미터로 사용 가능
	}
}