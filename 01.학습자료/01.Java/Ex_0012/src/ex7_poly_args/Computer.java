package ex7_poly_args;

public class Computer extends Product {
	// 기본 생성자
	public Computer() {
		// 부모 (Product) 클래스의 생성자 동작
		super(200);
	}
	
	// 제품 소개
	public String toString() {
		return "Computer";
	}
}
