package ex4_method;

public class MyParam {

	public void test(int [] arr) {
		
		// arr�̶�� �迭�� ���� ��, 4�� �ִ� 5�� 10���� ����
		// �⺻ �ڷ��������� ���簪�� �Ѱ��ְ� new�� ����ϴ�
		// heap������ ����ϴ� �ڷ���(�迭)�� �ּҰ��� �ѱ��.
		
		arr[4] = 10;
		System.out.println("test�޼����� arr");
		
		for(int i=0;i<arr.length;i++) {
			
			System.out.println(arr[i]);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
