package ex1_quiz;

public class QuizMain {
	public static void main(String[] args) {
		//
		Quiz quiz = new Quiz();
		
		// 백그라운드에서 스레드가 동작하기때문에 무조건 먼저 start(스레드)가 실행되어야한다.
		quiz.start();
		quiz.startGame();
	}
}
