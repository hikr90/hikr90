package ex3_interface;

public class Ex3_Interface_Poly {
	public static void main(String[] args) {
		/*	�������̽��� ������
		 * 		- �������̽� ���� �̸� ������ Ŭ������ �����̹Ƿ� �ش� �������̽� Ÿ���� ���������� �̸� ������ Ŭ������ �ν��Ͻ��� ������ �� �ִ�.
		 * 			(�������̽� Ÿ�������� ����ȯ�� �����ϴ�.)
		 * 
		 * 		[����] �������̽��� Ŭ������ �������� ��, �Ʒ�ó�� Ŭ������ �ν��Ͻ��� �������̽� ���������� �����ϴ� ���� �����ϴ�.
		 * 			Interface i = (Interface) new Class();
		 * 			Interface i = new Class();
		 * 
		 * 			(1) �������̽� Ÿ���� �Ű������� ���� �ǹ̴� �޼ҵ� ȣ�� �� �ش� �������̽��� ������ Ŭ������ �ν��Ͻ��� �Ű������� �����ؾ� �Ѵ�.
		 * 				i.method(Inteface i){ };
		 * 
		 * 			(2) �������̽��� ������ Ŭ������ ���� ��, �޼ҵ��� �Ű������� Ŭ������ �ν��Ͻ��� �Ѱ��� �� �ִ�.
		 * 				method(new Class());
		 * 
		 * 			(3) �޼ҵ��� ���� Ÿ������ �������̽��� Ÿ�� ������ �����ϴ�.
		 * 				Interface method(){
		 * 					Class c = new Class();
		 * 					return c;
		 * 				}
		 * 
		 * 		[����] ����Ÿ���� �������̽���� ����, �޼ҵ尡 �ش� �������̽��� ������ Ŭ������ �ν��Ͻ��� ��ȯ�Ѵٴ� ���� ���Ѵ�.
		 */
		Parseable parser = ParserManager.getParser("XML");
		parser.parse("document.xml");
		
		parser = ParserManager.getParser("HTML");
		parser.parse("document2.html");
	}
}

//
interface Parseable {
	public abstract void parse(String fileName);
}

class ParserManager {
	// ����Ÿ���� Parseable �������̽�
	public static Parseable getParser(String type) {
		if(type.equals("XML")) {
			// [����] XMLParser�ν��Ͻ��� �ּ� ���� ����
			//		- Parserable parser = new XMLParser(); �� ����.
			return new XMLParser(); 
		} else {
			// ���� �����ϴ�.
			Parseable p = new HTMLParser();
			return p;
		}
	}
}

//
class XMLParser implements Parseable {
	public void parse(String fileName) {
		System.out.println(fileName + " - XML parsing completed.");
	}
}

class HTMLParser implements Parseable {
	public void parse(String fileName) {
		System.out.println(fileName + " - HTML parsing completed.");
	}
}
