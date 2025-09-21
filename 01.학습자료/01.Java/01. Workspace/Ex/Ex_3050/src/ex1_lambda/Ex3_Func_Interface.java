package ex1_lambda;

// (1), (2) public abstract void run(); 
@FunctionalInterface
interface myFunction {
	void run();
}

public class Ex3_Func_Interface {
	// (4) �Ű������� Ÿ���� �������� (myFunction) �� �޼ҵ�
	// 	- ���ٽ��� ���������� ���� �� �ִٴ� ���� �޼ҵ带 ���ؼ� ���ٽ��� �ְ���� �� �ִٴ� ���� ���Ѵ�.
	static void execute(myFunction f) {
		f.run();
	}
	
	// (3) ��ȯ Ÿ���� �������� (myFunctoin)�� �޼ҵ�
	static myFunction getFunction() {
		myFunction f = () -> System.out.println("f3.run()");
		return f;
	}
	
	public static void main(String[] args) {
		/* �Լ��� �������̽�
		 * 		- ���ٽ��� �͸� Ŭ������ ��ü�� �����ϴ�.
		 * 		- �͸� Ŭ������ ���������� �־�� ��ü�� �޼ҵ带 ȣ���� �� �ִ�.
		 * 		- ���������� Ŭ������ �������̽��� �ش�ȴ�.
		 * 
		 * 		[����] ���ٽ��� �͸�ü�� ��ü ������ ����
		 * 			(1) ���ٽ��� ������ �͸� ��ü�̱⵵ �ϰ�
		 * 			(2) myFunction �������̽��� ������ �͸� ��ü�� �޼ҵ� max�� ���ٽ��� �Ű�����, Ÿ��, ������ ��ġ�ϹǷ�
		 */
		
		// (1) ���ٽ����� fun1�� run ����
		myFunction f1 = () -> System.out.println("f1.run()");
	
		// (2) �͸�Ŭ������ fun1�� run ����
		myFunction f2 = new myFunction() {
			
			@Override
			public void run() {
				System.out.println("f2.run()");
			}
		};
				
		// (3) ���ٽ��� ��ȯ�ϴ� �޼ҵ� ����
		myFunction f3 = getFunction();
		
		f1.run();
		f2.run();
		f3.run();
		System.out.println("-----------------------");
		
		// (4) ���ٽ��� �Ķ���ͷ� �޴� �޼ҵ�
		execute(f1);											// f1�� ���ٽ��̹Ƿ� �Ķ���ͷ� ��� ����
		execute(() -> System.out.println("f4.run()"));			// ���ٽ� ��ü�� �Ķ���ͷ� ��� ����
	}
}