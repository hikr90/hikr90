package ex6_construct;

public class Pokemon {
	
	private String name;
	
	// 오버로딩
	// 아래와 같이 내가 생성자를 새로 만들게되는 (오버로딩) 순간, 기본 생성자는 아예 사용할 수 없게 된다. 
	public Pokemon(String name) {
		this.name = name;
	}

	// 하지만 방법이 있다. 
	// 생성자의 3번째 특징
	// 기본 생성자는 코드를 눈에 보이게 정의해둬야 오버로딩 생성자와 함께 사용할 수 있다.
	public Pokemon() {
		System.out.println("기본 생성자로는 꼬부기만 만듭니다.");
		name = "꼬부기";
	}
	
	public String getName() {
		return name;
	}
}