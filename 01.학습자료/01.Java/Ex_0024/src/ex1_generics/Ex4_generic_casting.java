package ex1_generics;

public class Ex4_generic_casting {
	public static void main(String[] args) {
		/* ���׸��� ����ȯ
		 * 		- ���׸� <> ���� (non-generic) Ÿ�� ���� ����ȯ�� �����ϴ�.
		 * 		- ���׸� �� �ٸ� Ÿ�� ��ȯ ��, ���ϵ� ī�带 ����Ͽ� ��ȯ �����ϴ�.
		 */
		
		// ���׸� <> ���� Ÿ�� ����ȯ
		Box<Object> objBox = null;
		Box box = null;
		//
		box = (Box)objBox;
		objBox = (Box<Object>)box;
		
		// [����] ���� �ٸ� ���׸� Ÿ�԰��� ����ȯ�� �ȵȴ�.
		// - Box<String> strBox = null;
		// - strBox = (Box<String>objBox);		// ����
		
		// [����] ���ϵ� ī�� ���
		// - String�� Object�� �ڽ��̹Ƿ� ����ȯ�� �����ϴ�.
		//	- �������� ����
		Box<? extends Object> wBox = new Box<String>();
		
		// [����] Optional<?> empty = new Optional<>();
		// - ? �� ? extends Object �� ���ϸ� <> �ȿ� ������ Ÿ���� Object�̴�.
		// - <?> �� ���� �� ����
		// - Optional<Object> -> Optional<?> -> Optional<T> �� ��ȯ ���� (���ϵ� ī�� ���)
	}
}
