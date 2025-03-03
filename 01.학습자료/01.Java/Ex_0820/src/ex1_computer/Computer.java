package ex1_computer;

public class Computer {
		
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
	 * 	범위
	 * 		(넓음) public > protected > (default) > private (좁음)
	 * 
	 * 
	 * 	접근제어자와 캡슐화
	 * 		- 접근제어자는 클래스 내부에 선언된 데이터 보호에 목적을 둔다.
	 * 		- 데이터 감추기라고도 하며, 객체지향 개념의 캡슐화라고도 한다.
	 * 		- 데이터의 값이 유효하도록 (비밀번호처럼 외부에서 접근할 수 없는) 접근을 제어하거나, 외부에 접근할 필요가 없는 값들을 private 등의 제어자로 복잡성을 줄이는 것을 캡슐화라고 한다.
	 */
	private String company = "LG";	// 제조사는 변경되어서는 안되는 정보로 private를 사용
	
	// 컴퓨터의 정보를 반환하는 메소드 생성
	// - heap 영역에 있는 c1의 객체에 getInfo 라는 기능을 추가한다.
	
	/* 반환타입
	 *		- 메소드 동작 후 반환하는 형태
	 *		- 리턴 값은 String, int, char 등의 자료형이 해당된다.
	 *		- void는 System.out.println 처럼 보여주는 형태의 리턴 타입이다. 
	 */
	public void getInfo() {
		System.out.println("제조사 : "+company);
		System.out.println("hdd : "+hdd+"GB");
		System.out.println("ram : "+ram+"GB");
		System.out.println("cpu : "+cpu+"GHz");
		System.out.println("color : "+color);
		System.out.println("------------------");
	}

	public static void main(String[] args) {
		
	}
}
