package ex2_enums;

public class Ex2_enums_member {
	public static void main(String[] args) {
		// [참고] 열거형 상수의 멤버 사용
		System.out.println("BUS 기본 요금 : " + Transportation.BUS.getBasicFare());
		System.out.println("BUS 1KM 거리 요금 : " + Transportation.BUS.fare(100));
	}
}

// 열거형 상수 (멤버 추가)
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
	// 기본 요금 조회
	public int getBasicFare() {
		return BASIC_FARE;
	}
	// 추상 메소드
	// - 거리에 따라서, 운송방식에따라 요금을 계산하는 방식이 다르므로 추상 메소드를 사용하여
	// - 각 운송수단마다 각각 메소드로 정의
	abstract int fare(int distance);
}