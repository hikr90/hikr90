package ex4_inheritance;

public class Snake extends Animal{
	String sence = "감각이 발달";
	
	// 메서드의 오버라이딩
	// 메서드의 재정의
	// 이미 부모가 가지고있는 메서드를 가지고와서, 자식 클래스에서 내용을 자식의 사정에 맞춰서 재정의 하는 것
	// 반드시 상속 관계의 객체에서 가능하다. 
	@Override
	public int getLeg() {
		return 0;
	}
	
}
