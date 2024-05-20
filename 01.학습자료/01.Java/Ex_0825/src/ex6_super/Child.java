package ex6_super;

public class Child extends Parents{
	
	// (1) 부모 클래스 생성자 (2) 자식 클래스 생성자
	public Child() {
		/*	super 
		 * 	- 부모 클래스를 뜻한다.
		 *		- 상속의 관계에서 자식 클래스에서 상속받은 부모 클래스의 멤버변수를 참조할 때 사용 
		 *		- 자식 클래스의 생성자가 동작하기위해서는 반드시 부모 클래스의 생성자가 먼저 동작해야하는데 따로 super를 작성하기전에는
		 *		- 자식 클래스의 생성자 내에 super(); 라는 코드가 생략되어있어서, 문제가 없었다. (사실상 Parents(); 가 있었다.)
		 *		- 부모 클래스에서 생성자로 파라미터를 받아야하는 경우에는 super(10); 이 없으면 값을 못받아서 오류가 발생한다.
		 */
		super(10);
		System.out.println("자식 클래스의 생성자");
	}

	
	// - 만약 자식이 10의 값을 받고싶지 않은 경우 자식 클래스에서 재정의 해버린다.
	@Override
	public int getNumber() {
		// - 오류 방지용으로, 일단은 parent가 가지고있는 10을 리턴하고 만약 따로 내용을 쓰고싶으면 아래 식을 바꿔서 재정의해라
		// - super.getNumber() : 부모 클래스의 getNumber() 메서드
		return 100;
	}
	
	// - 자식 클래스에 this로 받아줄 변수가 없고 같은 명칭의 변수가 부모클래스에 있는 경우 자식 클래스의 set으로 받을 수 있다. 
	public void setNumber(int number) {
		super.number = number;
	}
	
}
