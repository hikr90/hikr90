package ex6_try_catch;

public class Ex1_Try_Catch {
	
	public static void main(String[] args) {
		
		/* 프로그램 오류
		 * 	- 실행 중에 어떠한 이유로 인해서, 오작동을하거나 비정상적으로 종료되는 경우
		 * 	- 발생 시점에따라, 컴파일 에러 혹은 런타임 에러라고 구분한다.
		 * 	
		 * 		(1) 컴파일 에러 : 컴파일 시, 발생하는 에러
		 * 		(2) 런타임 에러 : 프로그램 실행 도중 발생하는 에러
		 * 		(3) 논리적 에러 : 컴파일, 실행에는 문제가 없으나, 개발자의 의도와 다르게 동작하는 에러
		 * 
		 * 	- 컴파일러는 컴파일 시, 소스코드 (.java) 에 대해 오타나 잘못된 구문, 자료형 체크 등의 기본적인 검사로 오류가 있는지 확인한다.
		 * 	- 단, 컴파일러는 프로그램 동작 중에 발생하는 런타임 에러는 검사할 수 없으므로 개발자는 실행 시 발생할 수 있는 모든 상황을 대비해야 한다.
		 * 	- 자바에서는 실행 시, 발생할 수 있는 프로그램 오류로 에러와 예외 두가지로 구분한다.
		 * 
		 * 		(1) 에러
		 * 			- 메모리 부족, 스택 오버플로우 (자료형이 표현할 수 있는 값의 범위 벗어나는 오류) 와 같은 복구할 수 없는 심각한 단계의 오류
		 * 			- 개발자가 예측할 수 없고, 프로그램 코드에 의해서 수습될 수 없다.
		 * 
		 * 		(2) 예외
		 * 			- 발생하더라도 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 단계의 오류
		 * 			- 개발자가 예측 가능하고 예외처리 등의 작업을 통해서 대비할 수 있다.
		 * 
		 * 			(2.1) 예외의 종류
		 * 				(2.1.1) 일반 예외 (Checked)
		 * 					- 컴파일 단계에서 감지되는 예외를 뜻한다.
		 * 					- Runtime Exception을 제외한 모든 예외이다. 
		 * 						(DataFormat Exception, SQLException, IOException 등...)
		 *  
		 * 				(2.1.2) 실행 예외 (Unchecked)
		 * 					- Runtime Exception 이라고도 부른다.
		 * 					- 컴파일 당시에는 감지하지 못하나, 실제 구동 중에 문제가 발생하는 예외이다.
		 * 						(NullPointerException, ArithmeticException, ArrayIndexOutOfBoundsException 등...)
		 * 
		 * 			[참고] 오류, 예외 클래스 구조
		 * 				Object 	- Throwable - Error 	- OutOfMemoryError 등...
		 * 											ㄴ Exception	- RuntimeException
		 * 																-  NullPointerException
		 * 																- IOException 등...
		 * 
		 * 		(3) 예외처리
		 * 			- 개발자가 프로그램 실행 시 발생할 수 있는 예외에 대비한 코드 작성하는 것
		 * 			- 프로그램의 비정상적인 종료 방지 및 정상적인 상태 유지
		 */
		
		/*	try-catch
		 * 	- 개발자가 의도한대로 처리하는 구현 로직
		 * 	- try 영역에서 오류가 발생할 경우 그에 맞는 catch 블록으로 넘어간다. (try 영역에서 오류가 발생하지 않으면 catch 블록으로 진입하지 않는다.)
		 * 	- try 영역에 생성되는 변수는 지역 변수로서 외부에서 사용하고자하는 경우 외부에서 전역 변수로 선언해야한다.
		 * 	- 예외가 발생하면 발생한 예외에 해당하는 클래스의 인스턴스가 생성된다. 
		 * 
		 * 	[참고] 예외가 발생한 메소드 내에서 자체적으로 처리되도 되는 것은 메소드 내에서 처리, 메소드에 호출 시 넘겨받아야할 값을 다시 돌려받아야하는 경우 예외를 메소드에 선언해서, 호출한 메소드에서 처리한다.
		 * 
		 * 	try {
		 * 			// 코드 구현
		 * 	} catch (Exception e) {
		 * 		// 오류 발생 시 처리할 작업
		 * 	}
		 */
		int n = 0;
		int result = 0;
		int [] arr = {1,2,3,4};
		//
		try {
			//
			result = 10 / n;				// 정수를 0으로 나누려는 오류 (ArithmeticException)
			arr [3] = 4;					// 배열의 인덱스가 존재하지 않는 오류 (ArrayIndexOutOfBoundsException)
		
			// 고의 발생
			// 예외 클래스 인스턴스 생성 시, 생성자에 String을 넣어주면 인스턴스의 메세지로 저장된다.
			// throw new Exception("고의 발생");
			
		} catch(ArithmeticException e) {
			//  예외 발생 당시의 호출스택에 있었던 메소드 정보와 예외 메시지
			e.printStackTrace();
			// 발생한 예외 클래스의 인스턴스에 저장된 메시지
			System.out.println(e.getMessage());
			
			System.out.println("0으로는 나눌 수 없습니다.");
			result = -1;
		} catch(ArrayIndexOutOfBoundsException e) {
			// 개발자가 의도적으로 처리하는 영역
			System.out.println("배열에 존재하지 않는 인덱스로 접근함");
			
		} finally {
			// finally는 오류와 상관없이 반드시 동작하는 영역이다. (return이 있어도 동작)
			System.out.println("finally");
		}
		//
		System.out.println(result);
	}
}
