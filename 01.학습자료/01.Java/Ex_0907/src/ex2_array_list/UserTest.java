package ex2_array_list;

import java.util.ArrayList;

public class UserTest {
	public static void main(String[] args) {
		//
		ArrayList<User> arr = new ArrayList<User>();
		
		// User 객체 생성
		User u = new User();
		
		// - list 생성 시, heap 영역에 User와 arrayList 영역이 생성된다.
		// - arrayList에는 주소 값이, User에는 저장된 데이터 값이 존재한다.
		u.setAge(20);
		u.setName("홍길동");
		
		// User 객체 추가
		User u2 = new User();
		u2.setAge(30);
		u2.setName("김길동");
		
		// - User 객체만 파라미터로 들어갈 수 있다.
		arr.add(u);
		arr.add(u2);
		
		// arrayList에 있는 User 객체를 반복문으로 확인
		for(int i=0;i<arr.size();i++) {
			//
			System.out.println(arr.get(i)); // arrayList를 확인 시 주소 값만 조회된다.
			//
			System.out.println("-----------------------");
			System.out.println(arr.get(i).getName());
			System.out.println(arr.get(i).getAge());
			System.out.println("-----------------------");
		}
	}
}
