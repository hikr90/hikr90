
package ex5_init_variable;

public class Ex3_Init_Block {
	public static void main(String[] args) {
		/*	초기화 블럭
		 * 		(1) 클래스 초기화 블럭
		 * 			- 클래스 변수의 초기화
		 * 			- 클래스 내 인스턴스 블럭 { } 앞에 static을 붙여 사용한다.
		 * 			- 클래스에 메모리가 처음 로딩될 때 한번 수행된다. (가장 먼저 수행)
		 * 
		 * 		(2) 인스턴스 초기화 블럭
		 * 			- 인스턴스 변수의 초기화
		 * 			- 클래스 내 블럭 { } 을 작성한 뒤 안에 내용을 기입한다.
		 * 			- 생성자와 같이, 인스턴스 생성 시마다 수행된다. (생성자보다 인스턴스 초기화 블럭이 먼저 수행된다.)
		 * 			- 인스턴스 변수의 초기화는 생성자에서, 인스턴스 초기화 블럭에는 모든 생성자에서 공통적으로 수행하는 로직을 넣는다.
		 */
		
		System.out.println("Ex5_1_Block b1 = new Ex5_1_Block();");
		Ex5_1_Block b1 = new Ex5_1_Block();

		System.out.println("Ex5_1_Block b2 = new Ex5_1_Block();");
		Ex5_1_Block b2 = new Ex5_1_Block();

	}
}

class Ex5_1_Block {
	static {
		System.out.println("static { } ");
	}
	
	{
		System.out.println(" { } ");
	}
	
	public Ex5_1_Block() {
		System.out.println("생성자");
	}
}