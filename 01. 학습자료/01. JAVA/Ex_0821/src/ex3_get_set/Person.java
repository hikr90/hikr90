package ex3_get_set;

public class Person {

	// 회사 직원의 이름과 나이를 저장
	// =으로 선언할 필요가없다. (다형성, 홍길동만 들어올리가 없으니 어떤 사람은 홍길동, 김길동일테니)
	private String name;
	private int age;
//	
//	// Setter
//	// private에서 값을 꺼내오는 것은 가능하되, 보안은 있도록하는 방법
//	public void setName(String n) {
//		name = n;
//		
//	}
//
//	public void setAge(int a) {
//		age = a;
//	}
//	
//	
//	// Getter
//	// get메서드를 통해서는 private인 name을 리턴시켜줄 수 있다. 
//	public String getName() {
//		return name;
//	}
//	
//	public int getAge() {
//		return age;
//	}
	
	
	
	// 예외
	// 메서드 하나로 두가지의 값을 세팅하는 경우
	//(중요) 여기서 name은 둘다 지역 변수 취급이 된다. 
	// 지역변수 우선이라 setProperty안에 있는 name -> name이 된다.
	// 그래서 private의 name에 넣기 위해서 this를 붙인다.
	// this는 현재 클래스 자신을 뜻한다. (this는 person클래스에 속한다.)
	public void setProperty(String name, int age) {
		this.name = name;
		this.age = age;
	}


	
	// get과 set은 명칭 적고 CTRL+SPACE해주면 되지만 너무 많은 양일 경우
	// ALT+SHIFT+S(SOURCE) + GENERATE GETTER AND SETTER으로 하고자하는 것들을 체크한 뒤, GENERATE누르면 된다.
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
