package ex1_object_stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ScoreWriter {
	public ScoreWriter(RspInfo info) {
		//
		String path = "C://JAVA1_0713_KTH/Game/"+info.getId()+"/Gamesav.sav";
		
		// ���� ������ �����Ѵ�.
		File dir1 = new File("C://JAVA1_0713_KTH/Game/");
		//
		if(!dir1.exists()) {
			// ������ ������ �����Ѵ�.
			dir1.mkdirs();
		}

		// �з� ������ �����Ǿ�����, ����ں� ������ �ִ��� Ȯ��
		File dir2 = new File(dir1,info.getId());
		if(!dir2.exists()) {
			// ������ ����
			dir2.mkdirs();
		}
		
		/*	ObjectOutputStream
		 *		- Ŭ������ ������ ������ �� �ְ����ִ� �������� ��Ʈ��
		 *		- Ŭ������ ������ϴ� ��� �ݵ�� ����Ʈ ������� �����ؾ��Ѵ�. 
		 *		- �����ϴ� ��ü ������ �ݵ�� ����ȭ �������̽��� �����ؾ��Ѵ�.
		 */
		
		// RspInfo�� ���̵�, ��Ī, �������� ���� �޾Ҵ�.
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		//
		try {
			// ���� ����
			fos = new FileOutputStream(path);
			oos = new ObjectOutputStream(fos);
			
			// ��ü�� �����ϴ� ��� writeObject�� ����Ѵ�.
			oos.writeObject(info);	// ���̵� ���� �ȿ� Gamesave.sav �� �����Ѵ�.
					
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("������� ����");
		} finally {
			// ���ο��� throws�� ������� �ʵ��� try - catch ���
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				
			}
		}
	} // constructor
}
