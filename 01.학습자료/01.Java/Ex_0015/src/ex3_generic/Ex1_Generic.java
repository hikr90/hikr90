package ex3_generic;

public class Ex1_Generic<T> {
	// ���׸� Ŭ���� ��� ���
	// - public class Ŭ������ <Ÿ��>
	T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
