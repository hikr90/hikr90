package ex5_variable_arguments;

public class VA_test {
	
	// �Ķ������ �ڷ��� �ڿ� ...�� ������ variable argument�� �θ���.
	// ...�� ����ϴ� ��� �ش� ���ڰ� �迭�� �ٲ��.
	// 1~5���� ���� int���� �迭 n�� ����
	public void test(int... n) {
		
		for(int i=0;i<n.length;i++) {
			System.out.println(n[i]);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
