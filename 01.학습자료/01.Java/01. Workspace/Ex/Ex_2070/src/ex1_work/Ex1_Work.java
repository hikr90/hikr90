package ex1_work;

import java.util.ArrayList;

public class Ex1_Work {
	public static void main(String[] args) {
		
		/*		List
		 * 		- 순서(인덱스)가 있는 데이터의 집합
		 * 		- 배열의 사이즈가 고정되어있고 인덱스를 통해서, 특정 인덱스의 값 추가가 가능하다.
		 * 		- 객체 저장이 가능하여 여러 타입의 데이터를 보관할 수 있다.
		 * 		- 데이터의 중복을 허용한다.
		 * 
		 * 		list의 자식 클래스
		 * 			- arrayList
		 */
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(100);
		list.add(200);
		list.add(300);	// add를 통해서 값을 추가한다. (값은 뒤에 추가된다.)
		
		System.out.println(list.size());	// size는 list의 길이를 반환한다.
		
		int res = list.get(2);			// get으로 파라미터에 해당하는 인덱스의 값을 확인
		System.out.println(res);	// 300 값 확인
		
		System.out.println("----------------");
		
		// 특정 인덱스에 값 추가
		list.add(1, 400);				// add 함수에 인덱스를 추가하는 경우, 중간에 1번 인덱스가 추가되면서 뒤의 인덱스들이 하나씩 뒤로 밀리게 된다. (값을 끼워넣기)
		System.out.println(list);
		
		
		// 특정 인덱스의 값만 수정
		list.set(2, 500);
		list.add(600); 
		System.out.println(list);
		
		// 특정 인덱스를 삭제
		list.remove(2);	// remove 함수를 통해서 2번 인덱스를 제거, 인덱스가 제거되며 뒤의 인덱스 주소 값이 앞으로 하나씩 당겨진다.
		
		// 반복문을 통해서 출력
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
	}
}
