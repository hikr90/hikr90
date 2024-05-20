package ex2_pokemon;

public class PokeMain {

	public static void main(String[] args) {
		
		// 클래스 생성
		PokeUnit p1 = new PokeUnit();	
		
		// - 해당 클래스 내의 이름, 타입, cp의  값은 비어있으므로 
		// - 메인 클래스에서 각각 완전히 다른 속성을 가지고 있는 클래스를 생성하는 것이 가능하다.
		// - 아래의 예시에서 p1은 피카츄를, p2는 라이츄를, p3는 꼬부기가 될 수 있다.
		// - 이러한 속성을 클래스의 다형성이라고 부른다.
		p1.name = "피카츄";
		p1.type = "전기";
		p1.cp = 1500;
		//
		p1.myPokemon();
		//
		PokeUnit p2 = new PokeUnit();	
		p2.name = "라이츄";
		p2.type = "전기";
		p2.cp = 2000;
		//
		p2.myPokemon();
		//
		PokeUnit p3 = new PokeUnit();	
		p3.name = "꼬부기";
		p3.type = "물";
		p3.cp = 500;
		//
		p3.myPokemon();
	}
}
