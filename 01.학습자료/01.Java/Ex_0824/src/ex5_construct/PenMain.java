package ex5_construct;

public class PenMain {
	public static void main(String[] args) {
		
		// 메모리 호출과 동시에 초기화가 되어버림
		// 더이상 바꿀 수 없는 setter의 역할을 대신 수행한다. 
		Pen p1 = new Pen();
		
		// Pen에서 이미 생성자로 초기화를 시켰고, setter를 만들지 않고 getter만 만들었으니
		// 값을 확인하는 것은 가능해도, 변경 수정에서 접근할 수 없다. (보완성 좋음)
		// 단점은 나자신도 못바꾼다.
		System.out.println(p1.getCompany());
		System.out.println(p1.getColor());
		System.out.println(p1.getPrice());
		
		System.out.println("-------------");
		
		// 한정판을 생산하고싶다면?
		Pen p3 = new Pen("gold",20000);
		System.out.println(p3.getColor());
		
		
		
		
		
		
		
		
		
		
		
	}
}
