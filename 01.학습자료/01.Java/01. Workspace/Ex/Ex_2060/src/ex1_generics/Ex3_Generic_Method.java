package ex1_generics;

import java.util.ArrayList;

public class Ex3_Generic_Method {
	public static void main(String[] args) {
		/*	제네릭 메소드
		 * 		- 메소드의 선언부에 제네릭 타입이 선언된 메소드
		 * 		- 제네릭 클래스가 아닌 클래스에도 정의될 수 있다.
		 * 		- 아래의 제네릭 메소드의 타입 T는 서로 같은 타입이라는 의미가 아니라 임의의 라는 뜻이다.
		 * 
		 * 			static <T> void sort(List<T> list, Comparator<? super T> c) 	
		 * 		
		 * 			[참고] static 멤버에는 제네릭 타입을 걸 수 없지만, 메소드에 제네릭 타입을 선언하고 사용하는 것은 가능하다.
		 * 				- 메소드에 선언된 제네릭 타입은 지역 변수를 선언한 것과 같다.
		 * 				- 메소드 내에서만 사용될 것이므로 메소드가 static이건 상관이 없다.
		 * 			
		 * 			[참고] 대입 타입 생략
		 * 				- 대부분의 경우 컴파일러가 타입을 추정 가능하므로 타입 변수를 생략할 수 있으나
		 * 				- 대입된 타입을 생략할 수 없는 대입된 타입이 있을 때는 반드시 써야 한다. 
		 * 
		 * 					Juicer.makeJuice(fruitBox);
		 * 					Juicer.<Fruit>makeJuice(fruitBox);
		 */
	}
	
	// 제너릭 메소드
	public static <T extends Fruit> void Juice(FruitBox<T> box) {
		//
	}

}
