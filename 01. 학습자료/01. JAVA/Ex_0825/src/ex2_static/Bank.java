package ex2_static;

public class Bank {
	
	// ���� ��ġ
	private String point;
	// ���� ��ȭ��ȣ
	private String tel;
	
	// ������
	// ��ü�� �ƹ��� ���� �����Ѵٰ� �ص� static������ static�޼���� �޸𸮻� �� �ϳ��� �����ȴ�.
	static float interest = 10f;
	
	public Bank(String point, String tel) {
		this.point = point;
		this.tel = tel;
	}
	
	// ��� ����� ���� �޼���
	public void getInfo() {
		System.out.println("���� ��ġ : "+point);
		System.out.println("��ȭ��ȣ : "+tel);
		System.out.println("������ : "+interest+"%");
		System.out.println("--------------------");
	}
	
	
	
}
