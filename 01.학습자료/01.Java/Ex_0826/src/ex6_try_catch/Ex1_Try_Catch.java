package ex6_try_catch;

public class Ex1_Try_Catch {
	
	public static void main(String[] args) {
		
		
		/* try-catch(예외처리)
		자바에서 프로그램이 실행되는 도중 예외(에러)가 발생하면, 그 시점에서 프로그램이 강제적으로 종료된다.
		이 것은 올바른 판단이지만 때로는 예상가능한 오류가 발생했을 때, 프로그램 강제 종료없이 이후의 작업을 진행해야하는 경우가 있다.
		
		예외처리를 통해서 프로그램의 비정상적인 종료를 줄이고, 정상적으로 진행될 수 있도록 해보자
		
		
		*/
		
		// 예측가능한 오류
		// java.lang.ArithmeticException: / by zero - exception(모든 exception의 부모격)이 있으면 예외사항
		// 위 오류의 뜻은 정수를 0으로 나눴을 때의 오류
		int n = 0;
		int result = 0;
		int [] arr = {1,2,3,4};
		
		// try-catch : 오류 코드를 {}으로 묶는다. 
		// try 영역 안에서 난 오류는 그대로 catch로 넘어가서 catch영역을 실행한다.
		// 만약 try영역에서 오류가 발생하지 않으면 catch를 실행하지 않고 그대로 빠져나간다. 
		
		// try영역에서는 단 하나의 오류만 처리하게되는데
		// 처리하는 오류에 해당하는 catch영역만 발생하게 된다.
		

		try {
		
		result = 10 / n;
		arr [3] = 4;
		
		}catch(ArithmeticException e) {
			// 현재 발생한 오류의 이름을 출력하는 메서드
			// 오류는 알려주되, 출력은 끝까지 해준다.
			// e.printStackTrace();
			System.out.println("0으로는 나눌 수 없습니다.");
			result = -1;
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열에 존재하지 않는 인덱스로 접근함");
		// 예외발생 유무와 상관없이 무조건 호출되는 영역
		}finally {
			System.out.println("finally");
		}
		
		
		System.out.println(result);
		
		
	}
}
