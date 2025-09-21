package ex4_casting;

public class Ex2_Demotion {
	public static void main(String[] args) {
		
		/*	Demotion Casting 
		 * 	- 작은 자료형에 큰 자료형이 대입되어 형변환이 이루어지는 방식
		 * 	- 값의 손실이 일어날 수 있으므로 자동으로 진행되지 않는다.
		 * 
		 * 	사용 방법
		 * 		- (작은 자료형)큰 자료형 
		 */
		char c = 'A'; 		// 2byte
		int n = c + 1; 	// 4byte
		
		// c (2byte) 에 n (4byte)를 대입
		c = (char)n;
		System.out.println("c : " + c);
		
		System.out.println("------------------");
	
		// 값의 손실이 나는 경우
		float f = 5.5f; 	// 4.byte
		int num = 0;		// 4byte
		
		num = (int)f;	// 값이 5로 저장되면서 0.5의 값이 손실된다.
		System.out.println("num : " + num);
		
		System.out.println("----------------------------");

		// [예시] 형 변환에대한 값의 손실
		System.out.println((int)8.43+2.59);				// 8.43이 8로 값 손실
		System.out.println((int)(8.43+2.59));			// 합계 11.02가 11로 값 손실
		System.out.println((int)(8.43)+(int)(2.59));	// 합계 11.02가 10으로 값 손실
		
		System.out.println("----------------------------");
		
		/*	Class Type의 형변환
		 *		- String은 클래스 타입으로 형변환을 위해서는 해당 타입의 클래스의 메소드로 변환해야한다.
		 *		- Parsing은 변환의 뜻을 가진다.
		 */		
		String num1 = "1";
		String num2 = "2";
		System.out.println(Integer.parseInt(num1)+Integer.parseInt(num2));
	}
}
