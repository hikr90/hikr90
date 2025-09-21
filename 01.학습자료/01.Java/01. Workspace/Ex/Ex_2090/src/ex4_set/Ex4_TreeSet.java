package ex4_set;

import java.util.Set;
import java.util.TreeSet;

public class Ex4_TreeSet {
	public static void main(String[] args) {
		/*	TreeSet
		 *			- 이진 검색 트리 자료구조
		 *			- 정렬, 검색, 범위 검색에서 높은 성능
		 *			- 중복된 데이터를 허용하지 않으면서 정렬된 위치에 저장하므로 저장순서를 유지하지도 않는다. 
		 * 
		 * 		이진트리
		 * 			- LinkedList 처럼 여러 개의 노드가 서로 연결된 구조
		 * 			- 첫번째 저장 값은 최상위 노드 root에 저장
		 * 			- 모든 노드는 최대 두 개의 자식 노드를 가질 수 있다.
		 * 			- 왼쪽 자식 노드의 값은 부모 노드의 값보다 작고 오른쪽 자식 노드의 값은 부모 노드의 값보다 커야 한다.
		 * 			- 노드의 추가, 삭제에 시간이 걸린다. (순차적으로 저장하지 않음)
		 * 			- 검색 (범위 검색)과 정렬에 유리하다.
		 * 			- 중복된 값을 저장하지 못한다.
		 * 			
		 * 				[참고] 값 7, 4, 9, 1, 5 가 저장
		 * 					(1) root 노드에 7 저장
		 * 					(2) 첫번째 부모 노드에 4 저장
		 * 					(3) 7 < 9 이므로 두번째 부모 노드에 9 저장
		 * 					(4) 1 < 7, 1 < 4 이므로 첫번째 부모의 첫번째 자식 노드에 1 저장
		 * 					(5) 5 < 7, 5 > 4 이므로 첫번째 부모의 두번째 자식 노드에 5 저장
		 */
		
		// 중복 X, 정렬 O
		Set set = new TreeSet();
		
		for(int i=0; set.size() < 6; i++) {
			int num = (int) (Math.random() * 45) + 1;
			set.add(num);		// set.add(new Integer(num));
		}
		
		System.out.println(set);
		System.out.println("------------------------");
		
		//
		TreeSet ts = new TreeSet();
		
		String from = "b";
		String to = "d";
		
		ts.add("abc");				ts.add("alien"); 			ts.add("bat");
		ts.add("car");				ts.add("Car"); 				ts.add("disc");
		ts.add("dance");			ts.add("dZZZZ"); 			ts.add("dzzzz");
		ts.add("elephant");		ts.add("elevator"); 		ts.add("fan");
		ts.add("flower");
		
		System.out.println(set);
		System.out.println("range search : from " + from + " to "  + to);
		System.out.println("result1 : "  + ts.subSet(from, to));							// 범위 검색은 시작 범위는 포함되나, 마지막 범위는 포함되지 않는다.
		System.out.println("result1 : "  + ts.subSet(from, to + "zzz"));			// 마지막 범위인 d를 포함시키고자한다면 뒤에 zzz 를 붙여서 사용한다.
		System.out.println("------------------------");

		// 지정된 값보다 크거나 작은 객체 값 조회
		TreeSet t1 = new TreeSet();
		int [] s1 = {80, 95, 50, 35, 45, 65, 10, 100};
		
		for(int i = 0; i < s1.length; i++) {
			t1.add(new Integer(s1[i]));
		}
		
		System.out.println("(1) 50 미안 : " + t1.headSet(new Integer(50)));
		System.out.println("(2) 50 이상 : " + t1.tailSet(new Integer(50)));
		System.out.println("------------------------");

	}
}
