package ex3_generic;

public class GenericMain {
	
	public static void main(String[] args) {
		
		// Generic의 장점
		// 똑같은 클래스, 메서드이지만 Ex1_Generic에따라서 다른 타입으로 값을 사용할 수 있다.
		// 모든 타입의 클래스를 저장하는 것이 가능하다.
		
		// 한번 형을 선언하면 계속해서 그 형만 사용해야한다.
		
		// main에서 호출시 반드시 <>안의 클래스를 하나 넣어야한다.
		Ex1_Generic<String> v1 = new Ex1_Generic<String>(); 
		
		// generic자리에 있는 클래스 타입으로 String타입을 받는다. 
		// <>의 String이 ex1_Generic의 T에 들어간다.
		v1.setValue("스트링타입의 값");
		String res = v1.getValue();
		System.out.println(res); 		
		
		
		Ex1_Generic<Integer> v2 = new Ex1_Generic<Integer>();
		v2.setValue(100);
		int res2 = v2.getValue();
		System.out.println(res2);
		
		
		Ex1_Generic<Character> v3 = new Ex1_Generic<Character>();
		v3.setValue('A');
		char res3 = v3.getValue();
		System.out.println(res3);
		
		
		
		
		
		
		
		
		
	} // main
}
