package ex5_variable_arguments;

public class VA_test {
	
	/*	variable argument 
	 * 	- �Ķ���͸� �迭 ���·� �޴� ��� ����Ѵ�.
	 *		- �Ķ���Ϳ� ... �� ����ϴ� ���, �ش� ���ڰ� �迭�� ������ �ȴ�.
	 */
	// �迭 {1,2,3,4,5} ���� ���� int ������ �迭
	public void test(int... n) {
		//
		for(int i=0;i<n.length;i++) {
			System.out.println(n[i]);
		}
	}
}
