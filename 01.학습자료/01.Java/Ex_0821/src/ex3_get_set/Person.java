package ex3_get_set;

public class Person {

	// ȸ�� ������ �̸��� ���̸� ����
	// =���� ������ �ʿ䰡����. (������, ȫ�浿�� ���ø��� ������ � ����� ȫ�浿, ��浿���״�)
	private String name;
	private int age;
//	
//	// Setter
//	// private���� ���� �������� ���� �����ϵ�, ������ �ֵ����ϴ� ���
//	public void setName(String n) {
//		name = n;
//		
//	}
//
//	public void setAge(int a) {
//		age = a;
//	}
//	
//	
//	// Getter
//	// get�޼��带 ���ؼ��� private�� name�� ���Ͻ����� �� �ִ�. 
//	public String getName() {
//		return name;
//	}
//	
//	public int getAge() {
//		return age;
//	}
	
	
	
	// ����
	// �޼��� �ϳ��� �ΰ����� ���� �����ϴ� ���
	//(�߿�) ���⼭ name�� �Ѵ� ���� ���� ����� �ȴ�. 
	// �������� �켱�̶� setProperty�ȿ� �ִ� name -> name�� �ȴ�.
	// �׷��� private�� name�� �ֱ� ���ؼ� this�� ���δ�.
	// this�� ���� Ŭ���� �ڽ��� ���Ѵ�. (this�� personŬ������ ���Ѵ�.)
	public void setProperty(String name, int age) {
		this.name = name;
		this.age = age;
	}


	
	// get�� set�� ��Ī ���� CTRL+SPACE���ָ� ������ �ʹ� ���� ���� ���
	// ALT+SHIFT+S(SOURCE) + GENERATE GETTER AND SETTER���� �ϰ����ϴ� �͵��� üũ�� ��, GENERATE������ �ȴ�.
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
