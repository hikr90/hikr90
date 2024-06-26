package ex2_value_type;

public class Ex1_valueType {
	public static void main(String[] args) {
		
		/* 자료형
		 * 	(1) 기본 자료형
		 * 		(1.1) 정수형
		 * 			byte
		 * 				- 표현범위 : -128 ~ 127
		 * 				- 1byte로 정수를 표현하는 자료형			
		 * 
		 * 			short
		 * 				- 표현범위 : -32768 ~ 32767
		 * 				- 2byte로 정수를 표현하는 자료형
		 * 		
		 * 			int (default)
		 * 				- 표현범위 : -21억 ~ 21억
		 * 				- 4byte로 정수를 표현하는 자료형
		 * 
		 * 			long
		 * 				- 표현범위 : -900경 ~ 900경
		 * 				- 8byte로 정수를 표현하는 자료형
		 * 	
		 * 		(1.2) 실수형 (3.14 등..)
		 * 			float
		 * 				- 표현범위 : 없음
		 * 				- 4byte로 실수를 표현하는 자료형
		 * 
		 * 			double (default)
		 * 				- 표현범위 : 없음
		 * 				- 8byte로 실수를 표현하는 자료형
		 * 
		 * 		(1.3) 문자형
		 * 			char
		 * 				- 표현범위 : 없음
		 * 				- 2byte로 문자를 표현하는 자료형
		 * 				- 'A' 혹은 'a' 등 '' 안에 한 글자로만 구성된 문자
		 * 
		 *			(1.4) 논리형
		 *				boolean
		 *					- 표현범위 : true 혹은 false
		 *					- 1bit로 표현하는 참 혹은 거짓 값 
		 *
		 *		(2) 클래스 자료형
		 *			String
		 *				- 첫 글자가 대문자인 자료형이 클래스 자료형에 속한다.
		 *				- 엄밀히 자료형이 아니지만 통상적으로 자료형이라 부르며 String 값은 아무 값도 들어가지 않는 경우 ""으로 초기화하게 된다.
		 *				
		 *				- 표현범위 : 표현하는 만큼
		 *				-  "ABC" 혹은 "가나다" 같은 문자열
		 */

		
		/*	변수 
		 * 	- 특정 값을 대입하여 저장하기위한 그릇 혹은 공간
		 * 	- 선언과 초기화 작업을 통해서 생성 및 저장할 준비를 한다.
		 * 	
		 * 	(1) 선언 규칙
		 * 		- 변수명은 클래스와 혼동되지 않도록 	대문자나 숫자로 시작해서는 안된다.
		 * 		- 특수문자는 _ 만 가능하다.
		 * 		- 한글로 변수명을 짓지 않는다.
		 * 		- 동일한 명칭의 변수명은 사용할 수 없다.
		 * 		- 기존 값이 남지 않도록 변수는 사용 후 초기화한다.
		 * 		- 명칭은 개발자 간 서로 쉽게 이해할 수 있도록 의미가 있는 단어로 작성한다.
		 * 
		 * 	(2) 사용 이유
		 * 		- 반복되는 값을 간단하게 관리하기 위해서.
		 * 		- 다른 사람이 봤을 때 이해가 쉽도록.
		 * 
		 * 	(3) 표현 방식
		 * 		- Camel Case 형태로 많이 사용한다.
		 * 		- 기본적으로 소문자로 작성하되, 첫글자는 대문자 나머지 글자는 소문자로 작성하는 형태이다.
		 * 		- 예시로 empNm, sendData등이 해당된다.
		 * 
		 * 	[참고] 컴퓨터 구조에서의 변수
		 *			- int x = 10; 는 컴퓨터 내 ram에 x라는 저장공간이 생성되고 그 안에 10이라는 숫자 값이 저장됨을 뜻한다. 
		 */
		
		// 변수의 선언, 대입, 초기화
		// 1. 숫자형
		// 선언
		int a1;
		
		// 대입
		a1 = 21000;
		
		// 초기화
		// - 변수의 선언과 대입이 동시에 이루어지는 형태
		// - 변수의 초기화는 중복으로 사용할 수 없으며 같은 명칭의 변수에 값을 대입하는 것으로 사용한다.
		// - 대입할 경우 기존의 값은 없어지고 대입한 값이 저장된다.
		int a2 = 21000;
		
		
		// 2. 논리형
		boolean b = true;
		System.out.println("b : " + b);
		
		b = false;
		System.out.println("b : " + b);
		
		System.out.println("-------------------------------");
		
		// 3. 문자형
		char c = 'A';
		System.out.println("c : " + c);
		
		c = 'B';
		System.out.println("c : " + c);
		
		// (예시) 아스키코드
		// - 미국 국립 표준 협회 (ANSI) 에서 표준화한 정보교환용 7비트 부호체계
		// - 문자형의 변수에 67이라는 10진법의 숫자를 16진법으로 변환하여 문자로 표현한다.
		c = 68;
		System.out.println("c : " + c);
		
		System.out.println("-------------------------------");

		// 4. 정수형
		byte by = 127; 
		int n = 2100000000;
		
		/*	long과 float 사용 시 주의사항
		 *		- jvm에서 변수에 값이 저장될 때 확인을 위해서 메모리를 사용하는데 값이 저장될 때마다 메모리가 낭비되는 것을 막기위해서
		 *		- 즉 컴파일 속도 향상을 위해서 int값을 기본 값으로 인식하도록 되어있다.
		 *
		 * 	- 그러므로 long 타입의 변수가 2100000000을 저장하는 경우 기본형인 int로 판단하여 값이 벗어났다고 인식하여 오류를 발생시킨다.
		 * 	- 그래서 int 범위가 넘어가는 21억 이상의 값을 저장할 때는 값 뒤에 l을 붙여서 해당 값이 long이라고 명시를 해야한다.
		 */		
		long lo = 2200000000l;	// long 타입임을 명시
		System.out.println("by : " + by);
		System.out.println("lo : " + lo);
		System.out.println("n : " + n);
		
		System.out.println("-------------------------------");
		
		// 5. 실수형
		float f = 3.14f;		// float 타입임을 명시
		double d = 3.14;
		
		// 실수형은 정수값이 입력되는 경우, 자동으로 .0을 붙여서 오류가 나지 않도록 한다.
		f = 150;
		d = 150;
		System.out.println("f : " + f);
		System.out.println("d : " + d);		
		}
}
