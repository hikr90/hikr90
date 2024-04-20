package ex2_output;

import java.io.PrintStream;

public class Ex1_Output {
	public static void main(String[] args) {
		
		/*아래의 식은 syso의 원본 코드로서 굳이 이렇게 사용하지는 않는다.*/
		
		// PrintStream은 아웃풋스트림의 대표적인 자식클래스로써, 화면(콘솔창)에 데이터를 출력하도록하는 클래스
		PrintStream ps = null;
		
		try {
			// system in 값을 받음, out 콘솔창으로 값을 띄움
			ps = System.out;
			ps.write(65);
			ps.write('B');
			
			// 완전히 종료되어서 더이상 출력할 것이 없다는 것을 확정해야한다.
			// 파일이 열려있는 엑셀을 삭제할 수 없는 것과 같다.
			
			
		} catch (Exception e) {

			
		
		
		}finally {
			// PrintStream은 close()가 없으면 작업이 미완성되었다고 판단하여 화면에 데이터를 출력하지 않는다.
			ps.close();
		}
		
		
		
		
		
		
		
	}
}
