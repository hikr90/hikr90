package ex8_work;

public class TestMain {
	public static void main(String[] args) {
		//
		Test t = new Test();
		Thread th = new Thread(t);
		th.start();
	}
}
