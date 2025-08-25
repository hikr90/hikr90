package ex7_poly_args;

import java.util.Vector;

public class Buyer {
	// �մ� Ŭ����
	int money = 1000;
	int bounsPoint = 0;
	Vector item = new Vector();
	
	// ���� (����)
	void buy(Product p) {
		// �ݾ� ���� �Ұ� ��
		if(money < p.price) {
			System.out.println("�ܾ��� �����Ͽ� ������ �� �� �����ϴ�.");
			return;
		}
		
		// �ݾ� ����
		money -= p.price;
		bounsPoint += p.bounsPoint;

		// ���� ��ǰ (��������) ���Ϳ� �߰�
		item.add(p);
		System.out.println(p+" ���� �Ϸ�");
	}
	
	// ���� (��ǰ)
	void refund(Product p) {
		//
		if(item.remove(p)) {
			money += p.price;
			bounsPoint -= p.bounsPoint;
			System.out.println(p+" ��ǰ �Ϸ�");
		} else {
			System.out.println("�����Ͻ� ��ǰ �� �ش� ��ǰ�� �����ϴ�.");
		}
	}
	
	// ���� (���)
	void summary() {
		//
		int sum = 0;
		String itemList = "";
		
		// Vetor�� ����ִ��� Ȯ��
		if(item.isEmpty()) {
			System.out.println("�����Ͻ� ��ǰ�� �����ϴ�.");
			return;
		}
		
		// ��� ����
		for(int i=0;i<item.size();i++) {
			//
			Product p = (Product)item.get(i);
			sum += p.price;
			itemList += (i==0) ? "" + p : ", " + p;
		}
		//
		System.out.println("�����Ͻ� ��ǰ�� �� �ݾ���  "+sum+"���� �Դϴ�.");
		System.out.println("�����Ͻ� ��ǰ��  "+itemList+"�Դϴ�.");
	}
}
