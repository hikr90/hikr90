package ex4_interface;

public class User {
	public static void main(String[] args) {
		// 주방 클래스 객체화
		Kitchen kit = new Kitchen();
		
		// 메뉴 확인
		System.out.println(kit.jjajang());
		System.out.println(kit.tangsuyuck());
		System.out.println(kit.boggembab());
	}
}
