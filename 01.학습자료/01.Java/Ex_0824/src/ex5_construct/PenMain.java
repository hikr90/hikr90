package ex5_construct;

public class PenMain {
	public static void main(String[] args) {
		
		// 생성자가 호출되면서 값이 초기화 된 상태
		Pen p1 = new Pen();
		
		// - 이미 setter의 역할이 수행되었으므로 값을 수정할 수는 없다.
		// - (보완성 좋으나 나 자신도 못바꾼다.)
		System.out.println(p1.getCompany());
		System.out.println(p1.getColor());
		System.out.println(p1.getPrice());
		
		System.out.println("-------------");
		
		// - 생성자를 파라미터를 받아서 수행하는 오버로딩 생성자를 만들었으니
		// - 새로운 객체를 파라미터와 함께 새롭게 호출
		Pen p3 = new Pen("gold",20000);
		System.out.println(p3.getColor());
	}
}
