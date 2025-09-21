package ex3_interface;

public class Ex3_Interface_Poly {
	public static void main(String[] args) {
		/*	인터페이스의 다형성
		 * 		- 인터페이스 역시 이를 구현한 클래스의 조상이므로 해당 인터페이스 타입의 참조변수로 이를 구현한 클래스의 인스턴스를 참조할 수 있다.
		 * 			(인터페이스 타입으로의 형변환도 가능하다.)
		 * 
		 * 		[참고] 인터페이스를 클래스가 구현했을 때, 아래처럼 클래스의 인스턴스를 인터페이스 참조변수로 참조하는 것이 가능하다.
		 * 			Interface i = (Interface) new Class();
		 * 			Interface i = new Class();
		 * 
		 * 			(1) 인터페이스 타입의 매개변수가 갖는 의미는 메소드 호출 시 해당 인터페이스를 구현한 클래스의 인스턴스를 매개변수로 제공해야 한다.
		 * 				i.method(Inteface i){ };
		 * 
		 * 			(2) 인터페이스를 구현한 클래스가 있을 때, 메소드의 매개변수로 클래스의 인스턴스를 넘겨줄 수 있다.
		 * 				method(new Class());
		 * 
		 * 			(3) 메소드의 리턴 타입으로 인터페이스의 타입 지정도 가능하다.
		 * 				Interface method(){
		 * 					Class c = new Class();
		 * 					return c;
		 * 				}
		 * 
		 * 		[참고] 리턴타입이 인터페이스라는 것은, 메소드가 해당 인터페이스를 구현한 클래스의 인스턴스를 반환한다는 것을 뜻한다.
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
	// 리턴타입이 Parseable 인터페이스
	public static Parseable getParser(String type) {
		if(type.equals("XML")) {
			// [참고] XMLParser인스턴스의 주소 값을 리턴
			//		- Parserable parser = new XMLParser(); 와 같다.
			return new XMLParser(); 
		} else {
			// 위와 동일하다.
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
