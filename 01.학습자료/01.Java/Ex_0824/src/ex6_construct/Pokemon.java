package ex6_construct;

public class Pokemon {
	//
	private String name;
	
	// - 아래와 같이 생성자를 새로 만들게되면 기본 생성자를 사용할 수 없으므로
	// - 따로 기본 생성자를 만들어줘야 한다.
	public Pokemon(String name) {
		this.name = name;
	}

	// 기본 생성자를 생성
	public Pokemon() {
		System.out.println("기본 생성자로는 꼬부기만 만듭니다.");
		name = "꼬부기";
	}
	
	public String getName() {
		return name;
	}
}