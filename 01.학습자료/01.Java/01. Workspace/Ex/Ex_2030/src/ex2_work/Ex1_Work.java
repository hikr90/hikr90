package ex2_work;

public class Ex1_Work {
	
	public static void main(String[] args) {
		//
		Ex2_Work b1 = new Ex2_Work("������", "02-111-1111");
		Ex2_Work b2 = new Ex2_Work("������", "02-111-2222");
		Ex2_Work b3 = new Ex2_Work("ȫ����", "02-111-3333");
		//
		b1.getInfo();
		b2.getInfo();
		b3.getInfo();
		
		// static ������ static �޼ҵ�� Ŭ����.static����(�޼ҵ�) ������� ���� ȣ���ؼ� ����Ѵ�.
		Ex2_Work.interest = 0.1f;
		// �� Ȯ��
		b1.getInfo();
		b2.getInfo();
		b3.getInfo();
	}
}
