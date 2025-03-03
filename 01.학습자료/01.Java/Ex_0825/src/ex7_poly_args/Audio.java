package ex7_poly_args;

public class Audio extends Product{
	// 기본 생성자
	public Audio() {
		// 부모 (Product) 클래스의 생성자 동작
		super(50);
	}
	
	// 제품 소개
	public String toString() {
		return "Audio";
	}
}
