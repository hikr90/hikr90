package ex1_object_stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*��� ������ ���� Ŭ������ ���� ����*/
public class ScoreWriter {
	// ��ü(RspInfo)�� �뤊�� �����ϱ����� Ŭ����
	
	// ��ü�� �Ѿ���� �ּҰ��� �Ѿ��.
	// �׷��� main�� info�� ����(�¹���,���̵�)�� �Ʒ��� info�� �Ѿ��. 
	public ScoreWriter(RspInfo info) {
	
		String path = "C://JAVA1_0713_KTH/Game/"+info.getId()+"/Gamesav.sav";
		
		// game������ �����Ƿ� ����
		File dir1 = new File("C://JAVA1_0713_KTH/Game/");
		if(!dir1.exists()) {
			// game�� ������ �Ʒ� �� �����Ͽ� game���� ����
			dir1.mkdirs();
		}
		
		// game������ �ݵ�� �����ϴ� ��Ȳ
		// dir1����� game���� �ȿ� info.getid()�� ������ �ֳ�?
		File dir2 = new File(dir1,info.getId());
		if(!dir2.exists()) {
			dir2.mkdirs();
		}
		
		// game�� �������̵� ��Ī���� �ִ� ��Ȳ
		// �Ķ���͸� �Ѱܹ��� info��ü�� ��°�� ����
		// (�߿�!) Ŭ���� ����� ����Ʈ ������θ� �����ϴ�.
		FileOutputStream fos = null;
		ObjectOutputStream oos = null; // Ŭ������ ��°�� ������ �� �ְ��ϴ� �������� ��Ʈ��
		
		try {
			// ������ ����
			fos = new FileOutputStream(path);
			oos = new ObjectOutputStream(fos);
			
			// info��ü�� �����ϴ� ���, writeObject�� ����ؾ��Ѵ�.
			// � Ŭ������ ���� ���� object�� ��, � Ŭ�����ε��� �� ���� �� �ְ� �س��´�. (��� Ŭ������ ������Ʈ�� �ڽ��̴�)
			// info��ü�� Gamesav.sav�� ����
			oos.writeObject(info);
			
					
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("������� ����");
		}finally {
			
			// main���� �� thorws�ϱ� �׷��� ���⼭ tryó��
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				}
		}

		
		
		
		
		
	} // constructor
	
	
	// getclass�� �׳� �� Ŭ������ ���Ѵ�.
	
	
	
}
