package ex6_super;

// 자식
public class Ex1_Super extends Ex1_1_Super{
	public Ex1_Super() {
		/*	super
		 * 		- 자식이 부모로부터 상속받은 멤버 참조에 사용되는 참조변수
		 * 			(부모 클래스를 뜻한다.)
		 * 
		 * 		- 부모와 자식을 구별하는데 사용된다는 점에서는 this와 같다.
		 * 			(모든 인스턴스 메소드에서는 자신이 속한 인스턴스의 주소가 지역변수로 저장된다.)
		 * 
		 * 		- this처럼 클래스 메소드에서는 사용할 수 없다.
		 * 		- super.메소드 형식으로 사용한다.
		 * 		- 자식의 생성자가 동작하기위해서 반드시 부모의 생성자가 먼저 동작한다.
		 * 			(자식에서 부모의 멤버를 사용할 수 없으므로 부모의 멤버가 먼저 초기화 되어야 한다.)
		 * 			(메소드 내 super가 따로 없는 경우 컴파일러가 자동으로 자식 생성자에 super(); 를 삽입하여 동작한다.)
		 */
		
		//  부모 클래스인 Parents 내 기본 생성자가 따로 없기에, int 값을 받는 생성자를 호출해야한다. (혹은 super(10)을 제거하고 Parents에 기본 생성자를 추가한다.)
		super(10);
		System.out.println("자식 클래스의 생성자");
	}

	// 만약 자식이 10의 값을 받고싶지 않은 경우 자식 클래스에서 재정의 해버린다.
	@Override
	public int getNumber() {
		// 오류 방지용으로, 일단은 parent가 가지고있는 10을 리턴하고 만약 따로 내용을 쓰고싶으면 아래 식을 바꿔서 재정의하면 된다.
		// super.getNumber() : 부모 클래스의 getNumber() 메서드
		return 100;
	}
	
	// 자식 클래스에 this로 받아줄 변수가 없고 같은 명칭의 변수가 부모클래스에 있는 경우 자식 클래스의 set으로 받을 수 있다. 
	public void setNumber(int number) {
		super.number = number;
	}
}

// 부모
class Ex1_1_Super {
	//
	int number = 10;
	//
	public Ex1_1_Super(int n) {
		System.out.println("부모클래스의 생성자");
	}
	//
	public int getNumber() {
		return number;
	}
}

// 메인 클래스
class Ex1_2_Super {
	public static void main(String[] args) {
		// 자식 클래스 객체화
		Ex1_Super c = new Ex1_Super();
		
		System.out.println(c.getNumber());
		
		// - 자식클래스에서는 number 변수가 없으므로 부모의 int로 들어간다.
		c.setNumber(500);
		System.out.println(c.number);
	}
}