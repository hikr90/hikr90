package ex2_generic_class;

public class Ex1_Generic<T> {
	// 제네릭 클래스 사용 방법
	// - public class 클래스명 <타입>
	T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
