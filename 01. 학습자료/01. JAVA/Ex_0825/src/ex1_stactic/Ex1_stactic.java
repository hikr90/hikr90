package ex1_stactic;

/*요약
 * static변수는 각 클래스에 해당하는 값을 한번에 전부 바꿔야할 때 사용한다.
 * 
* 일반 메서드
 일반 메서드에서는 일반 변수와 static변수 모두 호출(syso)할 수 있다.
 일반 메서드 안에서는 일반적인 지역 변수를 만드는 것도 가능하다.
 일반 메서드 안에서는 static 변수를 생성할 수 없다. 

* static 메서드
  static 메서드안에서는 일반 변수를 사용할 수 없고, static변수만 syso호출할 수 있다.
  static 메서드안에서는 일반 지역변수만 사용할 수 있다.*/

public class Ex1_stactic {
			
		String str1 = "일반적인 멤버 변수";
		// static 변수
		static String str2 = "stactic 변수입니다. ";
		
		// static 메서드
		public static void result() {
			// stactic 메서드 내부에서는 static 멤버 변수만 사용이 가능하다.
			// System.out.println(str1); <-- 일반적인 멤버 변수는 사용이 불가능하다.
			System.out.println(str2);
			
			// static 메서드의 내부에서는 일반적인 지역변수를 만들어서 사용이 가능하다.
			int num = 10;
			// static메서드에서는 static으로 선언된 지역변수를 사용할 수 없다.  
			// static int num = 10;
		} 

		public void getResult() {
			
			// 일반적인 메서드에서는 static변수와 일반 멤버변수를 모두 사용할 수 있다.			
			System.out.println(str1);			
			System.out.println(str2);
			
			// 일반 메서드 안에서 static 키워드를 사용하는 변수를 생성할 수 없다. 
			// static int num = 10; 
			
			
			
			// 일반 메서드 내부에서는 일반적인 지역변수만 생성할 수 있다.
			int num = 10;
		}

	
		/*
			객체 생성시, 부모(영역)클래스의 생성자가 먼저 생성이 되고, 그다음 주소를 따라와서 자식(객체가)이 생성된다.
				부모를 객체화시킬 경우 이므로 부모와 자식의 주소값이 겹치지 않는다.		
		
		 * */
	
	
	
	
}
