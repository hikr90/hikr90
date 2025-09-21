package ex3_inheritance;

public class Ex3_Inclusion_Relation {
	public static void main(String[] args) {
		/*	클래스 간의 관계
		 * 		- 상속 이외에 클래스를 재사용하는 방법
		 * 		- 클래스 간 포함 관계를 맺어주는 방식으로, 한 클래스의 멤버 변수로 다른 클래스 타입의 참조변수를 선언하는 것을 뜻한다.
		 * 
		 *		[참고] Point클래스를 재사용하여 Circle 클래스 작성
		 *			class Circle extends Point {	// Point p = new Point(); 와 같다.
		 *				int r;	
		 *			} 
		 *
		 *			class Point {
		 *				int x, y; 		// 원점 좌표  x, y
		 *			}
		 *			
		 *
		 *		(1) 클래스 간 관계 결정
		 *			- Circle은  Point이다.				// 상속 관계
		 *			- Circle은 Point를 가지고 있다.		// 포함 관계
		 *
		 *		(2) 참조변수 <> 인스턴스 연결
		 *			(2.1) 변수의 경우
		 *				- 부모의 멤버와 같은 이름의 멤버가 자식에 있을 경우 선언 방식에 따라서 결과가 달라진다.
		 *					Parent p = new Child();		// 부모 멤버 사용
		 *					Child c = new Child();		// 자식 멤버 사용
		 *		
		 *			(2.2) 자식의 경우
		 *				- 부모 <> 자식 간 메소드가 오버라이딩 상관없이 자식 (실제 인스턴스 )가 호출된다.
		 *				- static 메소드의 경우 참조변수의 타입에 영향을 받으므로 클래스.메소드 방식인  Parent.method(); 처럼 호출된다.
		 */
		Point [] p = {
			new Point(100, 100),
			new Point(140, 50),
			new Point(200, 100)
		};
		//
		Triangle t = new Triangle(p);
		Circle c = new Circle(new Point(150, 150), 50);
		//
		t.draw();
		c.draw();
	}
}

// 도형
class Shape {
	String color = "black";
	void draw() {
		System.out.printf("color : %s", color);
	}
}

// 점
class Point {
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point() {
		this(0, 0);
	}
	
	String getXY() {
		return "(" + x + "," + y + ")";
	}
}

// (상속관계) 원은 도형이다. 
class Circle extends Shape {
	// (포함관계) 원은 점을 가지고 있다.
	Point center;
	int r;
	
	Circle() {
		this(new Point(0, 0), 100);
	}

	public Circle(Point center, int r) {
		this.center = center;
		this.r = r;
	}
	
	void draw() {
		System.out.printf("center : (%d, %d), r : %d, color : %n", center.x, center.y, r, color);
	}
}

// (상속관계) 세모는 도형이다.
class Triangle extends Shape {
	// (포함관계) 세모는 점을 가지고 있다.
	Point [] p = new Point[3];
	
	public Triangle(Point [] p) {
		this.p = p;
	}
	
	void draw() {
		System.out.printf("p1 : %s, p2 : %s, p3 : %s, color : %n", p[0].getXY(), p[1].getXY(), p[2].getXY(), color);
	}
}
