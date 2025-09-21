package ex1_method;

public class Ex5_Member_Call {
	/*	[참고] 클래스 멤버, 인스턴스 멤버 간 참조와 호출
	 *		- 같은 클래스에 속한 멤버 (변수, 메소드) 들 간에는 별도의 인스턴스 생성없이 서로 참조, 호출이 가능하다.
	 *		- 단, 클래스 멤버가 인스턴스 멤버를 호출하고자하는 경우 인스턴스를 생성해야 한다. 
	 *			(클래스 멤버 호출 시에, 인스턴스 멤버는 존재하지 않을 수도 있으므로) 
	 */
	int iv = 10;
	static int cv = 20;
	
	int iv2 = cv;
	// static int cv2 = iv;	// [에러] 클래스 변수는 인스턴스 변수를 사용할 수 없음
	static int cv2 = new Ex5_Member_Call().iv;	// 객체를 생성하는 방식으로는 가능하다. (인스턴스가 생성된 후에는 가능하다.)
	
	// 클래스 메소드
	static void staticMethod1() {
		System.out.println(cv);
		// System.out.println(iv);	// [에러] 클래스 메소드에서 인스턴스 변수 사용 불가

		Ex5_Member_Call c = new Ex5_Member_Call();	// 인스턴스 생성 후에는 사용 가능
		System.out.println(c.iv);
	}
	
	// 인스턴스 메소드
	void instanceMethod1() {
		System.out.println(cv);
		System.out.println(iv);		// 인스턴스 메소드에서는 인스턴스 변수 사용 가능
	}
	
	// 클래스 메소드
	static void staticMethod2() {
		staticMethod1();
		// instanceMethod1();		// [에러] 클래스 메소드에서는 인스턴스 메소드 사용 불가
		
		Ex5_Member_Call c = new Ex5_Member_Call();	// 인스턴스 생성 후 사용 가능
		c.instanceMethod1();
	}
	
	// 인스턴스 메소드
	void instanceMethod2() {
		staticMethod1();		// 인스턴스 메소드에서는 클래스, 인스턴스 메소드 모두 인스턴스 생성 따로 없이 호출 가능하다.
		instanceMethod1();
	}
	
}
