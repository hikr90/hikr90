package ex2_vending;

public class Vending {
	
	// 자판기 클래스 
	// - 캔은 여러 종류가 존재하므로 배열을 생성한다.
	// - 자판기가 가지고 있을 잔액도 생성한다.
	private Can[] cans = new Can[5];
	private int money;

	// - 총 다섯가지의 음료수를 캔 클래스로 생성한다.
	public Vending() {
			cans[0] = new Can("fanta",1000);
			cans[1] = new Can("cider",1100);
			cans[2] = new Can("coke",1200);
			cans[3] = new Can("banana",1300);
			cans[4] = new Can("hotsix",1400);
		
	}
	
	// - 사용자가 투입한 돈 범위 내의 음료수 목록을 보여준다.
	public void showCans(int m) {
		//
		money = m;
		//
		for(int i=0;i<cans.length;i++) {
			if(cans[i].getPrice()<=m) {
				System.out.printf("%s - %d원\n",cans[i].getCanName(),cans[i].getPrice());
			}
		}
	}
	
	// - 사용자가 선택한 음료를 제공하고 잔액을 돌려주는 메서드
	public void outCan(String s) {
		//
		for(int i=0;i<cans.length;i++) {
			//
			if(cans[i].getCanName().equalsIgnoreCase(s)) {
				System.out.println(cans[i].getCanName()+"를 받았습니다.");
				//
				money -= cans[i].getPrice();
				System.out.println("잔액 : "+money);
			}
		}
	}
}
