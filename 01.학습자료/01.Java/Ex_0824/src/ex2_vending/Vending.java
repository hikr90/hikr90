package ex2_vending;

/*ĵ�� ���Ǳ� �ȿ� �����Ƿ� Vending Ŭ���� �ȿ� ����� class�� �־���Ѵ�. (Can ��üȭ) */

public class Vending {

	// �ٵ� ĵ�� �������� �ִ� ���� �ƴϴ� �迭�� ������ �Ѵ�.
	// ���ǱⰡ ���������� �ܾ׵� �־���Ѵ�.
	private Can[] cans = new Can[5];
	private int money;

	// for���� ����� �� ������ �� �� �ϳ��� ���Դ� �Ǽ��� ���� ���� ���� �ִ�. 
	// �Ʒ��� �޼���δ� set�� get���� �� �۾��� �ټ��ٷ� �پ���.
	public Vending() {
			cans[0] = new Can("fanta",1000);
			cans[1] = new Can("cider",1100);
			cans[2] = new Can("coke",1200);
			cans[3] = new Can("banana",1300);
			cans[4] = new Can("hotsix",1400);
		
	}
	
	// ���Ǳ� �ȿ� ������� �����ϱ����� �޼���
	// �޼��尡 ������ for�� ����� �ȵǹǷ�, ���� ���Ǳ�� ������ �ͼ� ������� �־����� ������ ����� �� �����Ƿ�.
//	public void init() {
//		
//		for(int i=0;i<cans.length;i++) {
//			// Ŭ������ ��üȭ�� �ݵ�� �ʿ��� �۾�
//			cans[i] = new Can();
//		}
//		
//		// �Ʒ��� ���� �������� ��,
//		// ���� : vending������ cans�� set, get�� ���ؼ��� ��븸 �����ϴ�.
//		cans[0].setCanName("fanta");
//		cans[0].setPrice(1000);
//		
//		cans[1].setCanName("cider");
//		cans[1].setPrice(1100);
//		
//		cans[2].setCanName("coke");
//		cans[2].setPrice(1200);
//		
//		cans[3].setCanName("banana milk");
//		cans[3].setPrice(1300);
//		
//		cans[4].setCanName("hotsix");
//		cans[4].setPrice(1400);
//		
//	}
	
	
	// ����ڰ� ���� ������ �� �ش� �ݾ��� �������� ������� ��ϸ� ���
	public void showCans(int m) {
		
		money = m;
		
		for(int i=0;i<cans.length;i++) {
			
			if(cans[i].getPrice()<=m) {
				System.out.printf("%s - %d��\n",cans[i].getCanName(),cans[i].getPrice());
			}
		}
	}
	
	
	//����ڰ� ������ ���Ḧ �ľ��Ͽ� �����ϰ� �ܾ��� �����ִ� �޼���
	public void outCan(String s) {
		
		for(int i=0;i<cans.length;i++) {
			
			if(cans[i].getCanName().equalsIgnoreCase(s)) {
				System.out.println(cans[i].getCanName()+"�� �޾ҽ��ϴ�.");
				
				money -= cans[i].getPrice();
				System.out.println("�ܾ� : "+money);
			}
		}
	}
	
	
}
