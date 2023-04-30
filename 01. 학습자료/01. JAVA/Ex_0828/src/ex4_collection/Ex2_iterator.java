package ex4_collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Ex2_iterator {

	public static void main(String[] args) {
		
	// 컬렉션의 Set에서 값을 수정하는 방법
	HashSet<Integer> set = new HashSet<Integer>();
	
	// 값 입력
	for(int i=0;set.size()<6;i++) {
		set.add(new Random().nextInt(45)+1);
	}
	
	System.out.println(set);
	
	
	// 수정을 위해서 set의 값을 배열에 옮겨담아야한다.
	int [] arr = new int[set.size()];
	
	// Set구조는 특정 index로 접근할 수 없기에 내용을 가져오기위해서는 iterator라고하는 '반복자'를 사용해야한다.
	// iterator의 타입과 넣으려는 타입은 같아야한다.
	Iterator<Integer> it = set.iterator();

	// set으로 접근하여 데이터를 가지고오게되는데 set의 첫번째 방에 커서가 잡히게된다, next를 만나면 첫번쨰 값을 잡아 배열의 방에 넣는다.
	for(int i=0;i<arr.length;i++) {
		
		arr[i] = it.next();
		System.out.print(arr[i]+" ");
	}
	
	
	
	
	} // main
}
