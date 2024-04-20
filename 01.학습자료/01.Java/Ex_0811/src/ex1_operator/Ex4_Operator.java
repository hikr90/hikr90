package ex1_operator;

public class Ex4_Operator {
	public static void main(String[] args) {
		
		// 증감 연산자 : 1씩 증가시키거나 1씩 감소시키는 연산자이다.
		// 선행 증감과 후행 증감의 차이점
		
		int a = 10;
		int b = 10;
		
		// 선행증가 : ()만큼 동작 우선순위가 빠르다. +를 만나자마자 증가/감소 갱신 후 출력 
		System.out.println("a : " + ++a);
		// 후행증가 : 후행증가는 연산자 우선순위가 가장 느리다. 원래의 값을 먼저 출력을 한 뒤, b 증가/감소 갱신
		System.out.println("b : " + b++);
		// b가 11로 되어있는 것을 확인
		System.out.println(b);
		
		// 증감 연산자는 변수로 동작하므로 바로 적용된다.
		++b; // 12
		++b; // 13
		b--; // 12
		b++; // 13
		--b; // 12
		b++; // 13
		b++; // 14
		System.out.println(--b); // 13
		
		// 2증가는 증감연산자말고 +=를 사용한다. 
		System.out.println(b +=2);
		
		System.out.println("------------------");
		
		// 삼항연산자 : 하나의 조건을 제시하고 그 조건이 참일 때와 거짓일 때의 결과를 다르게 반환하는 연산자
		// 조건 ? 참값일 경우 : 거짓일 경우;
		// 참거짓의 유무에따라서 해당 값에 맞는 타입의 변수에 넣을 수 있다.
		// 참값의 타입과 거짓값의 타입을 다르게 할 수 없다. 
		int i1 = 10;
		int i2 = 15;
		
		// boolean타입에 넣는 경우 
		boolean res = ++i1 >= i2 ? true : false;
		System.out.println(res);
		
		// char타입에 넣는 경우
		char res2 = ++i1 >= 12 ? '합' : '불';
		System.out.println(res2);
		
		// int타입으로 받아서 넣는 경우
		int res3 = i1 == 12 ? 1 : 0;
		System.out.println(res3);
		
		System.out.println("------------------");

		a = 10;
		b = 12;
		char res4 = ++a >= b || 2 + 7 <= b && 13 - b >= 0 && (a += b) - (a % b) > 10 ? 'O' : 'X';
		System.out.println("결과값 : " + res4);
	}
}
