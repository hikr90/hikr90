package ex3_casting;

public class Ex1_promtion {
	public static void main(String[] args) {
		/* Promotion Casting
		 *		- 큰 자료형에 작은 자료형을 대입하여 자동으로 형변환이 되는 방식이다.
		 *	
		 *		캐스팅의 예시
		 *			 정수 > 실수
		 * 			- 8byte의 double에 4byte의 int값이 대입되는 경우 8 > 4 이므로 자동으로 형변환이 이루어진다.
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
