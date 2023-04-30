package ex6_construct;

public class PokeMain {
	public static void main(String[] args) {
		
		// 피카츄 -> String name -> this.name -> String name;
		Pokemon p1 = new Pokemon("피카츄");
		Pokemon p2 = new Pokemon("라이츄");
		
		// 기본 생성자 호출이 불가능해진다.
		// 오버라이딩 후 기본 생성자를 눈에 보이게 재정의 해주면 기본 생성자를 사용할 수 있다.
		Pokemon p3 = new Pokemon();
		
		
	}
}
