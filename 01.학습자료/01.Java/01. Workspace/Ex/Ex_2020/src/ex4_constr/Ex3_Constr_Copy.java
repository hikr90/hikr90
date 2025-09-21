package ex4_constr;

public class Ex3_Constr_Copy {
	public static void main(String[] args) {
		/*	생성자 인스턴스 복사
		 * 		- 인스턴스의 복사란, 현재 가지고있는 인스턴스를 하나 더 만드는 행위를 뜻한다.
		 * 		- 두 인스턴스의 모든 인스턴스 변수는가 동일한 값을 가지고 있다는 것을 의미한다.
		 * 
		 */
		Car2 c1 = new Car2();
		Car2 c2 = new Car2(c1);		// 복사
		
		System.out.println("c1 color : " + c1.color + ", gearType : " + c1.gearType + ", door : " + c1.door);
		System.out.println("c2 color : " + c2.color + ", gearType : " + c2.gearType + ", door : " + c2.door);
		
		//
		c1.door = 100;
		System.out.println("c1 door : " + c1.door);
		
		System.out.println("c1 color : " + c1.color + ", gearType : " + c1.gearType + ", door : " + c1.door);
		System.out.println("c2 color : " + c2.color + ", gearType : " + c2.gearType + ", door : " + c2.door);
		
		// [참고] 복사된 인스턴스는 독립된 메모리 공간에 존재하므로, 값이 변경되어도 원본에 영향을 미치지 않는다.
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