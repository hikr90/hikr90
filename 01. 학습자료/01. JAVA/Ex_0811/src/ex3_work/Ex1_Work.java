package ex3_work;

/*	����
	�������� �ִ�.
	��, ���, �������� Ű��� �ִµ�, �Ϸ� ���귮�� ���� 
	5��, 7��, 5���̴�. 
	
	���������� �Ϸ翡 ����Ǵ� ������ �� ������ ����ϰ�, �ð��� ��ü ������ ��� ���귮�� ����϶�
	
	��, ������ ������ �Ϸ� ���귮�� ������ ������ intŸ������ 
	��� ���귮�� ������ ������ floatŸ������ �����ϵ��� �Ѵ�.
	
*/

public class Ex1_Work {
	public static void main(String[] args) {
	
		int peer = 5;
		int apple = 7;
		int orange = 5;
		
		int total = peer+apple+orange;
		// Ȥ�� float f = total/24.0f �� ������ε� �����ϴ�.
		float f = (float)(total)/24;
		
		System.out.printf("�Ϸ� ������ �� ���귮 : %d��\n",total);
		System.out.printf("�ð��� ��ü ������ ��� ���귮 : %.2f��\n",f);
		
		
		
		
	}
}
