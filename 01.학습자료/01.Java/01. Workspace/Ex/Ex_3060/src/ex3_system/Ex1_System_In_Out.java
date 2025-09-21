package ex3_system;

public class Ex1_System_In_Out {
	public static void main(String[] args) {
		/*	표준입출력 (IO)
		 * 		- 콘솔을 통한 데이터 입력과 콘솔로의 데이터 출력을 의미한다.
		 * 		- 자바에서는 표준 입출력을 위해 아래 3가지의 입출력 스트림을 제공한다.
		 * 		- 이 들은 자바 어플리케이션의 실행과 동시에 사용할 수 있게 자동적으로 생성되므로 개발자가 별도로 스트림을 생성하는 코드를 작성하지 않고도 사용 가능하다. 
		 * 
		 * 			(1) System.in 	: 콘솔로부터 데이터를 입력받는데 사용 	(Java > InputStream < Console)
		 * 			(2) System.out 	: 콘솔로 데이터를 출력하는데 사용 		(Java > PrintStream > Console)
		 * 			(3) System.err 	: 콘솔로 데이터를 출력하는데 사용 		(Java > PrintStream > Console)
		 * 
		 * 			[참고] in, out, err는 System클래스에 선언된 클래스 변수 (static)이다.
		 */
		try {
			int input = 0;
			
			while ((input = System.in.read()) != -1) {
				System.out.println("input : " + input + ", (char)input : " + (char)input);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
