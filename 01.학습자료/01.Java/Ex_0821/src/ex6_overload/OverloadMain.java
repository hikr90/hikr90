package ex6_overload;

public class OverloadMain {
	public static void main(String[] args) {
		
	Ex_Overload ov = new Ex_Overload();
	
	// ���� �޼��带 ȣ���ص� �Ķ������ ���ο����� �ٸ� ������� ���´�. 
	ov.result();
	ov.result(20);
	ov.result('A');
	// �Ķ���͸� �޴� ������ ��ġ�ؾ��Ѵ�. 
	ov.result("dd",10);
	ov.result(10,"dd");
	
	// syso�� �����ε��� ����ؼ� ������� �޼����̴�.
	System.out.println();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
