package ex6_inner_class;

public class Ex1_Inner_Class {
	// �ܺ� Ŭ����
		
		// ���� Ŭ���� (INSTANCE CLASS)
		class inner_class {
			
			// ���� Ŭ������ PRINT �޼ҵ�
			public void print() {
				System.out.println("INNER Ŭ������ �޼ҵ�");
			}
		}
		
		// ���� ����
		public static void main(String[] args) {
			
			/*		�Ϲ� ���� Ŭ���� ��� ���
			 			�ܺ�Ŭ���� ���� ��,
			 			�ܺ�Ŭ����.����Ŭ���� ����Ŭ���� ���� ��Ī = �ܺ�Ŭ���� ��Ī.NEW ����Ŭ����();
			 */
			Ex1_Inner_Class out_class = new Ex1_Inner_Class();
			Ex1_Inner_Class.inner_class ic = out_class.new inner_class();
			
			// ���� Ŭ������ �޼ҵ� ���
			ic.print();
		}
}
