package ex1_control_statement;

public class Ex4_switch {
	
	public static void main(String[] args) {
		
		/* 
		switch(case��) : �񱳰��� ���ǰ��� ���ؼ� ����� �����ϴ� ���
		:: case����  ���ο� �ּ� 1�� �̻��� case�� �־���Ѵ�, case�� ���� ������ ������ �ߺ��� �� �� ����. 
		:: switch�� ���ǽ��� �� �� ����.
		:: �񱳰��� ���ǰ��� �ݵ�� ���� �ڷ��� Ÿ���̿����Ѵ�.
		
		else if��  case���� ����
		:: else if�� ���������� ��ġ�� ������ ��������, case�� ��ġ�ϴ� �񱳰��� ã�Ƽ� �״�� ���´�. (�ӵ����鿡�� case�� �� ����)
		:: case���� ���ǹ��� ����� �� �����Ƿ� ���������� ���� �� �񱳰� �Ұ����ϴ�.
		
		switch(�񱳰�){
			case ���ǰ� : 
				�񱳰��� ���ǰ��� ��ġ�ϴ� ���, ����Ǵ� ����
				break;
		
			default(�񱳰��� ���ǰ��� �Ѱ��� ��ġ���� ���� ��, �ݵ�� ����Ǵ� ����) :
				����Ǵ� ����
				break;
		}
		
		*/
	
		// ����Ÿ���� byte, short, int�� ���� �� �ְ� long�� ����´�.
		// switch���� ����, ����, ���ڿ� �� 3������ Ÿ�Ը� ���� �� �ִ�.
		int n = 3324;
		
		switch(n) {
		case 1 :
			System.out.println("���� ����");
			break;
		
		case 2 :
			System.out.println("���� �Ұ�");
			break;
			
		case 3 :
			System.out.println("���� ����");
			break;
		
		default :
			System.out.println("�߸��� ���Դϴ�.");
			break;
		}
	
	
	}
}
