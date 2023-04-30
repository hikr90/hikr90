package ex6_super;

public class Child extends Parents{
	
	// 자식의 생성자보다 부모 클래스의 생성자가 먼저 생성
	public Child() {
		// super는 부모클래스를 뜻한다.
		// 자식클래스 생성자에는 super(); 이라는 코드가 생략되어있기에 부모클래스의 생성자가 실행된 것 (사실상 Parents();와 같다.)
		// 자식이 만들어지려면 부모가 먼저 만들어져야하는데 그 때문에 super()는 반드시 위에 있어야한다.
		
		// 만약 부모 클래스에 파라미터를 받아야하는 상황에서는 super가 생략되어있으면 값을 받을 수 없어 오류가 난다.
		// 그래서 아래와 같이 값을 받아야한다.
		super(10);
		System.out.println("자식 클래스의 생성자");
	}

	
	// 만약 자식이 10의 값을 받고싶지 않은 경우 자식 클래스에서 재정의 해버린다.
	@Override
	public int getNumber() {
		// 오류 방지용으로, 일단은 parent가 가지고있는 10을 리턴하고 만약 따로 내용을 쓰고싶으면 아래 식을 바꿔서 재정의해라
		// super.getNumber() : 부모 클래스의 getNumber() 메서드
		return 100;
	}
	
	// 자식 클래스에 this로 받아줄 변수가 없고 같은 명칭의 변수가 부모클래스에 있는 경우 자식 클래스의 set으로 받을 수 있다. 
	public void setNumber(int number) {
		super.number = number;
	}
	
}
