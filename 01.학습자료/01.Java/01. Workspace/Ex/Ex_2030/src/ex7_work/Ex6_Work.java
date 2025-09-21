package ex7_work;

public class Ex6_Work extends Ex1_Work{
	// 기본 생성자
	public Ex6_Work() {
		// 부모 (Product) 클래스의 생성자 동작
		super(50);
	}
	
	// 제품 소개
	public String toString() {
		return "Audio";
	}
}
