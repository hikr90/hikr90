package ex4_method;

public class MyParam {

	public void test(int [] arr) {
		
		// - �迭�� 4�� �ε����� ���� 10���� ����
		// - �⺻ �ڷ��������� ���� ���� �Ѱ��ְ�, New�� ����ϴ� �ڷ��� (�迭) Ȥ�� String�� �ּ� ���� �ѱ�Ƿ� ���� ����ȴ�.
		arr[4] = 10;
		System.out.println("test�޼����� arr");
		//
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
