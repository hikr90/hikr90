package ex2_throws;

public class Throws2 {
	
	public void test() throws Exception{
			
		// throws
		// - 현재 메소드에서 발생하는 예외를 해당 객체를 사용하고 있는 타 클래스로 위임하는 키워드
		/*	sleep 메소드에 예외처리가 있어야하는 이유
		 *		- sleep은 파라미터의 시간만큼 대기한 뒤 동작하는 메소드이다.
		 *		- 시간을 대기하는 기능이다보니 발생할 수 있는 오류가 존재하므로 따로 예외처리가 필요하다. 
		 */
		Thread.sleep(1000);
		//
		System.out.println("Throws2메서드 호출");
	}
}
