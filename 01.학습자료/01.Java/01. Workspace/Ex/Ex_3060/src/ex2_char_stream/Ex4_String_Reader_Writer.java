package ex2_char_stream;

import java.io.StringReader;
import java.io.StringWriter;

public class Ex4_String_Reader_Writer {
	public static void main(String[] args) {
		 /*	StringReader & StringWriter 
		  *		- ����� ����� �޸��� ��Ʈ��
		  *		- StringWriter�� ��µǴ� �����ʹ� ������ StringBuilder�� ����Ǹ� �Ʒ��� �޼ҵ带 �̿��ؼ� ����� �����͸� ���� �� �ִ�.
		  *
		  *			(1) StringBuffer getBuffer() : StringWriter�� ����� �����Ͱ� ����� StringBuffer�� ��ȯ�Ѵ�.
		  *			(2) String toString() : StringWriter�� ��µ� (StringBuffer�� �����) ���ڿ��� ��ȯ�Ѵ�.
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
