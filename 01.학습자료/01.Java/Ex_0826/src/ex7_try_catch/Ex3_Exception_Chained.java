package ex7_try_catch;

public class Ex3_Exception_Chained {
	public static void main(String[] args) {
		/* 연결된 예외
		 * 	- 예외 A가 예외 B 발생 시, A는 B의 '원인 예외' 라고 부른다.
		 * 	- 한 예외가 다른 예외사항을 발생시키는 구조
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
			InstallException ie = new InstallException("설치 중 예외 발생");
			ie.initCause(se);
			throw ie;
		} catch (MemoryException me) {
			InstallException ie = new InstallException("설치 중 예외 발생");
			ie.initCause(me);
			throw ie;
		} finally {
			deleteTempFiles();
		}
	}
	
	//
	static void startInstall() throws SpaceException, MemoryException {
		if(!enoughSpace()) {
			throw new SpaceException("설치할 공간이 부족합니다.");
		}
		if(!enoughMemory()) {
			throw new MemoryException("메모리가 부족합니다.");
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