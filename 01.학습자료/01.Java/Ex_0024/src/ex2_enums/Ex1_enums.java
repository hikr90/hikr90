package ex2_enums;

public class Ex1_enums {
	public static void main(String[] args) {
		/*	������
		 * 		- ���� ���õ� ����� ���ϰ� �����ϱ� ���� ���
		 * 		- ����� ���, �ش� ����� ���� ����Ǹ� �ش� ����� �����ϴ� ��� �ҽ��� �� ������ �ؾ� ������, ������ ����� ��� ������ �ҽ��� �� ������ �� �ʿ䰡 ����.
		 */
		Unit unit = new Unit();
		unit.init();
		
		// valueOf �� ������ ������ ������� name�� ��ġ�ϴ� ������ ����� ��ȯ�Ѵ�.
		Direction d1 = Enum.valueOf(Direction.class, "WEST");
		System.out.println(Direction.WEST == d1);
		
		// compareTo ��
		Direction d2 = Direction.NORTH;
		System.out.println(d1.compareTo(d2));
		
		// ordinal�� ������ ����� ���ǵ� ������ ��ȯ�Ѵ�.
		System.out.println(d1.ordinal());
	}
}

// ������ ���
enum Direction { EAST, SOUTH, WEST, NORTH };

// Ÿ Ŭ�������� ���
class Unit {
	int x, y;
	Direction dir;
	
	void init () {
		dir = Direction.EAST;
		
		// ������ ����� ��
		if(dir == Direction.EAST) {
			// ������ ����� ��� == �� �� �����ϴ�.
			// ��, < �̳� > �� ��� �� �� ������ compareTo() �� ��� �����ϴ�.
			System.out.println("������ ����� ==�� �� �����ϴ�.");
		}
	}
}

