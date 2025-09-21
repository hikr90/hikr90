package ex2_printf;

public class Ex1_Printf {

	public static void main(String[] args) {
		
		// println : ��� ��, ������ ���� ��¹��
		int age = 21;
		System.out.println("�� ���̴� "+age+"�� �Դϴ�.");
		
		// printf(����) : ������ Ÿ�Կ����� ����� ������ ���
		// \n : ���� ����
		// ������ ����
		// %d : ����
		// %c : ����
		// %f : �Ǽ�
		// %s : ���ڿ�
		System.out.printf("�� ���̴� %d�� �Դϴ�.\n",age);
		
		int year = 2000;
		int month = 10;
		int day = 9;
		
		// 2000-10-9
		System.out.printf("%d-%d-%d\n",year,month,day);
		
		// ���� 21�� A���Դϴ�.
		char bt = 'A';
		float co = 36.5f;
		System.out.printf("���� %d�� %c�� �Դϴ�. ü���� %.1f�� �Դϴ�.\n",age,bt,co);
		
		// %d�� ��� 02 : �տ� 0�� �ٿ��� ���ڸ� / 03 : ���ڸ�
		// 02�κп� ���ڸ��� �� ���, ���ڸ��� ���´�.
		System.out.printf("%d-%02d-%03d\n",9,10,9);
		// %f�� ���, �Ҽ����ڸ������� ������ �����ϴ�.
		System.out.printf("%f, %.2f, %.3f",co,co,co);
		
		// %o : ���� (8����)
		// %x :  ���� (16����)
	}

}
