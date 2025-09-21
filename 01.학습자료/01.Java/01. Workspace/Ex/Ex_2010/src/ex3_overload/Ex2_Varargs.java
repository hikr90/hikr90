package ex3_overload;

public class Ex2_Varargs {
	public static void main(String[] args) {
		/*	가변인자
		 * 		- 메소드 내 동적으로 매개변수를 지정하는 기능
		 * 		- 타입... 변수명의 형식으로 선언하며 printf가 대표적인 예시이다.
		 * 		- 만약 가변인자 외에 매개변수가 더 있는 경우 가변인자를 가장 마지막에 선언해줘야 컴파일러가 제대로 읽어낼 수 있다.
		 * 
		 * 			public PrintStream printf(String format, Object... args) {...}
		 * 
		 *		[참고] 가변인자의 생성 방식은 배열 형태이다.
		 *			- 가변인자는 내부적으로 배열을 이용한다.
		 *			- 매개변수의 타입을 배열로 할 경우 반드시 인자를 지정해줘야하므로 인자를 생략하지 못하고 반드시 null이나 0으로 작성해야 한다.
		 *			
		 *				String concatenate(new String[]{"A", "B"});
		 */
		
		// [참고] 가변인자를 받는 메소드에는 오버로딩을 하지 않는 것이 좋다.
		String [] strArr = {"100", "200", "300"};
		
		System.out.println(concatenate("", "100", "200", "300"));
		System.out.println(concatenate("-", strArr));
		System.out.println(concatenate(",", new String[] {"1", "2", "3"}));
		System.out.println("[" + concatenate(",", new String[0]) + "]");
		System.out.println("[" + concatenate(",") + "]");
	}
	
	//
	static String concatenate(String delim, String... args) {
		String result = "";
		
		for(String str : args) {
			result += str + delim;
		}
		
		return result;
	}
	
	// [에러] 가변인자 메소드가 오버로딩있을 경우, 컴파일러는 두 메소드를 구분하지 못한다.
	/* static String concatenate(String... args) {
		return concatenate("", args);
	}*/
}
