package ex1_try_catch;

public class Ex1_Try_Catch {
	public static void main(String[] args) {
		// ���ǻ���
		// - try-catch�� �������� ���忡�� ���� �����ϳ� ������ ����� ���ǿ��� ����Ѵ�.
		// - �ܼ��� �������� �Ǽ��� �������� �뵵�� ����ؼ��� �ȵȴ�.
		int [] var = {10,20,30};
		
		for (int i=0;i<=var.length;i++) {
			//
			try {
					System.out.println(var[i]);
		
			} catch(Exception e) {
			
			}
		}
		//
		System.out.println("���α׷� ����");
	}
}
