package ex1_control_statement;

public class Ex5_switch {
	public static void main(String[] args) {
		
		String str = "A";
		
		// 만약 break가 없다면 "A"를 찾아도 B까지 내려가게된다.
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
			System.out.println("50점 미만");
			break;
			
		default:
			System.out.println("정확한 학점등급을 넣어주세요.");
			break;
		}
	}
}
