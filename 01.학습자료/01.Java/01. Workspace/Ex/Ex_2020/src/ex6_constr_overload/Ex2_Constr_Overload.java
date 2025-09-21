package ex6_constr_overload;

public class Ex2_Constr_Overload {
	//
	private String name;
	
	// - 아래와 같이 생성자를 새로 만들게되면 기본 생성자를 사용할 수 없으므로
	// - 따로 기본 생성자를 만들어줘야 한다.
	public Ex2_Constr_Overload(String name) {
		this.name = name;
	}

	// 기본 생성자를 생성
	public Ex2_Constr_Overload() {
		System.out.println("기본 생성자로는 꼬부기만 만듭니다.");
		name = "꼬부기";
	}
	
	public String getName() {
		return name;
	}
}