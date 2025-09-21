package ex5_init_variable;

public class Ex1_Init_Variable {
	public static void main(String[] args) {	
		/*	변수의 초기화
		 * 	- 변수 선언 후, 처음으로 값을 저장하는 것.
		 * 	- 선언과 동시에 적절한 값으로 지정하는 것이 좋다.
		 * 	- 멤버 변수는 초기화 없이 자동적으로 변수에 자료형에 맞는 기본 값으로 초기화되지만, 지역변수는 그렇지 않으므로 사용 전에 반드시 초기화해야 한다.
		 * 	
		 * 		초기화 방법
		 * 			(1) 명시적 초기화
		 * 			(2) 생성자 선언
		 * 			(3) 초기화 블럭
		 */
		
		// 생성자가 호출되면서 값이 초기화 된 상태
		Ex1_2_Init_Variable p1 = new Ex1_2_Init_Variable();
		
		// - 이미 setter의 역할이 수행되었으므로 값을 수정할 수는 없다.
		// - (보완성 좋으나 나 자신도 못바꾼다.)
		System.out.println(p1.getCompany());
		System.out.println(p1.getColor());
		System.out.println(p1.getPrice());
		
		System.out.println("-------------");
		
		// - 생성자를 파라미터를 받아서 수행하는 오버로딩 생성자를 만들었으니
		// - 새로운 객체를 파라미터와 함께 새롭게 호출
		Ex1_2_Init_Variable p3 = new Ex1_2_Init_Variable("gold",20000);
		System.out.println(p3.getColor());
	}
}

class Ex1_2_Init_Variable {
	//
	private String company;
	private String color;
	private int price;
	
	// 의도적으로 생성자 작성
	public Ex1_2_Init_Variable() {
		company = "monami";
		color = "black";
		price = 500;
	}

	// 오버로딩을 통해서 동일한 생성자를 한가지 더 생성한다.
	// setter의 역할을 생성자가 파라미터를 받아주면서 대신한다.
	// 생성자를 따로 생성하는 순간, 기본 생성자는 아예 사용할 수 없게 된다.
	// 오버로딩 생성자를 따로 생성하면 기본 생성자도 반드시 따로 기입해줘야 한다.
	public Ex1_2_Init_Variable(String color, int price) {
		this.color = color;
		this.price = price;
	}

	// getter만 생성
	public String getCompany() {
		return company;
	}

	public String getColor() {
		return color;
	}

	public int getPrice() {
		return price;
	}
}

