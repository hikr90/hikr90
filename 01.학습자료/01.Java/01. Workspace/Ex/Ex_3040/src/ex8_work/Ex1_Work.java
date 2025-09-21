package ex8_work;

public class Ex1_Work {
	public static void main(String[] args) {
		//
		Ex2_Work quiz = new Ex2_Work();
		
		// 백그라운드에서 스레드가 동작하기때문에 무조건 먼저 start(스레드)가 실행되어야한다.
		quiz.start();
		quiz.startGame();
	}
}
