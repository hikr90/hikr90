package ex4_inheritance;

public class Snake extends Animal{
	// Animal을 상속받는 Snake 클래스 
	String sence = "감각이 발달";
	
	/*	오버라이딩
	 * 	- 메소드의 재정의
	 * 	- 이미 부모가 가지고있는 메소드를 가져와서, 자식 클래스에서 재정의하여 덮어쓰는 행위를 뜻한다.
	 * 	- 상속의 관계에서만 가능하다.
	 * 
	 */
	@Override
	public int getLeg() {
		return 0;
	}
}
