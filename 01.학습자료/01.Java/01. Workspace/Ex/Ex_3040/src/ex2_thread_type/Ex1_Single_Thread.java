package ex2_thread_type;

public class Ex1_Single_Thread {
	public static void main(String[] args) {
		/*	싱글 쓰레드 & 멀티 쓰레드
		 * 	- 프로그램 환경에서 항상 멀티 쓰레드가 성능, 속도 측면에서 뛰어난 것은 아니다.
		 * 	- 두개의 작업을 하나로 번갈아가며 처리하는 방식 (싱글)과 두개의 쓰레드로 처리 (멀티) 하는 경우에서 두 작업의 속도는 거의 비슷하다.
		 * 	- 오히려 쓰레드 간의 작업 전환으로 인해서 멀티 쓰레드가 시간이 더 소요된다.
		 * 			
		 * 		[참고] 컨텍스트 스위칭
		 * 			- 쓰레드 간의 작업 전환
		 * 			- 다음에 동작할 위치 (PC, 프로그램 카운터 등) 등의 정보가 저장
		 * 
		 * 		[참고] 어떤 상황에서 멀티 쓰레드가 더 효율적인가?
		 * 			- 쓰레드가 서로 다른 자원을 바라보는 경우
		 * 			- (파일 전송 시, 다른 작업을 기다리지 않도록...)
		 */
		
		// 싱글 쓰레드
		Long stm = System.currentTimeMillis();
		
		for(int i=0;i<300;i++) {
			System.out.printf("%s : ", new String("-"));
		}
		System.out.println();
		System.out.println("소요 시간1 : " + (System.currentTimeMillis() - stm));
		
		for(int i=0;i<300;i++) {
			System.out.printf("%s : ", new String("|"));
		}
		System.out.println();
		System.out.println("소요 시간2 : " + (System.currentTimeMillis() - stm));
	}
}