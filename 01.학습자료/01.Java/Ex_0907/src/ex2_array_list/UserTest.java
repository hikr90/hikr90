package ex2_array_list;

import java.util.ArrayList;

// 장점 : 여러가지 타입의 데이터를 객체로서 함께 저장할 수 있다.

public class UserTest {
	public static void main(String[] args) {
		
		ArrayList<User> arr = new ArrayList<User>();
		
		// user 객체 생성
		User u = new User();
		
		// 힙 영역에 두가지 유저와 어레이리스트 영역이 생성
		// 유저 객체에 이름과 나이를 입력한 뒤, 어레이 리스트에
		// 주소를 넘기는 구조
		u.setAge(20);
		u.setName("홍길동");
		
		// 유저 추가
		User u2 = new User();
		u2.setAge(30);
		u2.setName("김길동");
		
		
		
		// user 객체만 파라미터로 들어갈 수 있다.
		arr.add(u);
		arr.add(u2);
		
		// arr에 담긴 user객체의 정보를 출력
		for(int i=0;i<arr.size();i++) {
			
			// 어레이리스트 영역에는 주소값만 들어있기 때문에 주소값이 나온다.
			// System.out.println(arr.get(i));
			System.out.println(arr.get(i).getName());
			System.out.println(arr.get(i).getAge());
			System.out.println("-----------------------");
		}
		
		
		
		
		
		
		
		
	}
}
