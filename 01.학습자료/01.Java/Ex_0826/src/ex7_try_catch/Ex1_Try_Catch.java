package ex7_try_catch;

public class Ex1_Try_Catch {
	
	public static void main(String[] args) {
		
		/* ����, ����, ����ó��
		 * 		(1) ����
		 * 			- �޸� ����, ���� �����÷ο� ���� �ý��� (�ϵ���� Ȥ�� jvm) ���� �߻��ϴ� �ɰ��� ����
		 * 			- ���α׷��� ������ ����Ǵ� �ɰ��� ������ �����̴�.
		 * 			- �����ڰ� ������ �� ����, �߻� �� �ﰢ ��ó�� ��ƴ�.
		 * 
		 * 		(2) ����
		 * 			- ���ܴ� ������ ���־ȿ� ���Ѵ�.
		 * 			- ��κ� �����ڰ� �ۼ��� �ڵ忡�� �����ȴ�.
		 * 			- �����ڰ� ���� �����ϰ� �̸� ��� �����Ͽ� ����ó���� ���� ���� �۾��� �䱸�ȴ�.
		 * 
		 * 			(2.1) ������ ����
		 * 				(2.1.1) �Ϲ� ���� (Checked Exception)
		 * 					- ������ �ܰ迡�� �����Ǵ� ���ܸ� ���Ѵ�.
		 * 					- Runtime Exception�� ������ ��� �����̴�. 
		 * 						
		 * 						- DataFormat Exception 				: 		������ ������ ���� ����
		 * 						- SQLException 								: 		SQL ���� ���� (�������� ����, ���̺� ��Ī ���� ��)
		 * 						- IOException 								: 		����� ���� ����
		 * 						- EOFException 							: 		���� ������ �� �κп� ���� �� ����ó���� ���� ���
		 * 						- FileNotFoundException 				:		������ �߰����� ����
		 * 						- InterruptedIOException 				:		����� ó�� ���� ����
		 * 						- InvalidClassException 					: 		����ȭ ���� ����
		 * 						- NotSerializableException 			: 		������Ʈ ����ȭ ����
		 * 						- UnsupportedEncodingException : 		���ڵ� ���� ������ ����
		 *  
		 * 				(2.1.2) ���� ���� (Unchecked Exception)
		 * 					- Runtime Exception �̶�� �θ���.
		 * 					- ������ ��ÿ��� �������� ���ϳ�, ���� ���� �߿� ������ �߻��ϴ� �����̴�.
		 * 					
		 * 						- NullPointerException 							: 		Null ���� �����ϴ� ����
		 * 						- ArithmeticException 							: 		�߸��� ��� (0���� ����)
		 * 						- ArrayIndexOutOfBoundsException 		: 		�迭 �ε��� ���� (�ε����� �������� ����)
		 * 						- ArrayStoreException 							: 		�迭�� �߸��� �ڷ��� ����
		 * 						- NegativeArraySizeException 				: 		�迭�� �ε����� ���̳ʽ�
		 * 						- IllegalThreadStateException 				: 		�̹� ���۵� �����带 �ٽ� ����
		 * 						- NumberFormatException 					: 		���� ��ȯ �� �������� �ڷ��� ���
		 * 						- IllegalStateException 							: 		��ü���� �޼ҵ带 �߸��� ������� ȣ��
		 * 						- UnsupportedOperationException	 	: 		�������� �ʴ� �޼ҵ� ȣ��
		 * 
		 * 				[����] �Ѵ� try-catch ����ó���� ���ؼ� ��Ƴ� �� �ִ�.
		 * 
		 * 		(3) ����ó��
		 * 			- �����ڰ� ���� ������ ������ ���ܸ� ���α׷��� ���� ���� �����ϱ����ؼ� �ǵ������� ó���ϴ� �۾��� ���Ѵ�.
		 * 			- ����ó���� ���������� ���Ḧ ���̴µ� ������ �ִ�.
		 */
		
		/*	try-catch
		 * 	- ����ó��
		 * 	- ���� ������ ������ �߻��� ��츦 ����Ͽ� �����ڰ� �ǵ��Ѵ�� ó���ϴ� ���� ����
		 * 	- try �������� ������ �߻��� ��� catch �������� �Ѿ�� catch �� ������ ����ȴ�.
		 * 	- ���� try �������� ������ �߻����� ������ catch �������� �������� �ʴ´�.
		 * 	- try ������ �����Ǵ� ������ ���� �����μ� �ܺο��� ����ϰ����ϴ� ��� �ܺο��� ���� ������ �����ؾ��Ѵ�.
		 * 
		 * 	-�⺻���� try-catch�������� catch �Ķ������ �ϳ��� ���� Ŭ������ ó�� �����ϹǷ� ���� ������ �θ� Ŭ������ exceptionŬ������ ����Ѵ�.
		 * 
		 * 	try {
		 * 			// �ڵ� ����
		 * 
		 * 	} catch (Exception e) {
		 * 		// ���� �߻� �� ó���� �۾�
		 * 	}
		 * 
		 */
		int n = 0;
		int result = 0;
		int [] arr = {1,2,3,4};
		//
		try {
			//
			result = 10 / n;				// ������ 0���� �������� ���� (ArithmeticException)
			arr [3] = 4;					// �迭�� �ε����� �������� �ʴ� ���� (ArrayIndexOutOfBoundsException)
		
		} catch(ArithmeticException e) {
			// ���� �߻��� ������ ��Ī�� ���
			e.printStackTrace();
			// �����ڰ� �ǵ������� ó���ϴ� ����
			System.out.println("0���δ� ���� �� �����ϴ�.");
			result = -1;
		} catch(ArrayIndexOutOfBoundsException e) {
			// �����ڰ� �ǵ������� ó���ϴ� ����
			System.out.println("�迭�� �������� �ʴ� �ε����� ������");
			
		} finally {
			// finally�� ������ ������� �ݵ�� �����ϴ� �����̴�.
			System.out.println("finally");
		}
		//
		System.out.println(result);
	}
}
