package ex4_method;

public class ParamMain {

	public static void main(String[] args) {
		
		int [] arr = {1,2,3,4,5};
		
		MyParam mp = new MyParam();
		mp.test(arr);
		
		System.out.println("main�� arr");
		// �ٽ� 4������ ���
		// ���⼭�� ������� ���ñ�?
		// 10���� ���´�.
		for(int i=0;i<arr.length;i++) {
			
			System.out.println(arr[i]);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
