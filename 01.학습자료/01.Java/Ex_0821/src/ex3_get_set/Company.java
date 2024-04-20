package ex3_get_set;

public class Company {

	public static void main(String[] args) {
		
		// Set을 사용한 호출
		// Person의 setName으로 간다. -> setName의 메서드에의해서 name에 "홍길동이 들어간다."
		// 기존처럼 p1.name처럼 쉽게 값이 들어갈 위험성도 없다.
//		Person p1 = new Person();
//		p1.setName("홍길동");
//		
//		// 이름이 변경되면 같은 방식으로 변경할 수 있다. 
//		p1.setName("홍길순");
//		
//		// setAge 매서드도 생성하여 나이를 저장
//		p1.setAge(22);
//		
//		// Setter로 호출한 경우, 출력하는 방법
//		// 출력하기위해서는 메서드가 반환형으로 되어있어야한다. 
//		// 반환하는 목적으로는 get을 사용한다.
//		// 값을 지정 : Setter
//		// 값을 반환 : Getter
//		System.out.println(p1.getName());
//		System.out.println(p1.getAge());
		

		// 나이와 이름을 쉽게 변경할 수 있어 잘못된 입력값이 들어갈 수 있다.
		// 그래서 Person에서 private를 걸게되면 Company에서 기존의 사람은 건드릴 수 없지만 새로운 사람이 들어올 수 없다.
		// 정보는 쉽게 접근할 수 없으면서 변경이 자유로운 방법이 setter이다. 
		
		
		// 예외
		// 타인한테서 setProperty가 있는 클래스를 받아 사용할 때, 파라미터로 뭘 넣어야할지 모른다.
		// 그래서 메서드에서 뜻이 있는 단어로 해줘야한다.
		Person p2 = new Person();
		p2.setProperty("독고길동", 40);
		
		// null과 0으로 나온다. 
		// 이때는 void쪽에서 this로 구분을 지어줘야한다.
		System.out.println(p2.getName());
		System.out.println(p2.getAge());
		

		
		
		
		
		
		
		
		
		
	}
}
