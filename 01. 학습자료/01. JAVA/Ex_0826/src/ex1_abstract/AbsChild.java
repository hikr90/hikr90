package ex1_abstract;

public class AbsChild extends AbsParent{
	
	int age = 10; 
	
	// 추상 클래스를 상속받은 자식은 부모의 추상 메서드를 무조건 오버라이딩(재정의)해야한다.
	// 자식 사정에 맞도록 내용까지 재 정의할 필요는 없지만, 메서드 자체는 반드시 들고있어야한다. 
	@Override
	public void setValue(int n) {
		age = n;
	}

	
	
	
}
