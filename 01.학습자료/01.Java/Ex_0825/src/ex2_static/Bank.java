package ex2_static;

public class Bank {
	//
	private String point;
	private String tel;
	
	// ������
	// - ��ü�� ���� �����Ѵٰ��ص�, static ������ �޼ҵ忡���� static �޸� �� �� �ϳ��� �����ȴ�.
	static float interest = 10f;
	//
	public Bank(String point, String tel) {
		this.point = point;
		this.tel = tel;
	}
	// ���
	public void getInfo() {
		System.out.println("���� ��ġ : "+point);
		System.out.println("��ȭ��ȣ : "+tel);
		System.out.println("������ : "+interest+"%");
		System.out.println("--------------------");
	}
}
