package ex3_get_set;

public class Company {

	public static void main(String[] args) {

		// 클래스 선언
		// - setName 메소드를 통해서 name의 값을 지정
		Person p1 = new Person();
		p1.setName("홍길동");
		
		// - 이름이 변경되면 같은 방식으로 변경할 수 있다.
		p1.setName("홍길순");
		
		// - setAge 매서드도 생성하여 나이를 저장
		p1.setAge(22);
		
		// getName으로 값을 조회
		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		
		// - p1.name 으로 값을 쉽게 변경할 수는 없지만
		// - setName 과 getName으로 값을 조회하거나 수정하는 식이 제어가 가능하다.
		
		// [참고] setProperty 메소드 사용 시, 파라미터로 어떤 값이 들어가는지 혼동이 있을 수 있다.
		// - 그래서 메소드 자체에 뜻이 있는 단어를 사용하거나
		// - 주석으로 설명 등의 정보를 넣어주는 것이 좋다.
		Person p2 = new Person();
		p2.setProperty("독고길동", 40);
		//
		System.out.println(p2.getName());
		System.out.println(p2.getAge());
	}
}
