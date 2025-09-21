package ex1_method;

public class Ex1_Method {
	public static void main(String[] args) {
		/*	메소드
		 * 		- 특정 작업을 수행하는 일련의 문장들을 하나로 묶은 것
		 * 		- 선언부, 구현부로 구성된다.
		 * 		
		 * 		(1) 선언부
		 * 			- 반환타입, 메소드명, 매개변수 타입으로 구성되어있다.
		 * 				int add(int x, int y) {
		 * 					(2) 구현부
		 * 						- 메소드가 호출했을 때 수행될 문장이 들어가는 영역
		 * 					int result = x + y; 
		 * 					
		 * 					(3) return문
		 * 						- 메소드의 결과인 반환값을 호출한 메소드로 전달하는 키워드
		 * 						- 결과 값의 타입은 반환타입과 일치하거나 적어도 자동 형변환이 가능해야 한다.
		 * 					return result;
		 * 				}
		 */
		MyMath mm = new MyMath();
		long result1 = mm.add(5L, 3L);
		long result2 = mm.subtract(5L, 3L);
		long result3 = mm.multiply(5L, 3L);
		double result4 = mm.divide(5L, 3L);
		
		System.out.println("add(5L, 3L) : " + result1);
		System.out.println("subtract(5L, 3L) : " + result2);
		System.out.println("multiply(5L, 3L) : " + result3);
		System.out.println("divide(5L, 3L) : " + result4);
	}
}

//
class MyMath {
	long add(long a, long b) {
		return a + b;
	}
	
	long subtract(long a, long b) { return a - b; }
	long multiply(long a, long b) { return a * b; }
	double divide(double a, double b) {
		return a / b;
	}
}
