package ex2_work;

public class Ex2_Work {
	//
	private String point;
	private String tel;
	
	// ������
	// - ��ü�� ���� �����Ѵٰ��ص�, static ������ �޼ҵ忡���� static �޸� �� �� �ϳ��� �����ȴ�.
	static float interest = 10f;
	//
	public Ex2_Work(String point, String tel) {
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
