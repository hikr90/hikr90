package ex1_control_statement;

public class Ex3_else_if {

	public static void main(String[] args) {
		
		// else if
		// - ���� ���� �� �´� ������ ���� ã�Ƴ��� �б⹮
		// - ���� if���̶�� �θ��� ���� ���� �񱳰� �ʿ��� ��� ����ϴ� �б⹮
		// - ������ ������ ��� �ش� ������ �ѱ��, ���� ��� �� ������ �ڵ带 �������� �ʰ� �״�� �б⹮�� �����Ѵ�.
		int num = 67;
		String str = "";
		
		if(num>=90) {
			str = "A";
		} else if(num>=80) {
			str = "B";			
		} else if(num>=70) {
			str = "C";			
		} else if(num>=60) {
			str = "D";
		} else {
			str = "F";
		}
		
		System.out.printf("����� ������ %s�Դϴ�.",str);
		
	}
}
