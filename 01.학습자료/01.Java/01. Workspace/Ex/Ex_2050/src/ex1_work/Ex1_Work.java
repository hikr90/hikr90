package ex1_work;

public class Ex1_Work {
	public static void main(String[] args) {
		// ���ǻ���
		// - try catch�� �������� ���忡�� ���� �����ϳ� ������ ����� ���ǿ��� ����Ѵ�.
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
