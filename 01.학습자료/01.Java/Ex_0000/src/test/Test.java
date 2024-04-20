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
		
		System.out.println("가장 많이 나온 값 : "+mode);
		System.out.println("나온 횟수 : "+max);

	} // main
}
