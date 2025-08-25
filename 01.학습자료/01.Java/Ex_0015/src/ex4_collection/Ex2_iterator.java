package ex4_collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Ex2_iterator {

	public static void main(String[] args) {
		
		/*	반복자 (iterator)
		 * 	- set은 인덱스가 없으므로 내용을 가져오기위해서는 반복자를 사용해야한다.
		 * 	- 반복자를 통해서 set의 값을 배열에 옮겨 담을 수 있다.
		 * 	- iterator의 타입과 넣으려는 타입은 같아야한다.
		 */
		
		// set 에서 값을 수정
		HashSet<Integer> set = new HashSet<Integer>();
		
		// 값 입력
		for(int i=0;set.size()<6;i++) {
			set.add(new Random().nextInt(45)+1);
		}
		
		System.out.println(set);

		//
		int [] arr = new int[set.size()];
		
		// iterator 선언
		Iterator<Integer> it = set.iterator();
	
		// next 메소드를 통해서 set 의 값을 첫번째부터 순차적으로 집어넣는다.
		for(int i=0;i<arr.length;i++) {
			//
			arr[i] = it.next();
			System.out.print(arr[i]+" ");
		}
	} // main
}
