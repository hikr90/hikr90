package ex2_vending;

public class Vending {
	
	// ���Ǳ� Ŭ���� 
	// - ĵ�� ���� ������ �����ϹǷ� �迭�� �����Ѵ�.
	// - ���ǱⰡ ������ ���� �ܾ׵� �����Ѵ�.
	private Can[] cans = new Can[5];
	private int money;

	// - �� �ټ������� ������� ĵ Ŭ������ �����Ѵ�.
	public Vending() {
			cans[0] = new Can("fanta",1000);
			cans[1] = new Can("cider",1100);
			cans[2] = new Can("coke",1200);
			cans[3] = new Can("banana",1300);
			cans[4] = new Can("hotsix",1400);
		
	}
	
	// - ����ڰ� ������ �� ���� ���� ����� ����� �����ش�.
	public void showCans(int m) {
		//
		money = m;
		//
		for(int i=0;i<cans.length;i++) {
			if(cans[i].getPrice()<=m) {
				System.out.printf("%s - %d��\n",cans[i].getCanName(),cans[i].getPrice());
			}
		}
	}
	
	// - ����ڰ� ������ ���Ḧ �����ϰ� �ܾ��� �����ִ� �޼���
	public void outCan(String s) {
		//
		for(int i=0;i<cans.length;i++) {
			//
			if(cans[i].getCanName().equalsIgnoreCase(s)) {
				System.out.println(cans[i].getCanName()+"�� �޾ҽ��ϴ�.");
				//
				money -= cans[i].getPrice();
				System.out.println("�ܾ� : "+money);
			}
		}
	}
}
