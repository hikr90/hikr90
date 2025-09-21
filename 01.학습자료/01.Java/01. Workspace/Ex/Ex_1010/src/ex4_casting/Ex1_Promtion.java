package ex4_casting;

/*	Casting (형변환)
 * 		- 서로 다른 타입간의 변수를 연산하기위해서, 변수 혹은 상수의 타입을 다른 타입으로 변환하는 것
 * 		- 범위의 크고 작음에 따라서, 명시적 / 암시적 형변환으로 처리된다.
 * 		- 연산을 위해서는 서로 같은 타입으로 변환해야 한다.
 * 		- 기본 자료형 중, 논리형을 제외한 나머지 타입은 형변환이 가능하다.
 * 
 * 		형태
 * 		- (타입)피연산자
 */

public class Ex1_Promtion {
	public static void main(String[] args) {
		/* Promotion Casting
		 *		- 큰 자료형에 작은 자료형을 대입하여 자동으로 형변환이 되는 방식이다.
		 * 	- 예로, 8byte의 double에 4byte의 int값이 대입되는 경우 8 > 4 이므로 자동으로 형변환이 이루어진다.
		 * 	- 서로 다른 두 타입 간 연산에서는 더 표현 범위가 넓은 타입으로 변환하여 연산을 수행한다. (값손실의 위험이 더 적은)
		 *
		 *		캐스팅의 예시
		 *			 (1) 정상 
		 *				- int i = 'A';								// 문자 'A'의 유니코드 65가 저장된다.
		 *				- long l = 123;						// int보다 long이 범위가 더 크므로 문제 없다.
		 *				- double d = 3.14f;				// double (8byte) 가 float (4byte)보다 범위가 넓으므로 문제 없다.
		 *				- byte b = 65;						// byte와 short타입은 리터럴이 따로 존재하지 않으므로 값의 크기만 각 타입에 들어갈 수 있으면 저장 가능하다.
		 *				- char ch = ' ';						// 공백 문자로 변수 초기화가 가능하다.
		 *				- String s = "";						// 내용이 없는 빈 문자열은 저장이 가능하다.
		 * 
		 * 		(2) 비정상
		 * 			- int i = 0x123456789; 		//	int의 범위를 벗어나서 저장할 수 없다.
		 * 			- float f = (int)1.6f;				// (큼) int 의 값을 (작음) float의 공간에 담는 과정에서 0.6의 값이 버려진다.
		 * 			- float f = 3.14;					// 실수의 기본 자료형은 double이므로 (4byte의 값을 8byte의 값에 저장할 수 없다.)
		 *				- char ch = '' ; 						// 문자 리터럴은 반드시 하나의 문자가 있어야하므로 저장할 수 없다.
		 *
		 *
		 *		[참고] 자동 형변환이 가능한 방향
		 *			- 실수형은 정수형보다 더 큰 표현 범위를 가지고있으므로 더 오른쪽에 위치
		 *			byte (1byte)		>>		short (2byte)		>>		int (4byte)		>>		long (8byte)		>>		float (4byte)		>>		double (8byte)
		 *													char (4byte)			>> 
		 */
		double d = 100.5;
		int n = 200;
		//
		d = n;
		System.out.println("d : " + d);

		// [참고] c는 문자형으로 아스키코드에 의해서 정수형태로 형 변환이 된다. 
		char c = 'A';
		int n2 = c + 1;		
		System.out.println("n2 : " + n2);
		
	}
}
