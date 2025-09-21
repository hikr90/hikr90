package ex6_constr_overload;

public class Ex1_Constr_Overload {
	public static void main(String[] args) {
		// 오버로딩 생성자로 클래스 생성
		Ex2_Constr_Overload p1 = new Ex2_Constr_Overload("피카츄");
		Ex2_Constr_Overload p2 = new Ex2_Constr_Overload("라이츄");

		System.out.println("오버로딩 생성자 : "+p1.getName());
		System.out.println("오버로딩 생성자 : "+p2.getName());
		
		// 기본 생성자 호출이 불가능해진다.
		// 오버라이딩 후 기본 생성자를 눈에 보이게 재정의 해주면 기본 생성자를 사용할 수 있다.
		Ex2_Constr_Overload p3 = new Ex2_Constr_Overload();
		System.out.println("기본 생성자 : "+p3.getName());
	}
}
