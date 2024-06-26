package ex3_inheritance;

public class ExtendsMain {
	
	public static void main(String[] args) {
		
		/*	상속 (inheritance) 
		 *		- 부모 클래스가 자식 클래스에게 모든 멤버를 사용할 수 있도록 하는 것을 뜻한다.
		 *		- 자식클래스에서 extends 키워드를 사용한다.
		 *		- 상속받는 클래스를 자식 클래스, 하위 클래스, 서브 클래스라고 표현한다.
		 *		- 상속하는 클래스를 부모 클래스, 상위 클래스, 슈퍼 클래스라고 표현한다.
		 *
		 * 	장점
		 * 		- 객체 간에 공통적인 속성을 사용하는 경우, 부모의 속성을 그대로 가져다쓰면 된다.
		 * 	
		 * 	단점
		 * 		- 강제적으로 사용하는 방식이 아니라서, 작성을 놓치는 경우가 있다.
		 * 		- 자식은 단 하나의 부모만 상속이 가능하다. (단일 상속 체계)
		 * 		- (만약 두가지 이상의 부모를 상속하게되면 양쪽 부모에 동일한 속성이 있는 경우, 이를 명시할 수 없어 다중 상속을 막고있다.)
		 * 
		 *		[예시] 상속 관계에서의 객체화
		 *			- 자식의 객체화는 Object - 부모 - 자식의 순서로 진행되므로 자식과 부모의 주소 값은 동일하다.
		 *			- 부모의 객체화는 Object - 부모 순서로 진행되므로  자식과 부모의 주소 값은 동일하지 않다.
		 *
		 *		[참고] 상속의 순서
		 *			(1) New 키워드를 통해서 Object 클래스에서 heap 영역을 할당받는다.
		 *			(2) 부모 클래스의 영역과 데이터가 생성된다.
		 *			(3) 부모 클래스의 주소 값을 통해서 자식클래스의 영역을 할당받는다.
		 *			(4) 자식 클래스의 영역과 데이터가 생성된다.
		 *
		 *		- 부모, 자식의 클래스는 최상위 클래스인 Object 클래스에 상속되어있다.
		 * 
		 */
		
		// 자식 클래스의 객체화
		Child c = new Child();
		System.out.println(c.money);
		System.out.println(c.car);
		
		// instanceof 메소드를 통해서 좌측 객체가 우측 클래스의 자식인지를 확인 (주소 값의 비교)
		if(c instanceof Parents) {
			System.out.println("c는 Parents의 자식입니다.");
		}
	
		System.out.println("-------------------");
		
		// 부모 클래스의 객체화
		// - 상속관계의 객체라고 할지라도 부모는 자식의 필드(속성)를 마음대로 사용할 수 없다.
		Parents p = new Parents();
		
		if(c instanceof Object) {
			System.out.println("자식 클래스와 부모클래스는 object클래스에 상속되어있다.");
		}
	}
}
