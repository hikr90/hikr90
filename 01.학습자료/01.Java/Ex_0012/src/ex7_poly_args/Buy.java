package ex7_poly_args;

public class Buy {
	public static void main(String[] args) {
		//
		Buyer b = new Buyer();
		Tv t = new Tv();
		Computer c = new Computer();
		Audio a = new Audio();
		// ����
		b.buy(t);
		b.buy(c);
		b.buy(a);
		// ���
		b.summary();
		System.out.println();
		// ��ǰ
		b.refund(c);
		b.summary();
	}
}
