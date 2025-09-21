package ex7_work;

public class Ex3_Work extends Ex1_Work {
	// 기본 생성자
	public Ex3_Work() {
		// 부모 (Product) 클래스의 생성자 동작
		super(200);
	}
	
	// 제품 소개
	public String toString() {
		return "Computer";
	}
}
