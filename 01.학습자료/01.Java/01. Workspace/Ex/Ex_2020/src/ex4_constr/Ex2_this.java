package ex4_constr;

public class Ex2_this {
	public static void main(String[] args) {
		/* this & this()
		 * 	(1) this
		 * 		- 자기 자신을 가르키는 참조변수로, 인스턴스의 주소가 저장되어 있다.
		 * 		- 인스턴스 변수와 생성자 매개변수가 명칭이 같아 혼동되는 것을 방지하기위해서 사용한다.
		 * 		- 인스턴스 멤버 사용이 안되는 static 메소드에서는 사용할 수 없다.	 * 
		 * 
		 * 		[참고] 모든 인스턴스 메소드(생성자 포함)에는 참조변수 this가 지역변수가 숨겨진 채로 존재한다.
		 * 		
		 * 	(2) this()
		 * 		- 생성자 내에서 다른 생성자를 호출하는 방식
		 */
		Car c1 = new Car();
		Car c2 = new Car("blue");
		
		System.out.println("c1 color : " + c1.color + ", gearType : " + c1.gearType + ", door = " + c1.door);
		System.out.println("c2 color : " + c2.color + ", gearType : " + c2.gearType + ", door = " + c2.door);
	}
}

//
class Car {
	String color;
	String gearType;
	int door;
	
	public Car() {
		this("white", "auto", 4);
	}
	
	Car(String color) {
		this(color, "auto", 4);
	}
	
	Car(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}