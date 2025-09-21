package ex2_char_stream;

import java.io.StringReader;
import java.io.StringWriter;

public class Ex4_String_Reader_Writer {
	public static void main(String[] args) {
		 /*	StringReader & StringWriter 
		  *		- 입출력 대상이 메모리인 스트림
		  *		- StringWriter에 출력되는 데이터는 내부의 StringBuilder에 저장되며 아래의 메소드를 이용해서 저장된 데이터를 얻을 수 있다.
		  *
		  *			(1) StringBuffer getBuffer() : StringWriter에 출력한 데이터가 저장된 StringBuffer를 반환한다.
		  *			(2) String toString() : StringWriter에 출력된 (StringBuffer에 저장된) 문자열을 반환한다.
		  */
		String s = "ABCD";
		StringReader sr = new StringReader(s);
		StringWriter sw = new StringWriter();
		
		int data = 0;
		
		try {
			while ((data=sr.read()) != -1) {
				sw.write(data);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("s : " + s);
		System.out.println("sr : " + sr.toString());
		System.out.println("sw : " + sw.getBuffer().toString());
	}
}
