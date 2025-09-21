package ex1_set_get;

public class Ex2_Set_Get {
	public static void main(String[] args) {
		// 	- setName 메소드를 통해서 name의 값을 지정
		Ex1_Set_Get p1 = new Ex1_Set_Get();
		p1.setName("홍길동");
		
		// 	- 이름이 변경되면 같은 방식으로 변경할 수 있다.
		p1.setName("홍길순");
		
		// 	- setAge 매서드도 생성하여 나이를 저장
		p1.setAge(22);
		
		// getName으로 값을 조회
		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		
		// 	- p1.name 으로 값을 쉽게 변경할 수는 없지만
		// 	- setName 과 getName으로 값을 조회하거나 수정하는 식이 제어가 가능하다.
		
		// [참고] 메소드는 명칭 자체에 뜻이 있는 명칭을 사용하거나 주석으로 설명을 추가하는 것을 권장한다.
		Ex1_Set_Get p2 = new Ex1_Set_Get();
		p2.setProperty("독고길동", 40);
		//
		System.out.println(p2.getName());
		System.out.println(p2.getAge());
	}
}
