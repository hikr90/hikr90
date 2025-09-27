package ex3_system;

public class Ex2_System_Set {
	public static void main(String[] args) {
		/*	표준입출력의 대상 변경
		 * 		(1) static void setOut(PrintStream out)
		 * 			- System.out의 출력을 지정된 PrintStream으로 변경
		 * 
		 * 		(2) static void setErr(PrintStream err)
		 * 			- System.err의 출력을 지정한 PrintStream으로 변경
		 * 
		 * 		(3) static void setIn(InputStream in)
		 * 			- System.in의 입력을 지정한 InputStream으로 변경
		 */
		System.out.println("out : Hello World!");
		System.err.println("err : Hello World!");
	}
}
