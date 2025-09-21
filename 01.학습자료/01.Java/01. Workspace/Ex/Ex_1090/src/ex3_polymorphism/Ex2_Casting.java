package ex3_polymorphism;

public class Ex2_Casting {
	public static void main(String[] args) {
		/*	참조변수의 형변환	
		 * 		- 서로 상속 관계가 있는 클래스간 참조변수의 형변환이 가능하다.
		 * 		- 형변환의 방법은 기본 자료형과 같다.
		 * 			
		 * 		(1) Up Casting 
		 * 			- 자식 타입 > 부모 타입
		 * 			- 형변환 생략 가능
		 * 
		 * 		(2) Down Casting
		 * 			- 부모 타입 > 자손 타입
		 * 			- 형변환 생략 불가능
		 * 
		 * 		[참고] 참조변수의 형변환은 참조변수의 타입을 변경하는 것으로 인스턴스와 상관없다.
		 * 				 형변환을 통해서, 참조하고 있는 인스턴스에서 사용할 수 있는 멤버의 범위를 (개수) 조절하는 것 뿐이다.
		 * 
		 * 		[참고] 서로 상속관계에 있는 타입간의 형변환은 양방향으로 가능하나 참조변수가 가르키는 인스턴스의 자손타입으로 형변환은 허용되지 않는다.
		 * 				(참조변수가 가르키는 인스턴스의 타입이 무엇인지 확인하는 것이 중요하다.)
		 */
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		fe.water();
		
		// Up Casting
		car = fe; 				// car = (Car)fe; (형변환 생략)

		// [에러] Car타입의 참조변수로는 water() 호출 불가능
		// car.water();			
		
		// Down Casting
		fe2 = (FireEngine)car;
	}
}

//
class Car {
	String color;
	int door;
	
	void drive() {
		System.out.println("drive");
	}
	
	void stop() {
		System.out.println("stop");
	}
}

class FireEngine extends Car {
	void water() {
		System.out.println("water");
	}
}