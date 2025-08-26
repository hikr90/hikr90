package ex2_enums;

public class Ex1_enums {
	public static void main(String[] args) {
		/*	열거형
		 * 		- 서로 관련된 상수를 편리하게 선언하기 위한 방식
		 * 		- 상수의 경우, 해당 상수의 값이 변경되면 해당 상수를 참조하는 모든 소스를 재 컴파일 해야 하지만, 열거형 상수의 경우 기존의 소스를 재 컴파일 할 필요가 없다.
		 */
		Unit unit = new Unit();
		unit.init();
		
		// valueOf 는 지정된 열거형 상수에서 name과 일치하는 열거형 상수를 반환한다.
		Direction d1 = Enum.valueOf(Direction.class, "WEST");
		System.out.println(Direction.WEST == d1);
		
		// compareTo 비교
		Direction d2 = Direction.NORTH;
		System.out.println(d1.compareTo(d2));
		
		// ordinal은 열거형 상수가 정의된 순서를 반환한다.
		System.out.println(d1.ordinal());
	}
}

// 열거형 상수
enum Direction { EAST, SOUTH, WEST, NORTH };

// 타 클래스에서 사용
class Unit {
	int x, y;
	Direction dir;
	
	void init () {
		dir = Direction.EAST;
		
		// 열거형 상수의 비교
		if(dir == Direction.EAST) {
			// 열거형 상수의 경우 == 로 비교 가능하다.
			// 단, < 이나 > 는 사용 할 수 없으며 compareTo() 는 사용 가능하다.
			System.out.println("열거형 상수는 ==로 비교 가능하다.");
		}
	}
}

