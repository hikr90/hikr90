package ex7_work;

public class Ex4_Work {
	public static void main(String[] args) {
		//
		Ex2_Work b = new Ex2_Work();
		Ex5_Work t = new Ex5_Work();
		Ex3_Work c = new Ex3_Work();
		Ex6_Work a = new Ex6_Work();
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
