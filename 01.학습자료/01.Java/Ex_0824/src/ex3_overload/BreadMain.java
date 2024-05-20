package ex3_overload;

public class BreadMain {
	
	public static void main(String[] args) {
		
		// 숙제
		// - 첫번째 메소드 호출 : 빵을 만들었습니다.
		
		// - 두번째 메소드 호출
		// - 빵을 만들었습니다.
		// - 빵을 만들었습니다.
		// - 요청하신 2개의 빵을 만들었습니다.
		
		// - 세번째 메소드 호출
		// - 크림빵을 만들었습니다.
		// - 크림빵을 만들었습니다.
		// - 크림빵을 만들었습니다.
		// - 요청하신 3개의 크림빵을 만들었습니다.
		Bread br = new Bread();
		br.makeBread();
		System.out.println("-------");
		br.makeBread(2);
		System.out.println("-------");
		br.makeBread(3,"크림빵");
	}
}
