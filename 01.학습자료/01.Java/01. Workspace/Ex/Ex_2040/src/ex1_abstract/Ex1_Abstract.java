package ex1_abstract;

// 부모
// [참고] abstract는 추상클래스임을 명시하는 키워드이다.
public abstract class Ex1_Abstract {
	//
	int value = 100;
	String str = "안녕";

	/*	추상 클래스
	 * 		- 미완성 클래스
	 * 		- 내부에 미완성 메소드를 가진다.
	 * 		- 추상 클래스로는 인스턴스 생성이 불가능하다.
	 * 		
	 * 		(1) 추상 클래스의 사용 방식
	 * 			- 공통 특성을 가지는 추상클래스와 각 특징을 구현하는 클래스로 구성하여 사용된다.
	 * 			- abstract 키워드를 사용한다.
	 * 			- 추상 클래스는 내부에 반드시 하나 이상의 추상 메소드를 가진다.
	 * 
	 *		(2) 추상 메소드
	 *			- 선언부만 존재한다.
	 *			- 메소드의 내용이 구현하는 자식에 따라서 달라진다. (자식에서 추상 메소드 재정의)
	 *			- 부모에서 누락된 메소드가 자식에서 누락되지 않게 하는데 목적이 있다.
	 *			- abstract 리턴 타입 메소드명의 형태로 사용된다.
	 *
	 *		(3) 추상화 & 구체화
	 *			(3.1) 추상화 :  클래스간의 공통점을 찾아내어, 공통의 조상을 만드는 작업
	 *			(3.2) 구체화 : 상속을 통해서 클래스 구현, 확장하는 작업
	 *
	 *			- 부모 : 추상화 높음, 구체화 낮음
	 *			- 자식 : 추상화 낮음, 구체화 높음
	 */
	abstract public void setValue(int value);
	//
	public int getValue() {
		return value;
	}
}

// 구현
class Ex1_1_Abstract {
	public static void main(String[] args) {
		// 자식 클래스 객체화
		Ex1_2_Abstract c = new Ex1_2_Abstract();
		c.setValue(30);
		//
		System.out.println(c.age);
		System.out.println(c.getValue());
	}
}

// 자식
class Ex1_2_Abstract extends Ex1_Abstract {
	//
	int age = 10; 
	
	// - 추상 클래스를 상속받은 자식은 부모의 추상 메소드를 반드시 재정의 해야한다.
	@Override
	public void setValue(int n) {
		age = n;
	}
}
