package ex3_method;

public class ValueTest {
	
	// �޼��� ����
	public void greet() {
		System.out.println("�ȳ��ϼ���.");
		System.out.println("�ݰ����ϴ�.");

		
	} //greet()
	
	
	
	
	// �Ķ���͸� �޴� �ٸ� �޼��� ����
	// �޼��� ���� ()�ȿ� �ִ� ���� �־�����Ѵ�.
	public void test1(int n) {
		
		n+=100;
		System.out.println("n : "+n);
	}
	
	// ��ȯ���� �޼���
	// ���纻�� ���� ��������� ���
	// void�� �ƴ� ���, return�̶�� Ű���带 �־���Ѵ�.
	// int�� ��ȯ�ϴ� ���� Ÿ���� ���Ѵ�.
	// ��ȯ�ϴ� Ÿ�԰� return�� Ÿ���� �ݵ�� ��ġ�ؾ��Ѵ�.
	public int test0(int n) {
		n+=100;
		System.out.println("n : "+n);
		
		return n;
	}
	
	// String���� ���� �ż���
	// ���� �� �ؿ��� break�� continue���� � �ڵ嵵 ���� �� ����.
	// void�� ���� ������ ����� ���� �ִ�. (������ �����ؼ� ���� ������ �ʴ´�.)
	// return�� �ϳ��� ����� �� ������ if�������� ���� ���ο����� �ϳ��� ��츸 �Ǹ� �Ǳ⿡ �ڵ�� �ΰ� �̻��� �� �ִ�.
	public String test2(int age) {
		
		if(age>=20) {
			return "�հ�";
		}
		return "���հ�";
		
	}
	
	
	// boolean���� ��ȯ�ϴ� �޼���
	// �Ķ������ ������ ����. (���ƺ��� 7������)
	public boolean test3(String gender, int age){
		
		if(gender.equals("��")&&age>=19) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
}
