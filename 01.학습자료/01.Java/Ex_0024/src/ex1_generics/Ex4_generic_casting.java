package ex1_generics;

public class Ex4_generic_casting {
	public static void main(String[] args) {
		/* 제네릭의 형변환
		 * 		- 제네릭 <> 원시 (non-generic) 타입 간의 형변환은 가능하다.
		 * 		- 제네릭 간 다른 타입 변환 시, 와일드 카드를 사용하여 변환 가능하다.
		 */
		
		// 제네릭 <> 원시 타입 형변환
		Box<Object> objBox = null;
		Box box = null;
		//
		box = (Box)objBox;
		objBox = (Box<Object>)box;
		
		// [참고] 서로 다른 제네릭 타입간의 형변환은 안된다.
		// - Box<String> strBox = null;
		// - strBox = (Box<String>objBox);		// 에러
		
		// [참고] 와일드 카드 사용
		// - String은 Object의 자식이므로 형변환이 가능하다.
		//	- 다형성의 예시
		Box<? extends Object> wBox = new Box<String>();
		
		// [참고] Optional<?> empty = new Optional<>();
		// - ? 은 ? extends Object 를 뜻하며 <> 안에 생략된 타입은 Object이다.
		// - <?> 로 선언 시 에러
		// - Optional<Object> -> Optional<?> -> Optional<T> 로 변환 가능 (와일드 카드 사용)
	}
}
