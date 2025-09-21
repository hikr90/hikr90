package ex1_method;

public class Ex4_Method_Type {
	public static void main(String[] args) {
		/*	메소드 타입 
		 * 		(1) 인스턴스 메소드
		 *			- 일반적인 형태의 메소드
		 *			- 인스턴스 변수가 인스턴스 생성 시 사용할 수 있으므로 인스턴스 메소드 역시 반드시 객체 생성을 통해서만 수행 가능하다.
		 *			- 인스턴스 메소드 내에서는 클래스 변수의 사용이 가능하다.
		 *				(인스턴스 변수가 존재하는 것은 이미 클래스 변수가 메모리에 존재함을 의미하기 때문이다.)
		 *
		 *		(2) 클래스 메소드 (static)
		 *			- 인스턴스 변수 혹은 인스턴스 메소드와 관계 없는 메소드
		 *			- 객체 생성없이 '클래스명.메소드명' 의 형태로 수행 가능하다.
		 *			- 클래스 메소드 내부에서는 인스턴스 변수를 사용할 수 없다.
		 *				
		 *		[참고] 인스턴스 변수는 반드시 인스턴스가 존재 해야하나, 클래스 메소드는 인스턴스 생성 없이 호출이 가능하므로 클래스 메소드 호출 시, 인스턴스가 없을 수 있는 상황을 방지하여 금지되어있다.
		 */
		
		// 클래스 메소드 호출
		System.out.println(myMath2.add(200L, 100L));
		System.out.println(myMath2.subtract(200L, 100L));
		System.out.println(myMath2.multiply(200L, 100L));
		System.out.println(myMath2.divide(200L, 100L));

		// 인스턴스 메소드 호출
		myMath2 m2 = new myMath2();
		m2.a = 200L;
		m2.b = 100L;
		// 인스턴스 메소드는 객체 생성 후에만 호출이 가능하다.
		System.out.println(m2.add());
		System.out.println(m2.subtract());
		System.out.println(m2.multiply());
		System.out.println(m2.divide());
	}
}

class myMath2 {
	long a, b;
	
	// 인스턴스 변수만을 사용하므로 매개변수가 필요없다.
	long add() { return a + b; }
	long subtract() { return a - b; }
	long multiply () { return a * b; }
	double divide() { return a / b; }
	
	// 인스턴스 변수와 관계없이 매개변수만으로도 작업이 가능
	static long add(long a, long b) { return a + b; }
	static long subtract(long a, long b) { return a - b; }
	static long multiply (long a, long b) { return a * b; }
	static double divide(long a, long b) { return a / b; }
}
