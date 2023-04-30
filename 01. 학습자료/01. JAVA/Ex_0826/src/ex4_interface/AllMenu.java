package ex4_interface;

// 인터페이스는 일반클래스와 달리 직접적인 구현능력이 없기 때문에 다중상속이 가능하다. 
// 인터페이스는 인터페이스들끼리 상속(다중 상속)이 된다. 
public interface AllMenu extends Menu1, Menu2, Menu3{
	// 여러장의 메뉴를 하나로 통합
	
	String jabchae();
	
}
