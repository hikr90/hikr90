package ex1_operator;

public class Ex3_Operator {
	public static void main(String[] args) {
		// 비트 연산자
		int a = 10; // 2진수 : 1010
		int b = 7; // 2진수 : 0111
		
		/* 논리곱 (and)
		 *		- 2진수의 곱셈 방식으로,
		 *		- 두 값의 2진수가 0 혹은 1의 값이 나오게되는데
		 *		- 양쪽의 값이 1인 경우 1을 반환하고 나머지 상황은 0을 반환한다.
		 *		
		 *		- 1010과 0111을 곱하는 경우 0010 (숫자 2)이 반환된다.
		 * 
		 */
		int c = a & b;
		System.out.println("논리곱 : " + c);
	
		/* 논리합 (or)
		 *		- 2진수의 덧셈 방식으로,
		 *		- 두 값이 모두 0일 때 0을 반환한다. 
		 *		
		 *		- 1010과 0111을 더하는 경우 1111 (숫자 15)를 반환된다.
		 */
		c = a | b;
		System.out.println("논리합 : " + c);
		
		/* 베타적 or (xor) 
		 *		- 2신수의 or 연산으로,
		 *		- 두 값이 같은 경우 0, 다르면 1을 반환한다.
		 *
		 * 		- 1010과 0111을 or 연산하는 경우 1101 (숫자 13)을 반환한다.
		 * 
		 */
		c = a ^ b;
		System.out.println("베타적or : " + c);
		
		System.out.println("------------------");
		
		
		// 시프트 연산자
		// 1100이 왼쪽으로 001100이 되는데, 뒤의 00은 잘려서 0011이 되어 3이 나온다.
		int n1 = 12; //2진수 : 1100
		int n2 = n1 >> 2; 
		System.out.println("비트연산 : " + n2);

		char ch = 'F'; // F는 70으로 16진수시 : 1000110
		char ch_res = (char)(ch >> 1); // 좌로 이동시 : 0100011

		// 디모션 캐스팅을 통해서 문자 자료형으로 두었기에 아스키코드의 35숫자에 해당하는 #으로 출력이 된다. 
		System.out.println("비트연산 : " + ch_res);
		
		// 만약 35로 출력하고싶다면 int에 담아서 출력하면 된다.
		// int char_res = ch >> 1; 
		// System.out.println(char_res);
	}
}



