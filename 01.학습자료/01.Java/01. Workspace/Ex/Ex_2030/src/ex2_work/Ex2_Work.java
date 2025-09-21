package ex2_work;

public class Ex2_Work {
	//
	private String point;
	private String tel;
	
	// 이자율
	// - 객체를 많이 생성한다고해도, static 변수나 메소드에서는 static 메모리 상에 딱 하나만 생성된다.
	static float interest = 10f;
	//
	public Ex2_Work(String point, String tel) {
		this.point = point;
		this.tel = tel;
	}
	// 결과
	public void getInfo() {
		System.out.println("지점 위치 : "+point);
		System.out.println("전화번호 : "+tel);
		System.out.println("이자율 : "+interest+"%");
		System.out.println("--------------------");
	}
}
