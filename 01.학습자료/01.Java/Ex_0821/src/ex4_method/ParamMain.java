package ex4_method;

public class ParamMain {

	public static void main(String[] args) {
		//
		int [] arr = {1,2,3,4,5};
		//
		MyParam mp = new MyParam();
		mp.test(arr);		// �ε��� 4���� ���� 10���� �����Ͽ� ���
		
		System.out.println("main�� arr");
		
		// ������ �ٸ��� �ּ� ���� ���ڰ� ����Ǿ����Ƿ� ���� ����Ǿ���.
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
