package ex3_polymorphism;

public class Ex1_Poly {
	public static void main(String[] args) {
		/*	클래스의 다형성
		 * 		- 한 가지의 타입의 변수로 여러 타입의 객체를 참조할 수 있도록 하는 성질
		 * 		- 부모 클래스 타입의 참조변수로 자식 클래스의 인스턴스 참조
		 * 		- 같은 타입의 인스턴스라도 참조변수의 타입에따라 사용할 수 있는 멤버가 다르다.
		 * 
		 * 		(1) 부모 클래스 t1 = new 자식 클래스
		 * 			- 참조변수 t1은 자식 클래스에서 선언된 멤버 데이터의 사용이 불가능하다.
		 * 			- 자식 클래스의 멤버 중에서 부모 클래스의 멤버 (상속받은 멤버 포함) 만 사용할 수 있다.
		 * 
		 * 		(1) 자식 클래스 t2 = new 자식 클래스
		 * 			- 참조변수 t2는 자식 클래스, 부모 클래스의 양측에서 선언된 멤버 데이터의 사용이 가능하다.
		 * 
		 * 		(에러) 자식 클래스 t3 = new 부모 클래스
		 * 			- 자식 타입의 참조변수로 부모 타입의 인스턴스 참조 불가능 
		 * 				(자식 타입에 선언된 데이터는 부모 타입에 없기에)
		 * 
		 * 
		 * 		[참고] 조상 타입의 참조변수로 자손 타입의 인스턴스를 참조할 수 있다.
		 * 			반대로 자손 타입의 참조변수로 조상 타입의 인스턴스를 참조할 수 없다. 
		 */
		
		// (1)
		CaptionTv c = new CaptionTv();
		c.caption();
		
		// (2) 
		Tv t = new CaptionTv();
		// t.caption(); 	// 사용불가
		t.channelDown();
		
		// (에러) 실제 인스턴스인 Tv의 멤버 수보다 참조변수 c가 사용할 수 있는 멤버 수가 더 많으므로 에러
		// CaptionTv c = new Tv();
	}
}

//
class Tv {
	boolean power;
	int channel;
	
	void power() { power = !power; };
	void channelUp() { ++channel; };
	void channelDown() { --channel; };
}

class CaptionTv extends Tv {
	String text;
	void caption() {
		System.out.println("Caption!");
	};
}