package ex1_method;

class Data { int x; }

public class Ex2_Primitive_Type {
	public static void main(String[] args) {
		// [����] �⺻���� ������ �Ű������� ����
		Data d1 = new Data();
		d1.x = 10;
		change(d1.x);	// �⺻�� �Ű����� (������ ��)�̹Ƿ� �������� �ʴ´�.
		
		Data d2 = new Data();
		d2.x = 10;
		
		change(d2);		// ������ �Ű����� (����)�̹Ƿ� �����ȴ�.
	}
	
	//
	static void change(int x) {
		x = 1000;
		System.out.println("change(int x) : x = " + x);
	}
	//
	static void change(Data d) {
		d.x = 1000;
		System.out.println("change(Data d) : x = " + d.x);
	}
}


