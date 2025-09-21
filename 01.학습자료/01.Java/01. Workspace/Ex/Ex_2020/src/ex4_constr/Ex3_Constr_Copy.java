package ex4_constr;

public class Ex3_Constr_Copy {
	public static void main(String[] args) {
		/*	������ �ν��Ͻ� ����
		 * 		- �ν��Ͻ��� �����, ���� �������ִ� �ν��Ͻ��� �ϳ� �� ����� ������ ���Ѵ�.
		 * 		- �� �ν��Ͻ��� ��� �ν��Ͻ� �����°� ������ ���� ������ �ִٴ� ���� �ǹ��Ѵ�.
		 * 
		 */
		Car2 c1 = new Car2();
		Car2 c2 = new Car2(c1);		// ����
		
		System.out.println("c1 color : " + c1.color + ", gearType : " + c1.gearType + ", door : " + c1.door);
		System.out.println("c2 color : " + c2.color + ", gearType : " + c2.gearType + ", door : " + c2.door);
		
		//
		c1.door = 100;
		System.out.println("c1 door : " + c1.door);
		
		System.out.println("c1 color : " + c1.color + ", gearType : " + c1.gearType + ", door : " + c1.door);
		System.out.println("c2 color : " + c2.color + ", gearType : " + c2.gearType + ", door : " + c2.door);
		
		// [����] ����� �ν��Ͻ��� ������ �޸� ������ �����ϹǷ�, ���� ����Ǿ ������ ������ ��ġ�� �ʴ´�.
	}
}

class Car2 {
	String color;
	String gearType;
	int door;
	
	Car2() {
		this("white", "auto", 4);
	}
	
	Car2(Car2 c) {
		color = c.color;
		gearType = c.gearType;
		door = c.door;
	}
	
	Car2(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}