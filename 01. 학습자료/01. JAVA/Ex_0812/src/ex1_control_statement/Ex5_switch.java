package ex1_control_statement;

public class Ex5_switch {
	public static void main(String[] args) {
		
		String str = "A";
		
		// ���� break�� ���ٸ� "A"�� ã�Ƶ� B���� �������Եȴ�.
		switch (str) {
		case "A" :
				System.out.println("100 ~ 90");
			break;
			
		case "B" :
			System.out.println("80 ~ 90");
			break;

		case "C" :
			System.out.println("70 ~ 80");
			break;

		case "D" :
			System.out.println("60 ~ 70");
			break;

		case "F" :
			System.out.println("50�� �̸�");
			break;
			
		default:
			System.out.println("��Ȯ�� ��������� �־��ּ���.");
			break;
		}
	}
}
