package ex1_operator;

public class Ex2_Operator {
	public static void main(String[] args) {
		
		// 비교 연산자 : 변수나 상수의 값을 비교하여 참과 거짓을 판단하는 연산자
		// 결과값은 반드시 true 혹은 false로만 반환된다.
		// 참과 거짓의 값은 boolean타입의 변수에만 담을 수 있다.
		int n1 = 10;
		int n2 = 20;
		// 비교연산자의 해석은 좌에서 우 이므로, n1이 n2보다 작다. (jsp에서는 <는 it, >는 gt로 부른다.)
		boolean result = n1 < n2;
		System.out.println("n1 < n2 : " + result);
		
		result = n1 >= n2;
		System.out.println("n1 >= n2 : " + result);
		
		result = n1 == n2;
		System.out.println("n1 == n2 : " + result);
		
		result = n1 != n2;
		System.out.println("n1 != n2 : " + result);
		
		System.out.println("------------------");
		
		// 논리 연산자 : 비교연산자를 통한 연산이 두개 이상 필요할 때, 사용하는 연산자 (비교연산자를 엮여주는 역할)
		// 논리 연산을 통한 결과값도 참 또는 거짓으로 반환된다.
		int age = 21;
		int limit = 25;
		
		// &&(and)연산자 : &&을 기준으로 앞의 연산을 판단한 뒤 뒤의 연산을 판단한다. 앞과 뒤의 연산자가 모두 참인 경우 참으로 반환한다. 
		//만약 앞의 연산이 거짓인 경우, 뒤의 연산을 하지 않는다. 
		// true && true --> true
		// true && false --> false
		// false && true --> false
		// false && false --> false
		
		boolean res = limit - age >= 5 && (age += 2) > 20;
		System.out.println(age);
		System.out.println(res);
		
		// ||(or)연산자 : ||을 기준으로 둘 중 하나라도 거짓이면 참으로 반환한다.
		// 만약 앞의 연산이 참인 경우 뒤쪽 연산은 수행하지 않는다.
		// false || false --> false
		// false || true --> true
		// true || false --> true
		// true || true --> true

		int i1 = 10;
		int i2 = 20;
		res = (i1 += 10) > 20 || (i2 -= 10) == 11;
		System.out.println(i2);
		System.out.println(res);
		
		// !(not)연산자 : !는 boolean변수 앞에서만 사용할 수 있다. boolean변수 앞에 붙이는 경우, 참은 거짓으로 거짓은 참으로 반환해준다. 
		// !는 영구적으로 값을 변경하지 않는다. 
		// 영구적으로 값을 변경하고자하면 boolean타입의 변수에 담아줘야한다. (res = !res;)
		System.out.println(!res);
		
	}
}
