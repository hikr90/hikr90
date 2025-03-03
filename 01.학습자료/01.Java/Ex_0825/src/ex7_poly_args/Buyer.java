package ex7_poly_args;

import java.util.Vector;

public class Buyer {
	// 손님 클래스
	int money = 1000;
	int bounsPoint = 0;
	Vector item = new Vector();
	
	// 동작 (구매)
	void buy(Product p) {
		// 금액 차감 불가 시
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		
		// 금액 차감
		money -= p.price;
		bounsPoint += p.bounsPoint;

		// 구입 제품 (참조변수) 백터에 추가
		item.add(p);
		System.out.println(p+" 구매 완료");
	}
	
	// 동작 (반품)
	void refund(Product p) {
		//
		if(item.remove(p)) {
			money += p.price;
			bounsPoint -= p.bounsPoint;
			System.out.println(p+" 반품 완료");
		} else {
			System.out.println("구입하신 제품 중 해당 제품이 없습니다.");
		}
	}
	
	// 동작 (요약)
	void summary() {
		//
		int sum = 0;
		String itemList = "";
		
		// Vetor가 비어있는지 확인
		if(item.isEmpty()) {
			System.out.println("구입하신 제품이 없습니다.");
			return;
		}
		
		// 목록 생성
		for(int i=0;i<item.size();i++) {
			//
			Product p = (Product)item.get(i);
			sum += p.price;
			itemList += (i==0) ? "" + p : ", " + p;
		}
		//
		System.out.println("구입하신 물품의 총 금액은  "+sum+"만원 입니다.");
		System.out.println("구입하신 제품은  "+itemList+"입니다.");
	}
}
