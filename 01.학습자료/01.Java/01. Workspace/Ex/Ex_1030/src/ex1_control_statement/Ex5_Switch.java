package ex1_control_statement;

public class Ex5_Switch {
	public static void main(String[] args) {
		//
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
		
		// 예, 상황에따라 break 가 없어야하는 경우
		//  break가 없는 경우 level의 값에따라서 하위 조건이 전부 수행되고 종료된다.
		int level = 3;
		switch (level) {
			case 3 :
				System.out.println("삭제 권한 부여");
			case 2 :
				System.out.println("수정 권한 부여");
			case 1 :
				System.out.println("등록 권한 부여");
		}
	}
}
