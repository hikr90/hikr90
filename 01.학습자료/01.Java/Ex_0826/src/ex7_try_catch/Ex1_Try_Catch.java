package ex7_try_catch;

public class Ex1_Try_Catch {
	
	public static void main(String[] args) {
		
		/* 에러, 예외, 예외처리
		 * 		(1) 에러
		 * 			- 메모리 부족, 스택 오버플로우 같은 시스템 (하드웨어 혹은 jvm) 에서 발생하는 심각한 문제
		 * 			- 프로그램이 강제로 종료되는 심각한 수준의 문제이다.
		 * 			- 개발자가 예측할 수 없고, 발생 시 즉각 대처가 어렵다.
		 * 
		 * 		(2) 예외
		 * 			- 예외는 에러의 범주안에 속한다.
		 * 			- 대부분 개발자가 작성한 코드에서 발현된다.
		 * 			- 개발자가 예측 가능하고 미리 대비 가능하여 예외처리를 통한 구현 작업이 요구된다.
		 * 
		 * 			(2.1) 예외의 종류
		 * 				(2.1.1) 일반 예외 (Checked Exception)
		 * 					- 컴파일 단계에서 감지되는 예외를 뜻한다.
		 * 					- Runtime Exception을 제외한 모든 예외이다. 
		 * 						
		 * 						- DataFormat Exception 				: 		데이터 포맷이 맞지 않음
		 * 						- SQLException 								: 		SQL 관련 에러 (제약조건 위반, 테이블 명칭 오류 등)
		 * 						- IOException 								: 		입출력 관련 에러
		 * 						- EOFException 							: 		파일 데이터 끝 부분에 도달 시 예외처리가 없는 경우
		 * 						- FileNotFoundException 				:		파일을 발견하지 못함
		 * 						- InterruptedIOException 				:		입출력 처리 관련 에러
		 * 						- InvalidClassException 					: 		직렬화 관련 에러
		 * 						- NotSerializableException 			: 		오브젝트 직렬화 실패
		 * 						- UnsupportedEncodingException : 		인코딩 형식 미지원 에러
		 *  
		 * 				(2.1.2) 실행 예외 (Unchecked Exception)
		 * 					- Runtime Exception 이라고도 부른다.
		 * 					- 컴파일 당시에는 감지하지 못하나, 실제 구동 중에 문제가 발생하는 예외이다.
		 * 					
		 * 						- NullPointerException 							: 		Null 값에 접근하는 에러
		 * 						- ArithmeticException 							: 		잘못된 계산 (0으로 나눔)
		 * 						- ArrayIndexOutOfBoundsException 		: 		배열 인덱스 에러 (인덱스가 존재하지 않음)
		 * 						- ArrayStoreException 							: 		배열에 잘못된 자료형 대입
		 * 						- NegativeArraySizeException 				: 		배열의 인덱스가 마이너스
		 * 						- IllegalThreadStateException 				: 		이미 시작된 스레드를 다시 시작
		 * 						- NumberFormatException 					: 		숫자 변환 시 부적합한 자료형 사용
		 * 						- IllegalStateException 							: 		객체에서 메소드를 잘못된 방식으로 호출
		 * 						- UnsupportedOperationException	 	: 		지원되지 않는 메소드 호출
		 * 
		 * 				[참고] 둘다 try-catch 예외처리를 통해서 잡아낼 수 있다.
		 * 
		 * 		(3) 예외처리
		 * 			- 개발자가 비교적 가벼운 에러인 예외를 프로그램의 종료 없이 유지하기위해서 의도적으로 처리하는 작업을 뜻한다.
		 * 			- 예외처리는 비정상적인 종료를 줄이는데 목적이 있다.
		 */
		
		/*	try-catch
		 * 	- 예외처리
		 * 	- 예측 가능한 오류가 발생할 경우를 대비하여 개발자가 의도한대로 처리하는 구현 로직
		 * 	- try 영역에서 오류가 발생할 경우 catch 영역으로 넘어가며 catch 내 구문이 수행된다.
		 * 	- 만약 try 영역에서 오류가 발생하지 않으면 catch 영역으로 진입하지 않는다.
		 * 	- try 영역에 생성되는 변수는 지역 변수로서 외부에서 사용하고자하는 경우 외부에서 전역 변수로 선언해야한다.
		 * 
		 * 	-기본적인 try-catch문에서는 catch 파라미터인 하나의 예외 클래스만 처리 가능하므로 보통 예외의 부모 클래스인 exception클래스를 사용한다.
		 * 
		 * 	try {
		 * 			// 코드 구현
		 * 
		 * 	} catch (Exception e) {
		 * 		// 오류 발생 시 처리할 작업
		 * 	}
		 * 
		 */
		int n = 0;
		int result = 0;
		int [] arr = {1,2,3,4};
		//
		try {
			//
			result = 10 / n;				// 정수를 0으로 나누려는 오류 (ArithmeticException)
			arr [3] = 4;					// 배열의 인덱스가 존재하지 않는 오류 (ArrayIndexOutOfBoundsException)
		
		} catch(ArithmeticException e) {
			// 현재 발생한 오류의 명칭을 출력
			e.printStackTrace();
			// 개발자가 의도적으로 처리하는 영역
			System.out.println("0으로는 나눌 수 없습니다.");
			result = -1;
		} catch(ArrayIndexOutOfBoundsException e) {
			// 개발자가 의도적으로 처리하는 영역
			System.out.println("배열에 존재하지 않는 인덱스로 접근함");
			
		} finally {
			// finally는 오류와 상관없이 반드시 동작하는 영역이다.
			System.out.println("finally");
		}
		//
		System.out.println(result);
	}
}
