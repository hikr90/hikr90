package ex2_thread_type;

public class Ex1_Single_Thread {
	public static void main(String[] args) {
		/*	�̱� ������ & ��Ƽ ������
		 * 	- ���α׷� ȯ�濡�� �׻� ��Ƽ �����尡 ����, �ӵ� ���鿡�� �پ ���� �ƴϴ�.
		 * 	- �ΰ��� �۾��� �ϳ��� �����ư��� ó���ϴ� ��� (�̱�)�� �ΰ��� ������� ó�� (��Ƽ) �ϴ� ��쿡�� �� �۾��� �ӵ��� ���� ����ϴ�.
		 * 	- ������ ������ ���� �۾� ��ȯ���� ���ؼ� ��Ƽ �����尡 �ð��� �� �ҿ�ȴ�.
		 * 			
		 * 		[����] ���ؽ�Ʈ ����Ī
		 * 			- ������ ���� �۾� ��ȯ
		 * 			- ������ ������ ��ġ (PC, ���α׷� ī���� ��) ���� ������ ����
		 * 
		 * 		[����] � ��Ȳ���� ��Ƽ �����尡 �� ȿ�����ΰ�?
		 * 			- �����尡 ���� �ٸ� �ڿ��� �ٶ󺸴� ���
		 * 			- (���� ���� ��, �ٸ� �۾��� ��ٸ��� �ʵ���...)
		 */
		
		// �̱� ������
		Long stm = System.currentTimeMillis();
		
		for(int i=0;i<300;i++) {
			System.out.printf("%s : ", new String("-"));
		}
		System.out.println();
		System.out.println("�ҿ� �ð�1 : " + (System.currentTimeMillis() - stm));
		
		for(int i=0;i<300;i++) {
			System.out.printf("%s : ", new String("|"));
		}
		System.out.println();
		System.out.println("�ҿ� �ð�2 : " + (System.currentTimeMillis() - stm));
	}
}