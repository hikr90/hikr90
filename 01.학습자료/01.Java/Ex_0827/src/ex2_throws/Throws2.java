package ex2_throws;

public class Throws2 {
	
	// throws : 현재 메서드에서 발생할 수 있는 예외를 해당 객체를 사용하고 있는 타 클래스에서 처리하도록 위임하는 키워드
	// 메서드 뒤에 위치 
	public void test() throws Exception{
		
			// 1초 쉰 뒤 다음 코드 실행
			// thread는 시간을 대기하는 클래스인데 시간을 강제적으로 쉬다보니 오류가 일어날 수 있다.
			// 그래서 강제적으로 try-catch가 있어야한다.
			Thread.sleep(1000);

			System.out.println("Throws2메서드 호출");
	}
	
}
