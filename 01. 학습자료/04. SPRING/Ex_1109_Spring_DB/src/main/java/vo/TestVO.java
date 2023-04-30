package vo;

public class TestVO {
	
	/*	CAMEL표기법등의 처리가 없는 경우, DB 컬럼과 VO변수 명칭은 같아야한다. */
	private String test_no, test_nm, remark;
	private int disp_order;
	//
	public String getTest_no() {
		return test_no;
	}
	public void setTest_no(String test_no) {
		this.test_no = test_no;
	}
	public String getTest_nm() {
		return test_nm;
	}
	public void setTest_nm(String test_nm) {
		this.test_nm = test_nm;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getDisp_order() {
		return disp_order;
	}
	public void setDisp_order(int disp_order) {
		this.disp_order = disp_order;
	}

}
