package ex5_anonymous;
// �͸�Ŭ����

import java.util.Random;
import java.util.Scanner;

public class Ex1_Anony {
	
	public static void main(String[] args) {
		
	
	// ��Ȱ�� ���� (sc�� ��Ƽ� �ٸ� ���� �����ϰ� �ٽ� ��� �� ����)
	// ����, �ѹ� ����ϰ� ������� �ʾƵ� �޸𸮰� ��� ����
	Scanner sc = new Scanner(System.in);
	int num = sc.nextInt();
	
	// ��ĳ���� �͸�Ŭ����
	// int a = new Scanner(system.in).nextInt();
	
	
	// ��Ȱ�� �Ұ��� 
	// int rnd = new Random().nextInt(10)+1;
	// rnd = new Random().nextInt(10)+1;
	
	// �̸��� �ִ� ��ü�� �̸��� ���� ��ü 
	// ��ĳ�ʴ� sc��� �̸��� �����Ͽ� �ű⿡ ������ �����ϳ�
	// ������ �̸��� ��� �ʿ��� ������ ����ؼ� new�� �������Ѵ�. 

	// Ŭ������ �̸� ����
	Random random = new Random(); 
	int rnd = random.nextInt(10)+1; 
	
	// �͸�Ŭ������ Ư¡
	// �ѹ������� �������� ���� �̸��� ���� �͸�Ŭ������ ����
	// (���α׷��� x ���� ��ư)
	// ���������� ���Ǵ� ���̶�� �̸��� �ִ� Ŭ������ �ϴ� ���� ����.



	}
}
