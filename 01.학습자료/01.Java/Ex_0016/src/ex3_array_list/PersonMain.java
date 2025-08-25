package ex3_array_list;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonMain {
	public static void main(String[] args) {
		// 문제
		// - 키보드 값에서 id 와 pw 값을 받아서 arrayList 클래스 타입을 이용하여 아이디와 패스워드를 저장하는 결과를 만드세요.
		// - 결과
		// - id : aaa
		// - pw : 111
		// - aaa / 111
		
		// - id : bbb
		// - pw : 222
		
		// - aaa / 111
		// - bbb / 222
		
		// - id : aaa
		// - pw : 111
		// - 중복된 아이디입니다.
		// 조회와 동시에 while문 정지 혹은 다시 id를 입력하는 상태로 돌아가는 로직을 생성하세요.
		Scanner sc = new Scanner(System.in);
		ArrayList<Person> arr = new ArrayList<>();
		//
		outer : while(true) {
			// 설명
			// - add 를 통해서, arrayList의 사이즈는 늘어나지만 참조하고있는 p 객체의 값은 변경되었기에
			// - 주소 값을 참조하여 값이 계속 갱신된다.

			// - 객체 생성을 while문에 넣게되면
			// - while문에 진입할 때마다 Person 클래스가 계속해서 객체화를 하게된다.
			// - 동일한 명칭은 p로 생성하므로 기존의 클래스는 계속 초기화된다.
			// - 중복되지 않은 값은 arrayList에 저장되므로 그 값을 통해서 계속 중복 조회가 가능하다.
			Person p = new Person();
			//
			System.out.println("id : ");
			p.setId(sc.next());
			//
			System.out.println("pwd : ");
			p.setPwd(sc.nextInt());
						
			// 중복체크
			for(int i=0;i<arr.size();i++) {
				//
				if(p.getId().equalsIgnoreCase(arr.get(i).getId())) {
					System.out.println("중복된 아이디입니다.");
					continue outer;
				}
			}
			//
			arr.add(p);
			//
			for(int i=0;i<arr.size();i++) {
				System.out.printf("%s / %d\n",arr.get(i).getId(),arr.get(i).getPwd());
			}
		}	// while
	} // main
}
