package ex1_generics;

public class Ex2_wild_card {
	public static void main(String[] args) {
		/*	와일드 카드
		 * 	- 어떠한 타입도 가능하다는 뜻의 문자
		 * 	- Object와 동일하지만 extends, super 로 상한과 하한을 조절할 수 있다.
		 * 	- 와일드 카드는 & 기능을 사용할 수 없다.
		 * 	
		 * 		(1) <? extends T>
		 * 			- 와일드 카드의 상한 제한
		 * 			- T와 그 자손들만 가능
		 * 
		 * 		(2) <? super T>
		 * 			- 와일드 카드의 하한 제한
		 * 			- T와 그 조상들만 가능
		 * 
		 * 		(3) <?>
		 * 			- 제한 없음
		 * 
		 *			[참고] 제네릭 메소드의 Comparator 도 마찬가지로 사용 가능하다.
		 */
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());

		appleBox.add(new Apple());

	}
}

class Juice {
	String name;
	Juice(String name) { this.name = name + "Juice"; }
	public String toString() { return name; }
}

class Juicer {
	static Juice makeJuice(FruitBox<? extends Fruit> box) {
		String tmp = "";
		
		for(Fruit f : box.getList())
			tmp += f + " ";
		return new Juice(tmp);
	}
}
