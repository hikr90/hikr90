package vo;

public class DeptVO {
	
	// DB에서 특정 테이블의 정보를 가져오고 싶다면 가져올 정보에대한 VO가 있어야한다.
	// MYBATIS를 사용하지 않는 경우, 컬럼명과 VO의 변수명이 반드시 같지 않아도 무방하나 가급적이면 서로 명칭을 맞추는 습관을 들이는 것이 좋다.
	private int deptno;
	private String dName;
	private String loc;

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
