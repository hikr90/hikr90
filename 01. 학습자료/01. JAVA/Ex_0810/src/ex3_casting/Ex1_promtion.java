package ex3_casting;

public class Ex1_promtion {
	public static void main(String[] args) {
		// ĳ����(����ȯ)
		// 1. promotion casting : ū �ڷ����� ���� �ڷ����� �����ϴ� ��
		// ���θ�� ĳ������ �ڵ����� �����Ѵ�.
		double d = 100.5;
		int n = 200;
		
		// = �� �������� ���� �������� �����Ѵٴ� ���̴�.
		// double�� int���� ��������� �� Ŀ�� �Ʒ� ���� ������ ���� �ʴ´�.
		d = n;
		System.out.println("d : " + d);
		// ���� �ڷ����� ū �ڷ����� ���� ��, ���θ������ �ڵ����� �Ǳ���ϳ� c�� ���������� �ƽ�Ű�ڵ忡 ���ؼ� �������·� �� ��ȯ�� �ȴ�. 
		char c = 'A';
		int n2 = c + 1;		
		System.out.println("n2 : " + n2);
		
	}
}
