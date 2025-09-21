package ex3_overload;

public class Ex2_Varargs {
	public static void main(String[] args) {
		/*	��������
		 * 		- �޼ҵ� �� �������� �Ű������� �����ϴ� ���
		 * 		- Ÿ��... �������� �������� �����ϸ� printf�� ��ǥ���� �����̴�.
		 * 		- ���� �������� �ܿ� �Ű������� �� �ִ� ��� �������ڸ� ���� �������� ��������� �����Ϸ��� ����� �о �� �ִ�.
		 * 
		 * 			public PrintStream printf(String format, Object... args) {...}
		 * 
		 *		[����] ���������� ���� ����� �迭 �����̴�.
		 *			- �������ڴ� ���������� �迭�� �̿��Ѵ�.
		 *			- �Ű������� Ÿ���� �迭�� �� ��� �ݵ�� ���ڸ� ����������ϹǷ� ���ڸ� �������� ���ϰ� �ݵ�� null�̳� 0���� �ۼ��ؾ� �Ѵ�.
		 *			
		 *				String concatenate(new String[]{"A", "B"});
		 */
		
		// [����] �������ڸ� �޴� �޼ҵ忡�� �����ε��� ���� �ʴ� ���� ����.
		String [] strArr = {"100", "200", "300"};
		
		System.out.println(concatenate("", "100", "200", "300"));
		System.out.println(concatenate("-", strArr));
		System.out.println(concatenate(",", new String[] {"1", "2", "3"}));
		System.out.println("[" + concatenate(",", new String[0]) + "]");
		System.out.println("[" + concatenate(",") + "]");
	}
	
	//
	static String concatenate(String delim, String... args) {
		String result = "";
		
		for(String str : args) {
			result += str + delim;
		}
		
		return result;
	}
	
	// [����] �������� �޼ҵ尡 �����ε����� ���, �����Ϸ��� �� �޼ҵ带 �������� ���Ѵ�.
	/* static String concatenate(String... args) {
		return concatenate("", args);
	}*/
}
