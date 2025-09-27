package ex5_serialization;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Ex2_Deserialization {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// ������ȭ
		String fileName = "Ex3_UserInfo.ser";
		FileInputStream fis = new FileInputStream(fileName);
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream in = new ObjectInputStream(bis);
		
		// ��ü�� ���� ���� ����� ������ ��ġ�ؾ� �Ѵ�.
		Ex3_UserInfo u1 = (Ex3_UserInfo)in.readObject();
		Ex3_UserInfo u2 = (Ex3_UserInfo)in.readObject();
		ArrayList list = (ArrayList)in.readObject();
		
		System.out.println(u1);
		System.out.println(u2);
		System.out.println(list);
		in.close();
	}
}
