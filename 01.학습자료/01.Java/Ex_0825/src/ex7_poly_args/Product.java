package ex7_poly_args;

public class Product {
	//
	int price;
	int bounsPoint;
	//  생성자
	public Product (int price){
		// 생성자 동작 시, 가격과 포인트 적립 값을 지정
		this.price = price;
		this.bounsPoint = (int)(price/10.0);
	}
	// 기본 생성자
	public Product() {
		//  값 초기화
		price = 0;
		bounsPoint = 0;
	}
}
