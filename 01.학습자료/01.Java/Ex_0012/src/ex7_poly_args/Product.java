package ex7_poly_args;

public class Product {
	//
	int price;
	int bounsPoint;
	//  ������
	public Product (int price){
		// ������ ���� ��, ���ݰ� ����Ʈ ���� ���� ����
		this.price = price;
		this.bounsPoint = (int)(price/10.0);
	}
	// �⺻ ������
	public Product() {
		//  �� �ʱ�ȭ
		price = 0;
		bounsPoint = 0;
	}
}
