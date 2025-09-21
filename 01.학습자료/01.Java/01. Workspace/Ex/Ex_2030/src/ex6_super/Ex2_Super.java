package ex6_super;

public class Ex2_Super {
	public static void main(String[] args) {
		/*	Super();
		 * 		- 조상 클래스의 생성자를 호출하는 키워드
		 * 		- 자손 클래스의 인스턴스를 생성하면 자손 + 조상의 인스턴스가 생성된다.
		 * 			(이 때 조상 클래스 멤버의 초기화가 되어야하므로 자손 클래스에서 조상 클래스의 생성자가 호출되어야 한다.)
		 * 
		 *  	- 조상 클래스 생성자의 호출은 상속관계를 거슬러 올라가면서 최상위 클래스인 Object클래스까지 올라간다.
		 *  		(그래서 Object클래스를 제외한 모든 클래스의 생성자는 첫 줄에 반드시 자신의 다른 생성자 또는 조상의 생성자를 호출해야 한다.)
		 *  		(만약 추가되어있지 않은 경우 컴파일러에서 생성자 첫줄에 자동으로 super();를 추가한다.)
		 * 
		 * 		[참고] super() 의 멤버 초기화 순서
		 *			- 손자 > 자식 > 부모 > Object
		 */
		Point3D p3 = new Point3D();
		
		System.out.println("p3.x : " + p3.x);
		System.out.println("p3.y : " + p3.x);
		System.out.println("p3.z : " + p3.x);
	}
}

// [참고] 인스턴스 초기화 순서
// 	- Point3D() > Point3D(int x, int y, int z) > Point(int x, int y) > Object
class Point {		// (4) extends Object 가 생략되어있다.
	int x = 10;
	int y = 20;
	
	public Point(int x, int y) {
		// super(); 			// (3) 컴파일러가 자동적으로 삽입
		this.x = x;
		this.y = y;
	}
}

class Point3D extends Point {
	int z = 30;
	
	// (1) 자식 생성자 호출
	public Point3D() {
		this(100, 200, 300);
	}
	
	Point3D(int x, int y, int z) {
		super(x, y);	// (2) 부모격인 Point(int x, int y)를 호출한다.
		this.z = z;
	}
}
