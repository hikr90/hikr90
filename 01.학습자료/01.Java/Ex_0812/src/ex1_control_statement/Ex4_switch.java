package ex1_control_statement;

public class Ex4_switch {
	
	public static void main(String[] args) {

		/*	switch��
		 * 	- case���̶�� �θ���.
		 * 	- �� ���� ���� ���� ���ؼ� ����� �����ϴ� ���
		 * 	- ���ο� �ּ� 1�� �̻��� case�� �־���ϸ� case ���� ������ ������ �ߺ� ������ �Ұ����ϴ�.
		 * 	- switch �������� ���ǹ��� ���� �ʰ� ������ ����.
		 * 	- �� ���� ���� ���� �ݵ�� ���� �ڷ����̿��� �Ѵ�.
		 * 	- default ������ else ������ �����ϰ� �� ���� ���� ���� ��ġ���� ���� �� �����ϴ� �����̴�.
		 * 
		 * 	- �� ������ break�� �������� �ʴ� ��� ��ġ�ϴ� ������ �� ���� switch�� ������� �ʰ� ���� �� ���� ã�� �ȴ�.
		 * 	
		 * [����] else if �� case���� ����
		 * 	- else if�� ���������� ��ġ �� �� ���� ���ϴ� ����̸�
		 * 	- case�� �� ���� ã�Ƽ� �״�� ������ ������ �ӵ� ���鿡�� �� ������.
		 * 	- �� case�� ���ǹ��� ����� �� �����Ƿ� ������ ���� ���� �� �񱳰� �Ұ����ϴ�.
		 */
		int n = 3324;
		//
		switch(n) {
			case 1 :
				System.out.println("���� ����");
				break;
			
			case 2 :
				System.out.println("���� �Ұ�");
				break;
				
			case 3 :
				System.out.println("���� ����");
				break;
			
			default :
				System.out.println("�߸��� ���Դϴ�.");
				break;
		}
	}
}
