package ex2_thread_type;

public class Ex4_Thread_Group {
	public static void main(String[] args) throws Exception {
		/*	쓰레드 그룹
		 * 		- 서로 관련된 쓰레드를 그룹으로 관리
		 * 		- 쓰레드 그룹에 다른 쓰레드를 그룹으로 묶어서 관리 가능하다.
		 * 		- 보안 상의 이유로 도입되었으며, 하위 그룹은 변경 가능하나 다른 쓰레드 그룹의 변경은 불가능하다.
		 * 		- 모든 쓰레드는 그룹에 포함되어있어야하며, 생성자를 통해서 그룹을 지정하지 않은 쓰레드는 기본적으로 자신을 생성한 쓰레드와 같은 그룹에 속한다.
		 * 		
		 * 		쓰레드의 생성 순서
		 * 			(1) 자바 어플리케이션 동작
		 * 			(2) JVM에서 main, system 이라는 쓰레드 그룹 생성
		 * 			(3) 그룹을 따로 지정하는 모든 쓰레드는 main 쓰레드 그룹의 하위 그룹이 되며
		 * 			(4) 따로 쓰레드 그룹을 지정하지 않은 쓰레드는 main 쓰레드 그룹에 포함된다.
		 * 
		 * 		쓰레드 그룹 관련 메소드
		 * 			(1) getThreadGroup : 쓰레드 자신이 속한 그룹 반환
		 * 			(2) uncaughtException : 쓰레드 그룹의 쓰레드가 처리되지 않은 예외에 의해 실행이 종료되었을 때 JVM에 의해서 자동으로 호출
		 */
		
		//  쓰레드 그룹 생성
		ThreadGroup main = Thread.currentThread().getThreadGroup();
		ThreadGroup grp1 = new ThreadGroup("Group1");
		ThreadGroup grp2 = new ThreadGroup("Group2");

		// 하위 쓰레드 그룹 편입
		ThreadGroup sub1 = new ThreadGroup(grp1, "sub1");

		// 쓰레드 그룹 grp1의 최대 우선순위 3으로 변경
		// 쓰레드가 그룹에 추가되기 전에 수행한다.
		grp1.setMaxPriority(3);	
		
		Runnable r = new Runnable() {
			// 메소드 재정의
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {}
			}
		};
		// 쓰레드 그룹에 포함
		// - 참조변수 없이 실행하였으나 쓰레드 그룹에 속해있으므로 가비지 컬렉터의 대상에 포함되지 않는다.
		new Thread(grp1, r, "th1").start();;
		new Thread(sub1, r, "th2").start();;
		new Thread(grp2, r, "th3").start();;
		//
		System.out.println("List of ThreadGroup : " + main.getName() + ", Active ThreadGroup : " + main.activeGroupCount() + ", Active Thread : " + main.activeCount());
		
		// 쓰레드 그룹에 속한 쓰레드와 하위 쓰레드 그룹에대한 정보 조회
		// 우선순위가 3인 grp1과 sub1이 grp2보다 먼저 조회된다.
		main.list();
	}
}
