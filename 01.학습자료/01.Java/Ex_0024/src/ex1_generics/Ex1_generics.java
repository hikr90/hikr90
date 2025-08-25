package ex1_generics;

import java.util.ArrayList;

public class Ex1_generics {
	//
	public static void main(String[] args) {
		/*	Generics
		 * 		- 다양한 타입의 객체를 다루는 메소드나 컬렉션 클래스에 컴파일 시, 타입 체크를 하는 기능
		 * 		- 객체의 타입을 컴파일 시에 체크하므로 안정성을 높이고 형변환의 번거로움이 줄어든다.
		 * 		
		 * 			class Box<T> {
		 * 				T item;
		 * 	
		 * 				void setItem(T item) { this.item = item; }
		 * 				T getItem() { return item; }
		 * 			}
		 * 
		 * 			- T는 타입 변수로서, 임의의 참조형 타입을 뜻한다.
		 * 			- 제네릭 클래스를 객체 생성할 때는 Box<String> b = new Box<String>(); 처럼 참조변수와 생성자 타입에 사용될 실제 타입을 지정하여 사용한다.
		 * 			- Box<T> 는 제네릭 클래스, T는 타입 변수, Box는 원시 타입 (raw type) 이라고 부른다.
		 * 
		 * 			[참조] 제네릭스 사용 불가의 경우
		 * 				(1) 인스턴스 변수 참조
		 * 					- T는 인스턴스 변수로 간주되므로, 모든 객체에 대해 동일하게 동작해야하는 static 멤버에 타입 변수 T를 사용할 수 없다.
		 * 					- static 멤버는 인스턴스 변수를 참조할 수 없다. 
		 * 			
		 * 				(2) 상속 관계
		 * 					- 객체 생성 시 참조변수와 생성자에 대입된 타입이 서로 상속 관계에 있어도 에러가 발생한다.
		 * 					- 단, 두 제네릭 클래스의 타입이 상속 관계에 있고 대입되는 타입이 같은 경우는 괜찮다.
		 */
		
		// 객체 생성 & 사용
		Box<Fruit> fruitBox = new Box<Fruit>();
		Box<Apple> appleBox = new Box<Apple>();
		Box<Toy> toyBox = new Box<Toy>();
		
		//  [에러] 타입변수 타입 <> 생성자 타입
		// Box<Grape> grapeBox = new Box<Apple>();
		
		//  [정상] 객체 타입 == 생성자 타입
		appleBox.add(new Apple());
		
		// [에러] 객체 타입 <> 객체 추가 타입
		// appleBox.add(new Grape());
		
		// [참조] 단, 상속의 관계에서는 가능하다.
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		
		// [참조] 자손 클래스만 가능
		FruitBox<Fruit> appleBox2 = new FruitBox<Fruit>();
		appleBox2.add(new Apple());
		appleBox2.add(new Grape());
		
		// [에러] 상속 관계가 아니므로 제한
		// appleBox2.add(new Toy());
		
	}	
}

// 외부 클래스
class Fruit implements Eatable { public String toString() { return "Fruit";}}
class Apple extends Fruit { public String toString() { return "Apple";}}
class Grape extends Fruit { public String toString() { return "Grape";}}
class Toy { public String toString() { return "Toy";}}

class Box<T> {
	// 
	ArrayList<T> list = new ArrayList<>();	// 참조변수의 타입으로부터 T 타입의 변수만 받을 수 있으므로 생성자에 타입을 따로 표기하지 않아도 상관 x
	void add(T item) { list.add(item); }
	T get(int i) { return list.get(i); }
	int size() { return list.size(); }
	public String toString() { return list.toString(); }
	ArrayList<T> getList() { return list; }
}

// 인터페이스
// - extends와 & 문자로 표현
interface Eatable {}

// 제한된 제네릭 클래스
class FruitBox<T extends Fruit & Eatable> extends Box<T> {		// 타입변수는 Fruit의 자식이면서 Eatable을 구현해야 한다.
	// 타입 변수 extends 사용 시, 해당 타입의 자식만 지정 가능	
}

