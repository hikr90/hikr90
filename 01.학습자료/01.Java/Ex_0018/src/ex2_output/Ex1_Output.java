package ex2_output;

import java.io.PrintStream;

public class Ex1_Output {
	public static void main(String[] args) {
		
		/*	PrintStream 
		 *		- 아웃풋 스트림의 대표적인 자식 클래스
		 *		- 화면 (콘솔)에 데이터를 출력한다.
		 */

		// 현재 예시는, System.out.print의 원본 코드 방식으로서 현재는 굳이 이렇게 사용하지 않고 그냥 Syso 를 사용한다.
		PrintStream ps = null;
		//
		try {
			//
			ps = System.out;
			ps.write(65);
			ps.write('B');
			
			// - 완전히 종료되어서 더이상 출력할 것이 없다는 것을 확정해야한다.
			// - 파일이 열려있는 엑셀을 삭제할 수 없는 것과 같다.
			
		} catch (Exception e) {
		
		}finally {
			// - PrintStream은 close()가 없으면 작업이 미완성되었다고 판단하여 화면에 데이터를 출력하지 않는다.
			ps.close();
		}
	}
}
