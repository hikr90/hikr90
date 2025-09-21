package ex2_generic_class;

public class Ex2_Generic_Class {
	
	public static void main(String[] args) {
		
		/*	제네릭 클래스
		 * 	- 클래스에서 사용할 데이터의 타입을 미리 정하는 클래스
		 * 	- 데이터 저장 전에 형태를 지정할 수 있다.
		 * 
		 * 	클래스<타입> 변수명 = new 클래스<타입>();
		 *
		 * 	- 컴파일 시에 타입 체크를 진행한다. 
		 * 	- 타입의 명칭은 대문자로 작성한다.
		 * 
		 * 
		 * 	제네릭의 장점
		 * 		- 똑같은 클래스를 사용하여 생성한 각각의 객체에 다른 타입의 데이터를 저장할 수 있다.
		 * 		- 한번 형을 선언하면 계속해서 해당 형만 사용할 수 있다.
		 */
		Ex1_Generic<String> v1 = new Ex1_Generic<String>(); 		// Ex1_Generic 클래스로 String 타입을 받는다.
		v1.setValue("스트링타입의 값");
		//
		String res = v1.getValue();
		System.out.println(res); 		
		//
		Ex1_Generic<Integer> v2 = new Ex1_Generic<Integer>();
		v2.setValue(100);
		int res2 = v2.getValue();
		System.out.println(res2);
		//
		Ex1_Generic<Character> v3 = new Ex1_Generic<Character>();
		v3.setValue('A');
		char res3 = v3.getValue();
		System.out.println(res3);
	} // main
}
