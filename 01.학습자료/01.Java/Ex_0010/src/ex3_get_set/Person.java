package ex3_get_set;

public class Person {

	// ȸ���� ������ �̸� ���� ����
	private String name;
	private int age;
	
	/*	setter & getter 
	 * 	- ���������ڷ� ���ؼ�, ������ �� ���� ���� �������ų�, ������ �� �ְ��ϴ� �޼ҵ�
	 * 	- �ݵ�� �׷��� �ϴ� ���� �ƴ����� �Ϲ������� set, get�� ����Ѵ�.
	 *		- setter �޼ҵ忡���� ���� ����, getter �޼ҵ忡�� ���� �����´�.
	 *
	 *		- alt + shift + s > Generate Getter and Setter > Select All Ŭ�� �� Generate > getter, setter ����
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// [����] �޼ҵ� �ϳ��� �ΰ��� ���� ��ȯ�Ϸ��� ���
	// - �޼ҵ� ���� name�� �Ķ���� name�� �Ѵ� ���� ������ ����Ѵ�.
	// - �� setProperty �ȿ� �ִ� name�� �Ķ���� name�� ����.
	// - �� Ŭ������ ����Ǿ��ִ� private name���� �ֱ����ؼ��� �� Ŭ������ name ���̶�� ǥ���� �Ǿ���Ѵ�.
	// - �׷��� this��� Ű���带 ����Ѵ�.
	// - this�� ���� Ŭ������ �ǹ��Ѵ�.
	public void setProperty(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
