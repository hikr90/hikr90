package ex7_work;

public class Ex3_Work {
	public static void main(String[] args) {
		//
		Ex1_Work t = new Ex1_Work();
		Thread th = new Thread(t);
		th.start();
	}
}
