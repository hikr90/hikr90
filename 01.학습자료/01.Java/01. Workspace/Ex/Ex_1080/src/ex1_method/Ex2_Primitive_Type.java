package ex1_method;

class Data { int x; }

public class Ex2_Primitive_Type {
	public static void main(String[] args) {
		// [참고] 기본형과 참조형 매개변수의 차이
		Data d1 = new Data();
		d1.x = 10;
		change(d1.x);	// 기본형 매개변수 (복제된 값)이므로 수정되지 않는다.
		
		Data d2 = new Data();
		d2.x = 10;
		
		change(d2);		// 참조형 매개변수 (원본)이므로 수정된다.
	}
	
	//
	static void change(int x) {
		x = 1000;
		System.out.println("change(int x) : x = " + x);
	}
	//
	static void change(Data d) {
		d.x = 1000;
		System.out.println("change(Data d) : x = " + d.x);
	}
}


