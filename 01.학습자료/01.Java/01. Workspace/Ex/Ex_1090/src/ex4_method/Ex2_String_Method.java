package ex4_method;

public class Ex2_String_Method {
	
	// �޼ҵ� ����
	public void greet() {
		System.out.println("�ȳ��ϼ���.");
		System.out.println("�ݰ����ϴ�.");
	}
	
	// �޼ҵ� ����
	// - void ���¿����� return �� ����� ������ �ϴ�. (�⺻�����δ� �����ȴ�.)
	public void test1(int n) {
		n+=100;
		System.out.println("n : "+n);
	}
	
	// ��ȯŸ���� int ���� �޼ҵ� ����
	// void �� �޸� ���� �����ϴ� ���� �ƴ϶� �ƿ� ���� ��ȯ�Ѵ�.
	public int test0(int n) {
		n+=100;
		System.out.println("n : "+n);
		return n;
	}
	
	
	// ��ȯŸ���� String�� �޼ҵ� ����
	public String test2(int age) {
		if(age>=20) {
			return "�հ�";
		}
		return "���հ�";
	}
	
	
	// ��ȯŸ���� boolean �� �޼ҵ� ����
	public boolean test3(String gender, int age){
		if(gender.equals("��")&&age>=19) {
			return true;
		}else {
			return false;
		}
	}
}
