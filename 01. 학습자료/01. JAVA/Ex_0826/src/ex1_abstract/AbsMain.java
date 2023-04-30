package ex1_abstract;

public class AbsMain {

	public static void main(String[] args) {
		
		// heap영역에 들어가는 순서는 object -> parents -> child인데 
		// child에 메서드가 있지만 아직 생성이 되지 않아서 밑에 자동으로 오버라이딩이 뜬다.
		
		// 추상 클래스는 인스턴스 주소를 직접 가질 수 없다. (즉 객체화가 불가능하다.)
		// AbsParent a1 = new AbsParent() {
			
//			@Override
//			public void setValue(int value) {
//				// TODO Auto-generated method stub
//				
//			}
//		};
		
		// 추상 클래스는 자신이 완성하지 못한 기능을 자식이 완성시키도록
		// 조건부 상속하여 자식클래스가 생성될 때, 함께 객체화 된다. 
		AbsChild c = new AbsChild();
		c.setValue(30);
		System.out.println(c.age);
		System.out.println(c.getValue());
	}
}
