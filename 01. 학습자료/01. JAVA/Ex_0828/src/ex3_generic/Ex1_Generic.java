package ex3_generic;

/* 제네릭 클래스란 일반적인 클래스를 작성하고 이에대해 다양한 타입의 객체를 재사용(재활용)할 수 있게 해주는 기법을 뜻한다.
 * 
 * 사용방법
 * public class 클래스명<명칭>
 * 
 * 명칭은 대문자로 한다.
 * */


public class Ex1_Generic<T> {
	
	T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	
	
	
}
