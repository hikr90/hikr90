package ex3_overload;

public class Bread {

	/*���� Overriding�� ���ؼ� ���� ������ ���� ����� �޼��带 ���弼��.*/
	public void makeBread() {
		System.out.println("���� ��������ϴ�.");
	}

	public void makeBread(int n) {
		for(int i=0;i<n;i++) {
			System.out.println("���� ��������ϴ�.");
		}
		System.out.printf("��û�Ͻ� %d���� ���� ��������ϴ�.\n",n);
	}

	
	
	public void makeBread(int n,String name) {
		for(int i=0;i<n;i++) {
			System.out.println(name+"��(��) ��������ϴ�.");
		}
		System.out.printf("��û�Ͻ� %d���� %s�� ��������ϴ�.\n",n,name);
	}





}
