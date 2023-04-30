package ex1_operator;

public class Ex1_Operator {
	public static void main(String[] args) {
		
		/* 연산자(Operator)
		1. 최고연산자 : ., ()
			연산자 순위가 가장 높다.
		2. 증감연산자 : ++, --
		3. 산술연산자 : +, -, *, /, %
		4. 시프트 연산자 : >>, <<
		5. 비교연산자 : >, <, >=, <=, ==, !=
		6. 비트연산자 : &, |, ^
		7. 논리연산자 : &&, ||, !
		8. 삼항(조건)연산자 : ?, : 
		9. 대입연산자 : =, *=, /=, %=, +=, -=
		*/
		
		// 산술 연산자 : 4칙연산과 나머지 연산자 
		int n1 = 20;
		int n2 = 7;
		int n3 = n1 + n2;
		System.out.println("+연산 : " + n3);
		
		n3 = n1 - n2;
		System.out.println("-연산 : " + n3);
		
		// 나누기 연산자(/)와 나머지 연산자(%)
		n3 = n1 / n2;
		System.out.println("/연산 : " + n3);
		n3 = n1 % n2;
		System.out.println("%연산 : " + n3);
		
		System.out.println("------------------");
		
		// 대입연산자 : 특정 값을 변수에 전달하여 기억시키는 경우 사용하는 연산자
		int i1 = 10;
		int i2 = 7;
		System.out.println(i1 + ", " + i2);
		
		// += : i1 = i1 + i2;
		// 누적해서 값이 바뀐다. 
		i1 += i2;
		System.out.println("+=연산 : " + i1);
		
		// 대입(누적)연산자는 기존의 값이 누적되어있으므로 값을 착각하면 안된다.
		i1 -= 2; // i1 = i1 - 2;
		System.out.println("-=연산 : " + i1);
		
		i1 /= 3; // i1 = i1 / 3;
		System.out.println("/=연산 : " + i1);
		
		i1 %= 2; // i1 = i1 % 2;
		System.out.println("%=연산 : " + i1);
		
	}
}
