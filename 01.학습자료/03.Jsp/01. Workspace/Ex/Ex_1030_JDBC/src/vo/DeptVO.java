package vo;

public class DeptVO {
	// Mybatis 사용 시 DB의 컬럼명과 변수명은 가급적 일치하는 것이 좋다.
	private int deptno;
	private String dName;
	private String loc;
	//
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
}
