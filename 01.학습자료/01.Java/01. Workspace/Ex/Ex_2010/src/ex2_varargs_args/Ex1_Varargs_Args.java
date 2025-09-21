package ex2_varargs_args;

public class Ex1_Varargs_Args {
	
	/*	variable argument 
	 * 		- �Ķ���͸� �迭 ���·� �޴� ��� ����Ѵ�.
	 *		- �Ķ���Ϳ� ... �� ����ϴ� ���, �ش� ���ڰ� �迭�� ������ �ȴ�.
	 */
	
	// �迭 {1,2,3,4,5} ���� ���� int ������ �迭
	public void test(int... n) {
		//
		for(int i=0;i<n.length;i++) {
			System.out.println(n[i]);
		}
	}
	
	//
	public static void main(String[] args) {
		// Ŭ���� ����
		Ex1_Varargs_Args va = new Ex1_Varargs_Args();
		va.test(1,2,3,4,5);
	}
}
