package ex4_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex1_Arrays {
	public static void main(String[] args) {
		/* Arrays
		 * 	- �迭�� �ٷ�µ� ������ �޼ҵ尡 �ִ� Ŭ����
		 */
		
		// ����
		int [] arr1 = {0,1,2,3,4};
		int [] arr2 = Arrays.copyOf(arr1, arr1.length);		// [0,1,2,3,4]
		int [] arr3 = Arrays.copyOfRange(arr1, 2, 4);		// [2,3]
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		System.out.println("------------------");
		
		// ä���
		int [] arr4 = new int[5];
		Arrays.fill(arr4, 9);			// [9,9,9,9,9]
		System.out.println(Arrays.toString(arr4));
		System.out.println("------------------");
		
		// ����, �˻�
		int [] arr5 = {3, 2, 0, 1, 4};
		Arrays.sort(arr5);
		int idx = Arrays.binarySearch(arr5, 2);			// -5�� �߸��� ������, �ݵ�� ������ �� ���¿��� ����ؾ��Ѵ�.
		
		/*	���� �˻�, ���� �˻�
		 * 	(1) ���� �˻�
		 * 		- �迭�� ù ��Һ��� ������� �ϳ��� �˻��ϴ� ���
		 * 		- �迭�� ���ĵǾ����� �ʿ�� ������ ��Ҹ� �ϳ��� ���ϹǷ� �ð��� ���� ���.
		 * 
		 *  	(2) ���� �˻�
		 *  		- �˻��� ������ �ݺ������� ���ݾ� �ٿ����� �˻��ϴ� ���
		 *  		- �˻� �ӵ��� ���� ���, ������ �Ǿ��ִ� ���¿����� ��� �����ϴ�.
		 */
		
		System.out.println(idx);
		System.out.println("------------------");
		
		// ��, ���
		int [] arr6 = {0, 1, 2, 3, 4};
		int [][] arr6D = {{11, 12}, {21, 22}};
		
		System.out.println(Arrays.toString(arr6));					// toString (1����)
		System.out.println(Arrays.deepToString(arr6D));			// deepToString (������)
		
		String [][] strD = new String[][] {{"aaa", "bbb"}, {"AAA", "BBB"}};
		String [][] strD2 = new String[][] {{"aaa", "bbb"}, {"AAA", "BBB"}};
		
		System.out.println(Arrays.equals(strD, strD2));				// equals (1����, �迭�� �ּҸ� ��)
		System.out.println(Arrays.deepEquals(strD, strD2));		// deepEquals (������, �迭�� �����͸� ��͹������ ��)
		System.out.println("------------------");
		
		// Array > List ��ȯ
		// - asList �޼ҵ�� List�� ũ�⸦ ������ �� ����.
		// - �߰�, ���� X
		List list1 = Arrays.asList(new Integer[] {0, 1, 2, 3, 4, 5}); 	// [1, 2, 3, 4, 5]
		List list2 = Arrays.asList(1, 2, 3, 4, 5);									// [1, 2, 3, 4, 5] 
		
		// [����] ũ�⸦ ������ �� �ִ� ���
		List list3 = new ArrayList(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println(list3);
		System.out.println("------------------");
	}
}
