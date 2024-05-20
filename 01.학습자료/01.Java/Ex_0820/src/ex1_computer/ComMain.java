package ex1_computer;

public class ComMain {
	public static void main(String[] args) {
		
		/* 클래스
		 *		- 객체를 정의하는 틀, 또는 설계도
		 *		- 객체의 상태를 뜻하는 필드와 객체의 행동을 뜻하는 메소드로 구성되어있다.
		 *
		 *		- 클래스를 사용하는 클래스는 메인이 필요하다.
		 */
		// 클래스 생성
		Computer c1 = new Computer();	// 공장에서 생산한 컴퓨터를 내가 구매
		
		// 객체 c1이 생성되었으므로 해당 객체 접근하여 hdd 등의 정보를 가져올 수 있다.
		System.out.println(c1.hdd);
		System.out.println(c1.ram);
		System.out.println(c1.cpu);
		System.out.println(c1.color);
		
		System.out.println("---------------");
		
		// 클래스 생성
		Computer c2 = new Computer();	// 친구도 공장에서 생산한 동일한 컴퓨터를 구매
		
		// 같은 제품이니 같은 정보를 가져올 수 있다.
		System.out.println(c2.hdd);
		System.out.println(c2.ram);
		System.out.println(c2.cpu);
		System.out.println(c2.color);
		
		System.out.println("---------------");
		
		
		// 클래스의 속성 값을 수정한다.
		c2.hdd = 1000;		// 친구가 자기 컴퓨터의 hdd를 업그레이드했다.
		System.out.println(c2.hdd);
		
		System.out.println("---------------");
		
		// 클래스와 객체
		// - 내 컴퓨터와 친구의 컴퓨터는 같은 설계도로 제작되었으나 서로 다른 물건이다.
		// - 하나의 설계도 (클래스) 로 두개의 제품 (객체) 을 생성한 것이다.
		c1.getInfo();
		c2.getInfo();
		
		// - 접근제한자 private가 있는 변수나 메소드는 타 클래스에서 접근할 수 없다.
		//c2.company = "apple";
	}
}
