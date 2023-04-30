package ex1_array_list;

import java.util.ArrayList;

public class Ex1_ArrayList {
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(100);
		list.add(200);
		list.add(300);
		
		System.out.println(list.size());
		
		// 300을 몇번방에 있는지 확인
		int res = list.get(2);
		System.out.println(res);
		
		System.out.println("----------------");
		
		// ArrayList에서 400이라는 값을 1번 인덱스에 추가하는 방법
		// 중간에 1번방이라는 새로운 방이 생기면서 기존에 연결된 1번방으로 가는 주소가
		// 새로운 1번방에 연결된다. 그와 동시에 인덱스가 하나씩 뒤로 밀리게된다.
		// 즉 끼워넣는 방식으로 값을 추가한다.
		list.add(1, 400);	
		System.out.println(list);
		
		
		// 끼워넣지 않고 값만 바꾸는 방법
		list.set(2, 500);
		list.add(600); // 인덱스 번호 없이 값을 add하면 맨 뒤에 추가된다.
		System.out.println(list);

		// ArrayList 의 2번 index의 값을 삭제
		// 1번방과 3번방의 주소를 이은 다음, 2번방이 삭제되고 2번방에 연결된 주소라인이 삭제되면서 3번방의 인덱스가 2번방으로 변경된다.
		// 값이 빠지거나 추가되더라도 인덱스에 공백이 생기지는 않는다.
		list.remove(2);
		
		// ArrayList안에 담긴 값을 for문을 통해서 출력
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
		
		
		
	}
}
