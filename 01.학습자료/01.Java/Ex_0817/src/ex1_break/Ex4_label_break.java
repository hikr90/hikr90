package ex1_break;

public class Ex4_label_break {

	public static void main(String[] args) {

		int n = 1;

		
		sj : while(true) {
			System.out.println(n);

			switch(n) {
			case 1:
				System.out.println("1����");
				break;

			case 2:
				System.out.println("2����");
				break sj;

			}

			n++;
		}











	}
}
