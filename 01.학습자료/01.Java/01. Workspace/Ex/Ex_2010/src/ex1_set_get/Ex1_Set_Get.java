package ex1_set_get;

public class Ex1_Set_Get {
	/*	setter & getter 
	 * 		- ���������ڷ� ���ؼ�, ������ �� ���� ���� �������ų�, ������ �� �ְ��ϴ� �޼ҵ�
	 * 		- �ݵ�� �׷��� �ϴ� ���� �ƴ����� �Ϲ������� set, get�� ����Ѵ�.
	 *			(setter �޼ҵ忡���� ���� ����, getter �޼ҵ忡�� ���� �����´�.)
	 *
	 *		[����] alt + shift + s > Generate Getter and Setter > Select All Ŭ�� �� Generate > getter, setter ����
	 */
	private String name;
	private int age;

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

	/* [����] this.name�� ����ϴ� ����
	 * 		- �޼ҵ� �� name, �Ķ���� name�� �Ѵ� ���������� ��޵ȴ�.
	 *			(�޼ҵ� �� �� �Ķ���ʹ� �����ϴ�.)
	 *
	 *		- this�� �� Ŭ������ ���Ѵ�.
	 *		- this.name�� �� Ŭ������ name���̶�� ǥ���� �ȴ�.
	 *			(�� ������ ��Ī�� ȥ������ �ʱ����ؼ� ���)
	 */
	public void setProperty(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
