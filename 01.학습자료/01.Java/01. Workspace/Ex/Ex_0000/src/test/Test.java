package test;

public class Test {
	
	public static void main(String[] args) {
		
		//
		int [] numArr = {2,7,3,3,4,1,2,5,9,8,0,1,2,4,2,6,8,8,9};
		int [] idxArr = new int[10];
		int max = Integer.MIN_VALUE;
		int mode = 0;
		
		//
		for(int i=0;i<numArr.length;i++) {
			idxArr[numArr[i]]++;
		}
		
		//
		for(int i=0;i<idxArr.length;i++) {
			//
			if(idxArr[i]>max) {
				max = idxArr[i];
				mode = i;
			}
		}
		
		System.out.println("���� ���� ���� �� : "+mode);
		System.out.println("���� Ƚ�� : "+max);

	} // main
}
