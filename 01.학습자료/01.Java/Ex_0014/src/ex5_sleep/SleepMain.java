package ex5_sleep;

public class SleepMain {
	public static void main(String[] args) throws InterruptedException{
		//
		SleepEx se = new SleepEx();
		se.start();

		// 메인의 "프로그램 종료"를 가장 맨 마지막에 작업시키고 싶다면 해당 동작
		Thread.sleep(11000);
		System.out.println("프로그램 종료");
	}
}
