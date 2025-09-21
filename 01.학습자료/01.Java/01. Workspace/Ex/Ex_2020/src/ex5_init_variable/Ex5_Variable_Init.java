package ex5_init_variable;

public class Ex5_Variable_Init {
	public static void main(String[] args) {
		/*	멤버변수의 초기화 순서 
		 * 		(1) 시점
		 *			(1.1) 클래스 변수
		 *				- 클래스가 처음 로딩될 때 한번 초기화
		 *
		 *			(1.2) 인스턴스 변수
		 *				- 인스턴스가 생성될 때마다 각 인스턴스 별로 초기화
		 *
		 *		(2) 순서
		 *			(1.3) 클래스 변수 
		 *				- 기본값 > 명시적 초기화 > 클래스 초기화 블럭
		 *
		 *			(1.4) 인스턴스 변수
		 *				- 기본값 > 명시적 초기화 > 인스턴스 초기화 블럭 > 생성자
		 */
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		
		System.out.println("p1의 제품번호 (serialno) : " + p1.serialNo);
		System.out.println("p2의 제품번호 (serialno) : " + p2.serialNo);
		System.out.println("p3의 제품번호 (serialno) : " + p3.serialNo);
		System.out.println("생성된 제품의 수는 모두 " + Product.count + "입니다.");
	}
}

class Product {
	static int count = 0;	// 생성된 인스턴스의 수를 저장하기 위한 변수
	int serialNo = count;	// 인스턴스 고유 번호
	
	{
		++count;			//  Product 인스턴스가 생성될 때마다 count의 값을 1씩 증가시켜서 serialNo에 저장된다.
		serialNo = count;
	}
	
	public Product() {};
}