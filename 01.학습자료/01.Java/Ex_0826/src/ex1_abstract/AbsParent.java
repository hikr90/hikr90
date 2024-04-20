package ex1_abstract;

	// 추상 클래스 
	// 추상 클래스는 추상 메서드를 한개라도 가지고 있는 클래스를 의미한다. 
	// 추상 클래스임을 명시하기위해 반드시 abstract키워드를 붙여줘야한다. 
public abstract class AbsParent {
	int value = 100;
	String str = "안녕";
	
	// 추상 메서드
	// 추상 메서드는 맨 앞에 abstract를 붙이고 body{}가 없다. 
	// 추상 메서드는 몸체가 없으므로 이를 "미완성의 개념"이라고 부르는데,
	// 추상 메서드를 자식이 상속받아 완성시키는 것이 조건이 된다.
	abstract public void setValue(int value);
	

	public int getValue() {
		return value;
	}
	
}
