package ex1_object_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*����� �����͸� �ҷ����� Ŭ����*/
public class ScoreLoader {
	
	// �¹��� ����� �ҷ��ͼ� �� ������ ������ Ŭ���� ���� 
	private RspInfo info;
	
	// private�̴ϱ� ���� �θ� �� �ִ� info Ŭ������ �ε� �޼��尡 �ʿ��ϴ�.
	public RspInfo getInfo() {
		return info;
	}
	
	// ������
	public ScoreLoader(String id) {
		String path = "C://JAVA1_0713_KTH/Game/"+id+"/Gamesav.sav";
		File f = new File(path);
		
		if(f.exists()) {
			// ó���� �ƴ� ����� ���
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			
			// ���� �ε�
			try {
				
				fis = new FileInputStream(f);
				ois = new ObjectInputStream(fis);
				// �δ��� infoŬ������ �ּҰ��� �Ѱ��� (new�� ��� �ּҰ��� ������ �������� ������ �ο�����) = �δ��� ���� rspinfo��ü�� ����� get�޼��� ��밡�� 
				// ū(object)��ü�� ����(class)��ü�� �����⶧���� � Ŭ����(���� ������ Ŭ����Ÿ��)�� ������ ��������Ѵ�.
				// object�� �޾ƿ� ois.readObject()�� (RspInfo)Ÿ������ �޾Ƽ� info�� �����Ѵ�.
				info = (RspInfo)ois.readObject();
				System.out.println("�ε� �Ϸ�");
				
				// info�ȿ��� �ش� ���̵𿡴��� �¹��� ����� ���� ���̴�.
				
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("�ε� ����");
			}finally {
				// ���ο��� �ٽ� ���ο� ���� �ʵ��� try ó��
				try {
					ois.close();
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}else {
			// ó�� ������ �ϰų� �������� �ʴ� ���̵�� ������ ���
			// game ����, id, gamesav.sav�� ���� ����
			System.out.println("���̵� ������ ȯ���մϴ�.");
		}
		
	}

















}
