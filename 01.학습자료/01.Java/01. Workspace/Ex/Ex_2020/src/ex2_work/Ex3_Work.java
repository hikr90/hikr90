package ex2_work;

public class Ex3_Work {
	
	// ���Ǳ� Ŭ���� 
	// - ĵ�� ���� ������ �����ϹǷ� �迭�� �����Ѵ�.
	// - ���ǱⰡ ������ ���� �ܾ׵� �����Ѵ�.
	private Ex2_Work[] cans = new Ex2_Work[5];
	private int money;

	// - �� �ټ������� ������� ĵ Ŭ������ �����Ѵ�.
	public Ex3_Work() {
			cans[0] = new Ex2_Work("fanta",1000);
			cans[1] = new Ex2_Work("cider",1100);
			cans[2] = new Ex2_Work("coke",1200);
			cans[3] = new Ex2_Work("banana",1300);
			cans[4] = new Ex2_Work("hotsix",1400);
		
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
