package ex6_overload;

public class Ex_Overload {
	
	/* Overloading
	 * 	- �޼ҵ��� �ߺ� ����
	 * 	- �⺻������ �޼ҵ�� �ߺ��� �̸��� ����� �� ����.
	 * 	- �����ε��� ���� �̸��� �޼ҵ带 ���� �� ����� �� �ְ� �Ѵ�.
	 * 	- �ϳ��� Ŭ�������� ���� �̸��� ���� �޼ҵ尡 ������ ���ǵǵ��� �Ѵ�.
	 * 
	 * 	- �޼ҵ��� �̸��� ��ҹ��ڸ� �����Ͽ� �ݵ�� ���ƾ��Ѵ�.
	 * 	- �޼ҵ��� �̸��� ���⿡ ������ ���� �޶���Ѵ�.
	 * 	- ������ ������ ���� ��� Ÿ���� �޶���Ѵ�.
	 * 	- ������ ������ 2�� �̻��� ��� ������ �޶���Ѵ�.
	 */
	public void result() {
		System.out.println("���ڰ� ���� �޼���");
	}
	
	public void result(int n) {
		System.out.println("������ ���ڷ� �޴� �޼���");
	}
	
	public void result(char c) {
		System.out.println("���ڸ� ���ڷ� �޴� �޼���");
	}
	
	public void result(String s, int n) {
		System.out.println("���ڿ�, ���� ������ �޴� �޼���");
	}
	
	public void result(int i, String s) {
		System.out.println("����, ���ڿ� ������ �޴� �޼���");
	}
}
