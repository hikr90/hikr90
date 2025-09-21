package ex3_inheritance;

public class Ex3_Inclusion_Relation {
	public static void main(String[] args) {
		/*	Ŭ���� ���� ����
		 * 		- ��� �̿ܿ� Ŭ������ �����ϴ� ���
		 * 		- Ŭ���� �� ���� ���踦 �ξ��ִ� �������, �� Ŭ������ ��� ������ �ٸ� Ŭ���� Ÿ���� ���������� �����ϴ� ���� ���Ѵ�.
		 * 
		 *		[����] PointŬ������ �����Ͽ� Circle Ŭ���� �ۼ�
		 *			class Circle extends Point {	// Point p = new Point(); �� ����.
		 *				int r;	
		 *			} 
		 *
		 *			class Point {
		 *				int x, y; 		// ���� ��ǥ  x, y
		 *			}
		 *			
		 *
		 *		(1) Ŭ���� �� ���� ����
		 *			- Circle��  Point�̴�.				// ��� ����
		 *			- Circle�� Point�� ������ �ִ�.		// ���� ����
		 *
		 *		(2) �������� <> �ν��Ͻ� ����
		 *			(2.1) ������ ���
		 *				- �θ��� ����� ���� �̸��� ����� �ڽĿ� ���� ��� ���� ��Ŀ� ���� ����� �޶�����.
		 *					Parent p = new Child();		// �θ� ��� ���
		 *					Child c = new Child();		// �ڽ� ��� ���
		 *		
		 *			(2.2) �ڽ��� ���
		 *				- �θ� <> �ڽ� �� �޼ҵ尡 �������̵� ������� �ڽ� (���� �ν��Ͻ� )�� ȣ��ȴ�.
		 *				- static �޼ҵ��� ��� ���������� Ÿ�Կ� ������ �����Ƿ� Ŭ����.�޼ҵ� �����  Parent.method(); ó�� ȣ��ȴ�.
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

// ����
class Shape {
	String color = "black";
	void draw() {
		System.out.printf("color : %s", color);
	}
}

// ��
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

// (��Ӱ���) ���� �����̴�. 
class Circle extends Shape {
	// (���԰���) ���� ���� ������ �ִ�.
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

// (��Ӱ���) ����� �����̴�.
class Triangle extends Shape {
	// (���԰���) ����� ���� ������ �ִ�.
	Point [] p = new Point[3];
	
	public Triangle(Point [] p) {
		this.p = p;
	}
	
	void draw() {
		System.out.printf("p1 : %s, p2 : %s, p3 : %s, color : %n", p[0].getXY(), p[1].getXY(), p[2].getXY(), color);
	}
}
