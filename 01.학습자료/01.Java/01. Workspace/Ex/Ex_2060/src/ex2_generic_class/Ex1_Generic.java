package ex2_generic_class;

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
