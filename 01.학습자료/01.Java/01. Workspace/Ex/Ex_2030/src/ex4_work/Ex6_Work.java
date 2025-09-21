package ex4_work;

public class Ex6_Work extends Ex2_Work{
	// Animal을 상속받는 Snake 클래스 
	String sence = "감각이 발달";
	
	/*	오버라이딩
	 * 	- 메소드의 재정의
	 * 	- 이미 부모가 가지고있는 메소드를 가져와서, 자식 클래스에서 재정의하여 덮어쓰는 행위
	 * 	- 상속의 관계에서만 가능하다.
	 * 
	 * 	오버라이딩 조건
	 * 		- 메소드의 선언부는 부모와 완전히 같아야 한다. (이름, 매개변수, 반환타입)
	 * 		- 다만, 접근제어자와 예외는 제한된 조건 하에서는 다르게 변경할 수 있다.
	 * 		
	 * 		(1) 접근제어자는 부모 클래스의 메소드보다 좁은 범위로 변경할 수 없다.
	 * 			- 부모 클래스 메소드의 접근제어자가 protected >>>> 자식 클래스 (오버라이딩) 는 protected 혹은 public만 가능
	 * 			- 접근제어자의 넓이 (넓음) public > protected > (default) > private (좁음)
	 * 
	 * 		(2) 부모 클래스의 메소드보다 많은 수의 예외 선언이 불가하다.
	 * 		(3) 부모 클래스의 인스턴스 메소드를 static 메소드 혹은 그 반대로 선언 불가하다.
	 */
	
	@Override
	public int getLeg() {
		return 0;
	}
}
