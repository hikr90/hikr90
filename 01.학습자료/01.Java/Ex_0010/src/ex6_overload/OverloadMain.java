package ex6_overload;

public class OverloadMain {

	public static void main(String[] args) {
		/* 오버로딩
		 * 	- 한 클래스 내, 같은 이름의 메소드를 여러개 정의하는 것.
		 * 	- 메소드 이름이 같고, 매개변수의 개수 또는 타입에 차이가 있어야 한다.
		 * 	- 오버로딩은 메소드명과 파라미터의 차이에 의해서만 구현이되며 반환 타입은 어떤 영향도 없다.
		 * 	- 대표적으로 println 메소드가 있다.
		 * 	- 같은 기능의 여러 메소드가 하나의 명칭으로 정의되어 오류의 발생을 줄이고 메소드 명칭의 절약이 되어 고민을 줄이는데 도움이 된다.
		 */
		
		// 메소드 선언
		Ex_Overload ov = new Ex_Overload();
		
		// - 같은 메소드 수행 시, 파라미터의 여부, 파라미터의 순서 등에따라서 다른 메소드가 사용된다.
		ov.result();
		ov.result(20);
		ov.result('A');
		ov.result("dd",10);
		ov.result(10,"dd");
		
		// - System.out.println 역시 오버로딩의 대표적인 메소드이다.
		// - 여러 타입의 파라미터를 받을 수 있으며 변수가 있지 않은 경우도 받을 수 있다.
		System.out.println();
	}
}
