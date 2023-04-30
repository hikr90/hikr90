package ex3_inheritance;

public class ExtendsMain {
	
	public static void main(String[] args) {
		
		// Child 객체 생성
		// Child가 Parents를 상속받았기 때문에 money나, str을 호출하여 사용할 수 있다.
		// 상속 관계의 자식 객체는 부모가 가진 속성들을 마음대로 가져다 사용할 수 있다. 
		Child c = new Child();
		System.out.println(c.money);
		System.out.println(c.car);

		// 좌측 객체가 우측 클래스의 자식인지를 확인하는 연산자
		// 인스턴스 : c.으로 접근할 때, c(객체)의 주소값과 부모클래스의 주소값이 같은가?
		// 인스턴스가 같다 = 주소값이 같다.
		// c는 Parents의 자식클래스입니까?
		if(c instanceof Parents) {
			System.out.println("c는 Parents의 자식입니다.");
		}
	
		System.out.println("-------------------");
		
		// 부모클래스의 객체화
		// 상속관계의 객체라고 할지라도 부모클래스는 자식의 필드(속성)를 마음대로 사용할 수 없다.
		Parents p = new Parents();
		
		
		// java.lang.object는 최상위 클래스로서, extends를 사용하지 않아도 기본으로 있다.
		// 즉, 자식클래스를 객체화할 때 실제로는 heap영역에 object가 먼저 만들어진다.
		// 그 주소값을 타고 들어와 parents -> 부모의 주소값을 타고들어와 -> 자식의 클래스 영역이 생성된다.
		
		if(c instanceof Object) {
			System.out.println("자식 클래스와 부모클래스는 object클래스에 상속되어있다.");
		}
		
	
		// 생성자 : 메모리 생성
		// 상속의 장점 : 객체간에 공통점을 가지고있는 경우에 메모리를 절약하고 부모가 가지고있는 속성들을 언제든 자식이 공통적으로 가져다 사용할 수 있다.

		Child c2 = new Child();
		Parents p2 = new Child(); 
		
		// 차이
		// 인터페이스 챔피언 (q, w, e, r) 추상메서드 
		// 가렌, 다리우스, 람머스 
		// 가렌 garen (q,w,e,r)
		// 다리우스 (q,w,e,r)
		// 람머스 (q,w,e,r)
		// 껍데기의 기능을 사용할 수 있다.
		// ch g1 = new garen();
		// ch g2 = new dari();
		// ch g3 = new ramus();
		
	}
}
