package ex1_object_oriented;

public class Ex1_Object_Oriented {
	public static void main(String[] args) {
		
		/* 객체지향
		 * 		- 실제 세계는 객체로 구성되어 있으며 발생하는 모든 사건은 객체간의 상호작용 이라는 개념
		 * 	
		 * 		(1) 객체지향 언어의 특징
		 * 			(1.1) 코드의 재사용성이 높다.
		 * 			(1.2) 코드의 관리가 용이하다.
		 * 			(1.3) 코드의 신뢰성이 높다. (제어자, 메소드, 중복 코드 제거)
		 * 
		 * 		(2) 객체지향 (프로그래밍 관점)
		 * 			- 데이터와 함수의 결합 (구조체 + 함수)
		 * 			- 서로 관련된 변수들을 정의하고 이들에 대한 작업을 수행하는 함수들을 함께 정의한 것
		 */
		
		// 클래스 생성
		// 	- (1) 클래스의 객체를 참조하기위한 참조변수 선언
		// 	- (2) 클래스의 객체 생성 후, 객체의 주소를 참조변수에 저장
		Ex1_1_Object_Oriented c1 = new Ex1_1_Object_Oriented();	// 공장에서 생산한 컴퓨터를 내가 구매
		
		// 객체 c1이 생성되었으므로 해당 객체 접근하여 hdd 등의 정보를 가져올 수 있다.
		System.out.println(c1.hdd);
		System.out.println(c1.ram);
		System.out.println(c1.cpu);
		System.out.println(c1.color);
		
		System.out.println("---------------");
		
		// 클래스 생성
		Ex1_1_Object_Oriented c2 = new Ex1_1_Object_Oriented();	// 친구도 공장에서 생산한 동일한 컴퓨터를 구매
		
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

//
class Ex1_1_Object_Oriented {
	// 컴퓨터의 구성을 뜻하는 설계도 (클래스)
	// - 메인 클래스는 설계도 클래스를 사용하기 위한 개념으로 메인 클래스는 설계도 역할을 하지 않는다.

	// - 컴퓨터의 구성품
	int hdd = 500;
	int ram = 16;
	float cpu = 2.5f;
	String color = "white";
	
	/*	접근제어자 
	 * 	- 해당 메소드의 접근 권한을 지정하는 키워드
	 * 
	 * 		(1) public : 같은 프로젝트 내의 모든 객체에 접근 허가
	 * 		(2) private : 현재 클래스 내에서만 접근 허가 (보안의 목적으로 사용)
	 * 		(3) protected : 상속 관계에서의 객체에서만 허가
	 * 		(4) default : 접근제한자에 아무 내용도 넣지 않은 경우 같은 패키지내의 객체만 접근 허가 
	 * 
	 * 		(1) 범위
	 * 			- (넓음) public > protected > (default) > private (좁음)
	 * 
	 * 
	 * 		(2) 접근제어자와 캡슐화
	 * 			- 접근제어자는 클래스 내부에 선언된 데이터 보호에 목적을 둔다.
	 * 			- 데이터 감추기라고도 하며, 객체지향 개념의 캡슐화라고도 한다.
	 * 			- 데이터의 값이 유효하도록 (비밀번호처럼 외부에서 접근할 수 없는) 접근을 제어하거나, 외부에 접근할 필요가 없는 값들을 private 등의 제어자로 복잡성을 줄이는 것을 캡슐화라고 한다.
	 */
	private String company = "LG";	// 제조사는 변경되어서는 안되는 정보로 private를 사용
	
	// 컴퓨터의 정보를 반환하는 메소드 생성
	// - heap 영역에 있는 c1의 객체에 getInfo 라는 기능을 추가한다.
	
	/* 		(3) 반환타입
	 *			- 메소드 동작 후 반환하는 형태
	 *			- 리턴 값은 String, int, char 등의 자료형이 해당된다.
	 *			- void는 System.out.println 처럼 보여주는 형태의 리턴 타입이다. 
	 */
	public void getInfo() {
		System.out.println("제조사 : "+company);
		System.out.println("hdd : "+hdd+"GB");
		System.out.println("ram : "+ram+"GB");
		System.out.println("cpu : "+cpu+"GHz");
		System.out.println("color : "+color);
		System.out.println("------------------");
	}
}
