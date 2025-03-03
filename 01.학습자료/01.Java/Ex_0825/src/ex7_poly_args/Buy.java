package ex7_poly_args;

public class Buy {
	public static void main(String[] args) {
		//
		Buyer b = new Buyer();
		Tv t = new Tv();
		Computer c = new Computer();
		Audio a = new Audio();
		// 구매
		b.buy(t);
		b.buy(c);
		b.buy(a);
		// 요약
		b.summary();
		System.out.println();
		// 반품
		b.refund(c);
		b.summary();
	}
}
