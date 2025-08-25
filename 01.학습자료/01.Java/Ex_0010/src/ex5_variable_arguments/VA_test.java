package ex5_variable_arguments;

public class VA_test {
	
	/*	variable argument 
	 * 	- 파라미터를 배열 형태로 받는 경우 사용한다.
	 *		- 파라미터에 ... 를 사용하는 경우, 해당 숫자가 배열로 들어오게 된다.
	 */
	// 배열 {1,2,3,4,5} 값이 들어가는 int 형태의 배열
	public void test(int... n) {
		//
		for(int i=0;i<n.length;i++) {
			System.out.println(n[i]);
		}
	}
}
