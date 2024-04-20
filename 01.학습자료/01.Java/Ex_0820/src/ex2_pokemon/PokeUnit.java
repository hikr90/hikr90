package ex2_pokemon;

public class PokeUnit {
	
	// 클래스의 변수만을 선언해보자
	// heap에 데이터가 없는 p2, p3 영역만 생성된다.
	String name;
	String type;
	int cp;
	
	// 매서드 private으로 만들면 호출 못한다.
	public void myPokemon() {
		System.out.println("이름 : "+name);
		System.out.println("타입 : "+type);
		System.out.println("CP : "+cp);
		System.out.println("---------------");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
