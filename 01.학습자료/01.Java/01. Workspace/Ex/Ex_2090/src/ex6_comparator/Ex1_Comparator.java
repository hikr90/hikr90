package ex6_comparator;

import java.util.Arrays;
import java.util.Comparator;

public class Ex1_Comparator {
	public static void main(String[] args) {
		/*	Comparator, Comparable
		 * 	- Arrays.sort �� ������ Comparator Ŭ������ Comparable ������ ���� �����Ѵ�.
		 * 	- �� �������̽��� �÷����� �����ϴµ� �ʿ��� �޼ҵ带 �����Ѵ�.
		 * 	- �⺻������ ���� ������ ū ���� ������ ���ĵǵ��� �����Ǿ��ִ�.
		 * 
		 * 	compare, compareTo
		 * 		- �� ������ �������̽����� ������ ���
		 * 		- �� ��ü�� ���Ѵٴ� ������ ����� �����ϴ�.
		 * 		- �� ��ü�� ������ 0, ���ϴ� ������ ������ ����, ũ�� ��� ��ȯ
		 * 		- ����ڰ� ������������ �����ϰų�, Ư���� �������� �����ϰ���� ��� Comparator�� �����ؼ� ���ı����� ���� ���� �����ϴ�.
		 * 
		 * 			[����] Comparable�� �⺻ ���ı����� ����, Comparator�� �ٸ� �������� �����ϴ� ��� ����
		 */
		String [] arr = {"cat", "Dog", "Pig", "bird"};
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER);		// ��ҹ��� ���� X
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr, new Desending());	// ���� ����
		
		// [����] Array.sort ��, Comparator�� �������� �ʴ� ��� �����ϴ� ��ü�� ������ ���뿡���� �����Ѵ�.
		// - static void sort(Object [] a) : ��ü �迭�� ����� ��ü�� ������ Comparable�� ���� ���� (String�� ��� ���� ������ ����)
		// - static void sort(Object [] a, Comparator c) : ������ Comparator�� ���� ����
	}
}

// Ŭ���� ����
class Desending implements Comparator {
	@Override
	public int compare(Object arg0, Object arg1) {
		//
		if(arg0 instanceof Comparable && arg1 instanceof Comparable) {		// ������ ��ü�� �� Ŭ������ �ش��ϴ� ��츸 ��, �ƴϸ� -1 ����
			Comparable c1 = (Comparable) arg0;
			Comparable c2 = (Comparable) arg1;
			
			// -1�� ���Ͽ� �⺻ ���Ĺ���� ������ ����
			// Ȥ�� c2.compareTo(c1) ���
			return c1.compareTo(c2) * -1;
		}
		//
		return -1;
	}
}