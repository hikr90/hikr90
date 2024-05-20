package ex6_overload;

public class OverloadMain {

	public static void main(String[] args) {
		// 메소드 선언
		Ex_Overload ov = new Ex_Overload();
		
		// - 같은 메소드를 호출하더라도
		// - 파라미터의 여부, 파라미터의 순서 등에따라서 다른 메소드가 노출된다.
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
