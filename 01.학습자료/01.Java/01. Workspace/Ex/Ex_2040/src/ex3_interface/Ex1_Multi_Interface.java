package ex3_interface;

public interface Ex1_Multi_Interface extends Ex3_Multi_Interface, Ex4_Multi_Interface, Ex5_Multi_Interface{
	/*	인터페이스의 다중 상속
	 * 		- 하나의 자식이 하나의 부모만을 가질 수 있는 상속과 다르게 인터페이스는 내부에 추상 메소드만 존재하므로 다중 상속이 가능하다.
	 * 		- 상속 방식은 아래와 같다.
	 * 
	 * 		[참고] interface 인터1 extends 인터2, 인터3... 
	 */
	String jabchae();
}


class Ex6_Multi_Interface {
	public static void main(String[] args) {
		// 주방 클래스 객체화
		Ex2_Multi_Interface kit = new Ex2_Multi_Interface();
		
		// 메뉴 확인
		System.out.println(kit.jjajang());
		System.out.println(kit.tangsuyuck());
		System.out.println(kit.boggembab());
	}
}

interface Ex5_Multi_Interface {
	String boggembab();
}

interface Ex4_Multi_Interface {
	// 
	String tangsuyuck();
}

interface Ex3_Multi_Interface {
	// 인터페이스 내에서는 abstract 를 사용하지 않아도 추상 메소드로 인지한다.
	abstract String jjajang();
	String jjambbong();
}

class Ex2_Multi_Interface implements Ex1_Multi_Interface{
	
	@Override
	public String jjajang() {
		return "중면 + 춘장 + 양파";
	}
	
	@Override
	public String jjambbong() {
		return "홍합 + 키조개 + 중면";
	}

	@Override
	public String tangsuyuck() {
		return "돼지고기 + 튀김가루 + 각종양념";
	}

	@Override
	public String boggembab() {
		return "이천쌀 + 짜장소스";
	}

	@Override
	public String jabchae() {
		return "깨 + 당면";
	}
}
