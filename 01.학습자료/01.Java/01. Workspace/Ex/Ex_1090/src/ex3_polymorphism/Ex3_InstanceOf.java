package ex3_polymorphism;

public class Ex3_InstanceOf {
	public static void main(String[] args) {
		/*	InstanceOf
		 * 		- 인스턴스의 실제 타입 (주소 값)을 비교하는 연산자
		 * 		- 왼쪽에는 참조변수를, 오른쪽에는 타입이 위치한다.
		 * 		- 결과 값으로 true, false를 반환하며 true는 참조변수가 검사한 타입으로 형변환이 가능하다는 것을 의미한다.
		 * 
		 * 		[참고] 실제 인스턴스와 같은 타입 외에도 조상 타입과의 연산에도 true값이 반환된다.
		 */
		FireEngine2 fe = new FireEngine2();
		
		if(fe instanceof FireEngine2) System.out.println("This is a FireEngine2 instance.");
		if(fe instanceof Car2) System.out.println("This is a Car2 instance.");
		if(fe instanceof Object) System.out.println("This is an Object instance.");
		
		System.out.println(fe.getClass().getName());
	}
}

//
class Car2 {}
class FireEngine2 extends Car2 {}