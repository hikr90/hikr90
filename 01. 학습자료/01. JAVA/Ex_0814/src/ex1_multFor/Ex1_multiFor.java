package ex1_multFor;

public class Ex1_multiFor {

	public static void main(String[] args) {

		/* ���� 
		 * 
		 * *
		 * * *
		 * * * *
		 * * * * *
		 */

		for(int i=1;i<=5;i++) {
			for(int j=0;j<i;j++) {
				System.out.print("* ");

			}
			System.out.println();
		}


		System.out.println("---------------");


		// *���� ���� ����
		//         * 
		//      * * * 
		//    * * * * * 
		//  * * * * * * * 
		//* * * * * * * * * 

		for(int i=0;i<5; i++) {

			for(int j=0; j<5+i;j++) {

				if(i+j>3) {
					System.out.print("* ");
				}else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}

		System.out.println("---------------");

		// 1 2 3 4 5 6 7 8 9 10
		// 2 3 4 5 6 7 8 9 10 1
		// 4 5 6 7 8 9 10 1 2 3
		// ....
		// 10 1 2 3 4 5 6 7 8 9


		for(int i=1;i<=10;i++) {
			for(int j=0;j<10;j++) {

				int num = i + j;
				
				// if�� �ؿ� ���ٸ� �ִٸ� {}�� ������� �ʾƵ� �ν��Ѵ�.
				if(num>10) {
					num -= 10;
				}
				System.out.print(num+" ");

			}
			System.out.println();
		}

		
		
	}
}
