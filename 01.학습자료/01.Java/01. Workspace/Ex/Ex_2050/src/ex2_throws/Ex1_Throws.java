package ex2_throws;

public class Ex1_Throws {
	public void test() throws Exception{
		/*	Throws
		 * 		- 현재 메소드에서 발생하는 예외사항을 현 클래스와 관련있는 타 클래스로 위임하는 키워드
		 * 		- sleep의 경우 중도 발생하는 예외에 대해서 처리하기위해 throws가 강제된다.
		 */
		Thread.sleep(1000);
		//
		System.out.println("Throws2메서드 호출");
	}
}
