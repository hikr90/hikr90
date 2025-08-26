package ex2_enums;

public class Ex2_enums_member {
	public static void main(String[] args) {
		// [����] ������ ����� ��� ���
		System.out.println("BUS �⺻ ��� : " + Transportation.BUS.getBasicFare());
		System.out.println("BUS 1KM �Ÿ� ��� : " + Transportation.BUS.fare(100));
	}
}

// ������ ��� (��� �߰�)
enum Transportation {
	BUS (100) {
		@Override
		int fare(int distance) {
			return distance * BASIC_FARE;
		}
	}, TRAIN(150) {
		@Override
		int fare(int distance) {
			return distance * BASIC_FARE;
		}
	}, SHIP(200) {
		@Override
		int fare(int distance) {
			return distance * BASIC_FARE;
		}
	}, AIRPLANE(300) {
		@Override
		int fare(int distance) {
			return distance * BASIC_FARE;
		}
	};
	//
	protected final int BASIC_FARE;
	//
	Transportation(int baseFare) {
		BASIC_FARE = baseFare;
	}
	// �⺻ ��� ��ȸ
	public int getBasicFare() {
		return BASIC_FARE;
	}
	// �߻� �޼ҵ�
	// - �Ÿ��� ����, ��۹�Ŀ����� ����� ����ϴ� ����� �ٸ��Ƿ� �߻� �޼ҵ带 ����Ͽ�
	// - �� ��ۼ��ܸ��� ���� �޼ҵ�� ����
	abstract int fare(int distance);
}