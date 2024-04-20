package ex2_vending;

/*캔은 자판기 안에 있으므로 Vending 클래스 안에 음료수 class가 있어야한다. (Can 객체화) */

public class Vending {

	// 근데 캔이 한종류만 있는 것은 아니니 배열로 생성을 한다.
	// 자판기가 가지고있을 잔액도 있어야한다.
	private Can[] cans = new Can[5];
	private int money;

	// for문은 사용할 수 없지만 둘 중 하나를 빼먹는 실수는 하지 않을 수도 있다. 
	// 아래의 메서드로는 set과 get으로 긴 작업이 다섯줄로 줄었다.
	public Vending() {
			cans[0] = new Can("fanta",1000);
			cans[1] = new Can("cider",1100);
			cans[2] = new Can("coke",1200);
			cans[3] = new Can("banana",1300);
			cans[4] = new Can("hotsix",1400);
		
	}
	
	// 자판기 안에 음료수를 세팅하기위한 메서드
	// 메서드가 없으면 for문 사용이 안되므로, 또한 자판기는 직원이 와서 음료수를 넣어주지 않으면 사용할 수 없으므로.
//	public void init() {
//		
//		for(int i=0;i<cans.length;i++) {
//			// 클래스의 객체화시 반드시 필요한 작업
//			cans[i] = new Can();
//		}
//		
//		// 아래와 같이 생성했을 때,
//		// 장점 : vending에서도 cans를 set, get을 통해서만 사용만 가능하다.
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
	
	
	// 사용자가 돈을 투입할 시 해당 금액의 범위안의 음료수의 목록만 출력
	public void showCans(int m) {
		
		money = m;
		
		for(int i=0;i<cans.length;i++) {
			
			if(cans[i].getPrice()<=m) {
				System.out.printf("%s - %d원\n",cans[i].getCanName(),cans[i].getPrice());
			}
		}
	}
	
	
	//사용자가 선택한 음료를 파악하여 제공하고 잔액을 돌려주는 메서드
	public void outCan(String s) {
		
		for(int i=0;i<cans.length;i++) {
			
			if(cans[i].getCanName().equalsIgnoreCase(s)) {
				System.out.println(cans[i].getCanName()+"를 받았습니다.");
				
				money -= cans[i].getPrice();
				System.out.println("잔액 : "+money);
			}
		}
	}
	
	
}
