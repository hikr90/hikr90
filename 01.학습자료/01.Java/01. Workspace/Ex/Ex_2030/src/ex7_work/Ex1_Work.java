package ex7_work;

public class Ex1_Work {
	//
	int price;
	int bounsPoint;
	//  ������
	public Ex1_Work (int price){
		// ������ ���� ��, ���ݰ� ����Ʈ ���� ���� ����
		this.price = price;
		this.bounsPoint = (int)(price/10.0);
	}
	// �⺻ ������
	public Ex1_Work() {
		//  �� �ʱ�ȭ
		price = 0;
		bounsPoint = 0;
	}
}
