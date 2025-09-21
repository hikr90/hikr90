package ex6_comparator;

import java.util.Arrays;
import java.util.Comparator;

public class Ex1_Comparator {
	public static void main(String[] args) {
		/*	Comparator, Comparable
		 * 	- Arrays.sort 의 정렬은 Comparator 클래스의 Comparable 구현에 의해 동작한다.
		 * 	- 두 인터페이스는 컬렉션을 정렬하는데 필요한 메소드를 정의한다.
		 * 	- 기본적으로 작은 값부터 큰 값의 순스로 정렬되도록 구현되어있다.
		 * 
		 * 	compare, compareTo
		 * 		- 위 각각의 인터페이스에서 구현된 기능
		 * 		- 두 객체를 비교한다는 점에서 기능은 동일하다.
		 * 		- 두 객체가 같으면 0, 비교하는 값보다 작으면 음수, 크면 양수 반환
		 * 		- 사용자가 내림차순으로 정렬하거나, 특정한 기준으로 정렬하고싶은 경우 Comparator를 구현해서 정렬기준을 따로 제공 가능하다.
		 * 
		 * 			[참고] Comparable은 기본 정렬기준을 구현, Comparator는 다른 기준으로 정렬하는 경우 구현
		 */
		String [] arr = {"cat", "Dog", "Pig", "bird"};
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER);		// 대소문자 구분 X
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr, new Desending());	// 역순 정렬
		
		// [참고] Array.sort 시, Comparator를 지정하지 않는 경우 저장하는 객체에 구현된 내용에따라 정렬한다.
		// - static void sort(Object [] a) : 객체 배열에 저장된 객체가 구현한 Comparable에 의한 정렬 (String의 경우 사전 순으로 정렬)
		// - static void sort(Object [] a, Comparator c) : 지정한 Comparator에 의한 정렬
	}
}

// 클래스 구현
class Desending implements Comparator {
	@Override
	public int compare(Object arg0, Object arg1) {
		//
		if(arg0 instanceof Comparable && arg1 instanceof Comparable) {		// 진입한 객체가 비교 클래스에 해당하는 경우만 비교, 아니면 -1 리턴
			Comparable c1 = (Comparable) arg0;
			Comparable c2 = (Comparable) arg1;
			
			// -1을 곱하여 기본 정렬방식의 역으로 변경
			// 혹은 c2.compareTo(c1) 사용
			return c1.compareTo(c2) * -1;
		}
		//
		return -1;
	}
}