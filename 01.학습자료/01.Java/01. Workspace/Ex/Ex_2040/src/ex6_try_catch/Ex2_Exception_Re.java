package ex6_try_catch;

public class Ex2_Exception_Re {
	public static void main(String[] args) {
		/* 예외 되던지기
		 *		- 예외 처리 후 인위적으로 다시 발생시키는 방법
		 *		- 한 메소드에서 발생할 수 있는 예외가 여러가지인 경우, 몇 개는 try문으로 자체 처리하고 나머지는 선언부에 지정하여 요청한 메소드에서 처리하는 방식 
		 *		
		 *			(1) 예외가 발생할 가능성이 있는 메소드에서 try문 사용
		 *			(2) catch 블록에서 필요한 작업 수행
		 *			(3) throw 문을 통해서 예외 재 발생하여 (1)으로 예외 전달
		 *			(4) 메소드에서 예외 재 처리
		 */
		
		try {
			//
			method1();
		} catch (Exception e) {
			//
			System.out.println("main메소드에서 예외 처리");
		}
	}
	
	static void method1() throws Exception{
		//
		try {
			//
			throw new Exception();
		} catch (Exception e) {
			System.out.println("method1 메소드에서 예외 발생");
			throw e;
		}
	}
}
