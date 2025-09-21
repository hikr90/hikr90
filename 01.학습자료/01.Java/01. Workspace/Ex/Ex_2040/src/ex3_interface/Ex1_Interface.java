package ex3_interface;

public interface Ex1_Interface {
	
	/*	인터페이스
	 * 		- 다른 클래스 작성을 돕는 목적으로 일종의 추상 클래스이다.
	 * 		- 다중 상속을 구현할 수 있도록 설계되었다.
	 * 		- 추상 클래스처럼 추상 메소드를 갖지만, 추상화 정도가 높아서 일반 메소드 또는 멤버변수를 가질 수 없다.
	 * 		
	 * 		[참고] 인터페이스의 구현과 상속은 동시에 진행 가능하다.
	 * 			(클래스명 extends 부모 implements 인터페이스명)
	 * 
	 * 		(1) 선언 방식
	 * 			- 클래스명 implement 인터페이스1, 인터페이스2... 의 방식으로 선언한다.
	 * 
	 * 		(2) 생성 규칙
	 * 			(2.1) 인터페이스의 첫글자는 대문자이다.
	 * 			(2.2) 인터페이스의 안에는 상수 값이나 구현부가 없는 메소드만 들어갈 수 있다.
	 * 				(abstract는 옵션이다.)
	 * 
	 *		(3) 특징
	 *			(3.1) 장점
	 *				- 추상 메소드만 생성해두면 각 클래스에서 개별적으로 동시 구현 가능하다.
	 *				- 기본적으로 인터페이스 포맷을 생성해두면 개발자들이 표준화된 개발이 가능하다.
	 *				- 서로 관계없는 클래스의 그룹화가 가능하다.
	 *				- 독립적인 프로그래밍	(클래스와 다르게, 인터페이스는 선언, 구현이 따로이므로 서로 영향도가 거의 없다.)
	 *
	 *		(4) 제약사항
	 *			(4.1) 모든 변수는 public static final 이며 생략될 수 있다.
	 *			(4.2) 모든 메소드는 public abstract 이며 생략될 수 있다.
	 *
	 *		(5) 다중 상속
	 *			- 인터페이스는 메소드의 구현부가 없다.
	 *			- 자식이 동일한 부모를 구현하더라도, 각자 따로 메소드를 구현하므로 다중 상속이 허용된다.
	 */
	final int VALUE = 100;				// final은 상수로서, 불변하는 값을 의미한다. (상수는 전부 대문자로 작성한다.)
	abstract int getValue();
}

// 
class Ex1_1_Interface {
	public static void main(String[] args) {
		// 인터페이스는 구현부 없는 메소드 (추상 메소드) 가 강제적이다.
		Ex1_2_Interface c = new Ex1_2_Interface();
		System.out.println(c.getValue());
	}
}

// 
class Ex1_2_Interface implements Ex1_Interface {
	// 추상 메소드의 재정의
	@Override
	public int getValue() {
		/* final 
		 * 		- 값을 상수로 지정하는 키워드
		 * 		- 변수와 마찬가지로 값을 저장하는 공간이지만 한번 값을 저장하면 다른 값으로 변경할 수 없다.
		 * 		- 상수는 전부 대문자로 작성하며, 여러 단어로 구성된 경우 _ 를 붙여서 구분한다.
		 * 		- 의미 그 자체인 값을 여러 곳에서 사용하지 않고 한 곳에서 수정하기 쉽게 사용하기 위해서 사용한다.
		 * 
		 * 		[참고] 실무에서는 상수 대신 리터럴이라고 부른다.
		 * 			(1) 상수 : 값을 한번만 저장할 수 있는 공간
		 * 			(2) 리터럴 : 그 자체로 값을 의미하는 것, 의미있는 값
		 */
		return VALUE;
	}
}

// 인터페이스 다중 구현
interface Ex1_3_Interface extends Ex1_4_Interface {}
interface Ex1_4_Interface {};
interface Ex1_5_Interface {};