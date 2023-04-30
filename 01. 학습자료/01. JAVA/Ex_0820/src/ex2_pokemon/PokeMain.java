package ex2_pokemon;

public class PokeMain {

	public static void main(String[] args) {
		
		// stack에 p1 데이터의 주소값을 두고, heap에 p1객체에 해당하는 정보(비어있음)를 불러온다.
		PokeUnit p1 = new PokeUnit();	
		// 비어있는 공간에 데이터를 직접 넣을 수 있다.
		// 포켓유닛이라는 클래스는 추상적인데, 포켓몬이라는 큰 범주안에서 속성값(변수)에따라서 
		//p1 클래스에서는 피카츄가 되고, p2라는 클래스에서는 라이츄가되고 p3라는 클래스에서는 꼬부기가 될 수 있다.
		
		//클래스의 다형성 (구글링해보자)
		//하나의 범주 안에서 클래스의 속성값에따라서 각각 완전히 다른 속성을 가지고있는 클래스(메서드)를 생성하는 것
		p1.name = "피카츄";
		p1.type = "전기";
		p1.cp = 1500;
		
		p1.myPokemon();

		PokeUnit p2 = new PokeUnit();	
		p2.name = "라이츄";
		p2.type = "전기";
		p2.cp = 2000;

		p2.myPokemon();
	
		PokeUnit p3 = new PokeUnit();	
		p3.name = "꼬부기";
		p3.type = "물";
		p3.cp = 500;

		p3.myPokemon();
	}
}
