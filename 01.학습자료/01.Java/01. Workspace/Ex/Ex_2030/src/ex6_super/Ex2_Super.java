package ex6_super;

public class Ex2_Super {
	public static void main(String[] args) {
		/*	Super();
		 * 		- ���� Ŭ������ �����ڸ� ȣ���ϴ� Ű����
		 * 		- �ڼ� Ŭ������ �ν��Ͻ��� �����ϸ� �ڼ� + ������ �ν��Ͻ��� �����ȴ�.
		 * 			(�� �� ���� Ŭ���� ����� �ʱ�ȭ�� �Ǿ���ϹǷ� �ڼ� Ŭ�������� ���� Ŭ������ �����ڰ� ȣ��Ǿ�� �Ѵ�.)
		 * 
		 *  	- ���� Ŭ���� �������� ȣ���� ��Ӱ��踦 �Ž��� �ö󰡸鼭 �ֻ��� Ŭ������ ObjectŬ�������� �ö󰣴�.
		 *  		(�׷��� ObjectŬ������ ������ ��� Ŭ������ �����ڴ� ù �ٿ� �ݵ�� �ڽ��� �ٸ� ������ �Ǵ� ������ �����ڸ� ȣ���ؾ� �Ѵ�.)
		 *  		(���� �߰��Ǿ����� ���� ��� �����Ϸ����� ������ ù�ٿ� �ڵ����� super();�� �߰��Ѵ�.)
		 * 
		 * 		[����] super() �� ��� �ʱ�ȭ ����
		 *			- ���� > �ڽ� > �θ� > Object
		 */
		Point3D p3 = new Point3D();
		
		System.out.println("p3.x : " + p3.x);
		System.out.println("p3.y : " + p3.x);
		System.out.println("p3.z : " + p3.x);
	}
}

// [����] �ν��Ͻ� �ʱ�ȭ ����
// 	- Point3D() > Point3D(int x, int y, int z) > Point(int x, int y) > Object
class Point {		// (4) extends Object �� �����Ǿ��ִ�.
	int x = 10;
	int y = 20;
	
	public Point(int x, int y) {
		// super(); 			// (3) �����Ϸ��� �ڵ������� ����
		this.x = x;
		this.y = y;
	}
}

class Point3D extends Point {
	int z = 30;
	
	// (1) �ڽ� ������ ȣ��
	public Point3D() {
		this(100, 200, 300);
	}
	
	Point3D(int x, int y, int z) {
		super(x, y);	// (2) �θ���� Point(int x, int y)�� ȣ���Ѵ�.
		this.z = z;
	}
}
