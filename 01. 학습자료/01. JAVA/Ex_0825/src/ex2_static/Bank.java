package ex2_static;

public class Bank {
	
	// 은행 위치
	private String point;
	// 은행 전화번호
	private String tel;
	
	// 이자율
	// 객체를 아무리 많이 생성한다고 해도 static변수나 static메서드는 메모리상에 딱 하나만 생성된다.
	static float interest = 10f;
	
	public Bank(String point, String tel) {
		this.point = point;
		this.tel = tel;
	}
	
	// 결과 출력을 위한 메서드
	public void getInfo() {
		System.out.println("지점 위치 : "+point);
		System.out.println("전화번호 : "+tel);
		System.out.println("이자율 : "+interest+"%");
		System.out.println("--------------------");
	}
	
	
	
}
