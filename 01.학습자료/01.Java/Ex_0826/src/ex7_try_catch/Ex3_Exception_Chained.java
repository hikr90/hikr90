package ex7_try_catch;

public class Ex3_Exception_Chained {
	public static void main(String[] args) {
		/* ����� ����
		 * 	- ���� A�� ���� B �߻� ��, A�� B�� '���� ����' ��� �θ���.
		 * 	- �� ���ܰ� �ٸ� ���ܻ����� �߻���Ű�� ����
		 */
		
		try {
			//
			install();
		} catch (InstallException e) {
			//
			e.printStackTrace();
		}
	}
	
	static void install() throws InstallException {
		//
		try {
			//
			startInstall();
			copyFiles();
		} catch (SpaceException se) {
			//
			InstallException ie = new InstallException("��ġ �� ���� �߻�");
			ie.initCause(se);
			throw ie;
		} catch (MemoryException me) {
			InstallException ie = new InstallException("��ġ �� ���� �߻�");
			ie.initCause(me);
			throw ie;
		} finally {
			deleteTempFiles();
		}
	}
	
	//
	static void startInstall() throws SpaceException, MemoryException {
		if(!enoughSpace()) {
			throw new SpaceException("��ġ�� ������ �����մϴ�.");
		}
		if(!enoughMemory()) {
			throw new MemoryException("�޸𸮰� �����մϴ�.");
		}
	}
	
	//
	static void copyFiles() {};
	static void deleteTempFiles() {};
	
	//
	static boolean enoughSpace() {
		return false;
	}
	static boolean enoughMemory() {
		return true;
	}
}

//
class InstallException extends Exception {
	InstallException(String msg) {
		super(msg);
	}
}

class SpaceException extends Exception {
	SpaceException(String msg) {
		super(msg);
	}
}

class MemoryException extends Exception {
	MemoryException(String msg) {
		super(msg);
	}
}