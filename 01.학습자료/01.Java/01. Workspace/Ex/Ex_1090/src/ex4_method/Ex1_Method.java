package ex4_method;

public class Ex1_Method {
	
	public static void main(String[] args) {
		// 클래스 생성 후 메소드 실행
		Ex2_String_Method v1 = new Ex2_String_Method();
		v1.greet();
		
		System.out.println("---------------");
		
		// 파라미터 값을 받는 메소드 실행
		// 	- 들어가는 파라미터 값에따라서 결과가 다르게 나온다.
		int su = 100; 
		int su2 = 0;
		v1.test1(su);

		// 	- 메소드는 값을 전달하는 용도로 사용된다.
		// 	- 실제로 su 의 변수 값이 메소드에 들어간 것은 아니고 그 값이 복제되어 메소드로 들어간 것이다.
		// 	- 원본 값은 변하지 않았으므로 su의 값은 그대로이다.
		System.out.println("su : "+su);
		
		System.out.println("---------------");

		// 리턴 타입이 있는 메소드 실행
		// 	- 메소드가 리턴하는 값을 변수로 받아주면 메소드 안에서 변한 값을 그대로 받아서 저장할 수 있다.
		su2 = v1.test0(su);
		System.out.println("su2 : "+su2);
		
		System.out.println("---------------");
		
		// String 타입의 리턴 메소드 실행
		String name = "홍길동";
		int age = 19;
		String res = v1.test2(age);
		
		System.out.printf("%s님은 %s입니다.\n",name,res);

		System.out.println("---------------");
		
		// boolean 타입의 리턴 메소드 실행
		System.out.println("---남자 목욕탕 관리사 조건---");
		boolean result = v1.test3("남", 21);
		//
		if(result==true) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
	}
}
