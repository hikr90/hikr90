package ex5_serialization;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ex1_Serialization {
	public static void main(String[] args) throws IOException {
		/*	Serialization (����ȭ)
		 * 		- ��ü�� ������ ��Ʈ������ ��ȯ�ϴ� �۾�
		 * 		- ��ü�� ����� �����͸� ��Ʈ���� �������� �������� �����ͷ� ��ȯ�ϴ� ���� ���Ѵ�.
		 * 		- ��ü�� ��ǻ�Ϳ� �����ߴٰ� ���߿� �ٽ� ������ ����ϰų�, ��Ʈ��ũ�� ���ؼ� ��ǻ�� ���� ��ü�� �ְ� �޴� ���� �����ϴ�.
		 * 		- �ݴ�� ��Ʈ�����κ��� �����͸� �о ��ü�� ����� ���� ������ȭ��� �θ���.
		 * 
		 * 		[����] ����ȭ�� ���� ǥ���ϸ� ��ü�� �����ϰų� �����ϴµ� �ʿ��� �۾��̴�.
		 * 			- ��ü�� Ŭ������ ���ǵ� �ν��Ͻ� ������ �����̴�.
		 * 			- ��ü�� �����Ѵٴ� ���� ��ü�� ��� �ν��Ͻ� ������ ���� �����ϴ� �Ͱ� ����.
		 * 			- ������ ��ü�� �ٽ� ����Ϸ��� ��ü ���� �Ŀ� �����ߴ� ���� �о ������ ��ü�� �ν��Ͻ� ������ �����ϸ� �ȴ�.
		 * 			- Ŭ������ ���ǵ� �ν��Ͻ� ������ �⺻���� �ƴ� �������� ��쿡�� ������ ���鵵 ���� ����Ǿ�� �Ѵ�.
		 * 			- ���� ���� ��Ȳ���� ObjectInput/OutputStream�� ���ؼ� ����ȭ�� �����Ѵ�. 
		 * 
		 * 
		 * 		(1) ObjectInputStream / ObjectOutputStream
		 * 			- ObjectInputStream : ������ȭ (��Ʈ�����κ��� ��ü�� �Է�)
		 * 			- ObjectOutputStream : ����ȭ (��Ʈ���� ��ü�� ���)
		 * 
		 * 			[����] ObjectStream�� ���� ��Ʈ�����μ�, ��ü ���� �ÿ� ����� (����ȭ/������ȭ)�� ��Ʈ��(Input/OutputStream)�� �����ؾ��Ѵ�.
		 * 				(1.1) ����ȭ
		 * 					#1 ��� ��Ʈ�� ���� 
		 * 						- FileOutputStream fos = new FileOutputStream("objectfile.ser");
		 * 
		 * 					#2 ��� ��Ʈ���� ������� ���� ��Ʈ�� ����
		 * 						- ObjectOutputStream out = new ObjectOutputStream(fos);
		 * 
		 * 					#3 ��ü�� ���Ͽ� ����ȭ�Ͽ� ����
		 * 						- out.writeObject(new UserInfo()); 
		 * 
		 * 				(1.2) ������ȭ
		 * 					#1 �Է� ��Ʈ�� ����
		 * 						- FileInputStream fis = new FileInputStream("objectfile.ser");
		 * 
		 * 					#2 �Է� ��Ʈ���� ������� ���� ��Ʈ�� ����
		 * 						- ObjectInputStream in = new ObjectInputStream(fis);
		 * 
		 * 					#3 ���Ͽ� ����� ��ü ������ �о�´�.
		 * 						- UserInfo info = (UserInfo)in.readObject();
		 * 
		 * 		(2) ����ȭ�� ����� ����
		 * 			- ���� Ŭ�������� Serializable�� �����ߴٸ� �ڼ� Ŭ�������� ���� ������ �ʿ� ����, �ڼ� Ŭ������ ����ȭ �� �� ���� Ŭ������ �ν��Ͻ� ������ ���� ����ȭ�ȴ�.
		 * 			- ���� Ŭ�������� Serializable�� �������� �ʾҴٸ�, �ڼ� Ŭ������ ����ȭ�� �� ���� Ŭ������ �ν��Ͻ� ������ ����ȭ ���� �ʴ´�.
		 * 
		 * 		(3) java.io.NotSerializableException
		 * 			- ����ȭ �� �� ���ٴ� �ǹ��� ����
		 * 			- Object ��ü�� ����ȭ �� �� �����Ƿ� Object ����ȭ ��, ���� ���� ������ �߻��Ѵ�.
		 * 			- ��, Object obj = new String("123");�� ���� ������ ����� ��ü�� String���� ����ȭ ������ �ν��Ͻ��� ��쿡�� ����ȭ �� �� �ִ�.
		 * 
		 * 			(3.1) transient
		 * 				- ����ȭ ��󿡼� �����ϴ� ������
		 * 				- �н������ ���� ���Ȼ� ����ȭ�Ǹ� �ȵǴ� ���� ���ؼ� ����Ѵ�.
		 * 				- �ش� Ű���尡 ���� �ν��Ͻ� ������ ���� �� Ÿ���� �⺻ ������ ����ȭ�ȴ�.
		 * 
		 * 		(4) serialVersionUID
		 * 			- ��ü�� ����ȭ �� ���� ������ȭ �� ���� Ŭ������ ������ ���ƾ� �Ѵ�.
		 * 			- ���� �� Ŭ������ ������ �ٸ� ��� ���ܰ� �߻��ϰԵǴµ� �̸� �����ϱ����ؼ� ��ü�� ����ȭ�� �� 
		 * 			- Ŭ������ ���ǵ� ������� ������ �̿��ؼ� serialVersionUID Ŭ������ ������ �ڵ������Ͽ� ����ȭ ���뿡 �����Ѵ�. 
		 * 			- �� ������ ������� ������ȭ �� �� Ŭ������ ������ �������ν� ����ȭ�� ���� Ŭ������ ������ ��ġ�ϴ��� Ȯ���� �� �ִ�.
		 *
		 *			# Ŭ������ ������ �������� �����ϴ� ���
		 *				- Ŭ���� ���� ���� UID�� �����ϴ� ��� Ŭ������ ������ ����Ǿ Ŭ������ ������ �ڵ������� ������ ������ �ʴ´�.
		 *				- UID�� ���� ���� ���̸� � �����ε� ������ �� ������ ���� �ٸ� Ŭ���� ���� ���� ���� ���� �ʵ��� �ϴ� ���� �Ϲ����̴�.
		 * 
		 * 				class MyData implements java.io.Serializable {
		 * 					static final long serialVersionUID = 3518731767529258119L;
		 * 					int value1;
		 * 				}
		 * 
		 * 			[����] static, transient�� �ִ� ��쿡�� ����ȭ�� ������ ��ġ�� �����Ƿ� ������ �ٸ��� �ν��ϵ��� �� �ʿ䰡 ����.
		 * 
		 * 
		 * 
		 */
		String fileName = "Ex3_UserInfo.ser";
		FileOutputStream fis = new FileOutputStream(fileName);
		BufferedOutputStream bis = new BufferedOutputStream(fis);
		ObjectOutputStream out = new ObjectOutputStream(bis);
		
		Ex3_UserInfo u1 = new Ex3_UserInfo("Kim", "1234", 30);
		Ex3_UserInfo u2 = new Ex3_UserInfo("Lee", "4321", 20);
		
		ArrayList<Ex3_UserInfo> list = new ArrayList<>();
		list.add(u1);
		list.add(u2);
		
		// ��ü ����ȭ
		out.writeObject(u1);
		out.writeObject(u2);
		out.writeObject(list);
		out.close();
		
		System.out.println("����ȭ �Ϸ�");
	}
}

