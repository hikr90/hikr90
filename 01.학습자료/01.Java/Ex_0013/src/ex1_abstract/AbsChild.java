package ex1_abstract;

public class AbsChild extends AbsParent{
	//
	int age = 10; 
	
	// - 추상 클래스를 상속받은 자식은 부모의 추상 메소드를 반드시 재정의 해야한다.
	@Override
	public void setValue(int n) {
		age = n;
	}
}
