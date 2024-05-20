package ex1_stactic;

public class Ex1_stactic {
		
		/*	static 
		 * 	- 변수나 메소드를 정적으로 만드는 키워드
		 *		- 각 클래스에 해당하는 값을 한번에 제어하고자하는 경우 사용한다.
		 *
		 *		정적 멤버 & 정적 클래스
		 *			- 변수 앞에 사용하는 경우, static 변수를 생성한다.
		 *			- 메소드 앞에 사용하는 경우, static 메소드를 생성한다.
		 *		
		 *			- 생성된 정적 멤버는 heap 영역이 아닌 static 영역에 저장된다.
		 *			- static 영역에 할당된 메모리는 모든 객체가 공유하므로 static 데이터를 어디에서라도 사용 가능하다.
		 *			- static 영역은 가비지 컬렉션의 범주 밖에 있어 static 을 남발할 시 시스템의 성능이 하락한다.
		 *			
		 *		 	(1) 일반 메소드
		 *				- 일반 변수와 static 변수 모두를 제어 가능하다.
		 *				- 일반 지역 변수를 생성할 수 있다.
		 *				- 일반 메소드 내에서는 static 변수를 생성할 수 없다.
		 *
		 *			(2) static 메소드
		 * 			- 일반 변수를 사용할 수 없고 static 변수만 제어 가능하다.
		 * 			- 일반 지역변수만 생성 가능하다.
		 */
		String str1 = "일반적인 멤버 변수";
		static String str2 = "stactic 변수입니다. ";
		
		// static 메서드
		public static void result() {
			// System.out.println(str1); // 일반적인 멤버 변수 사용 불가능
			System.out.println(str2);
			//
			int num = 10;				// 일반적인 지역변수는 생성 가능
			// static int num = 10;	// static 변수는 생성 불가능
		} 

		// 일반 메소드
		public void getResult() {
			// static과 멤버 변수 모두 사용 가능하다.
			System.out.println(str1);			
			System.out.println(str2);
			
			// static int num = 10; 	// 일반 메소드 내에서 static 변수는 사용할 수 없다.
			int num = 10;		// 일반 메소드 내에서 일반적인 지역변수는 사용할 수 있다.
		}

		// [참고] 객체 생성 시, 부모 클래스의 생성자가 먼저 생성되고 그 후 자식 객체의 생성자가 생성된다.
		// - 즉, 부모를 객체화하는 경우 부모와 자식의 주소 값이 서로 겹치지 않는다.
}
