package VO;

import java.util.Date;

public class InprogressVO {
	
	private String vt_id;
	private String vt_name;
	private String vt_img_name;
	private String vt_img_path;
	private String vt_ag_name;
	private int vt_total_num;
	private int vt_ag_num;
	private int vt_dag_num;
	private Date vt_indate;
	private Date vt_stdate;
	private Date vt_enddate;
	private String vt_type;
	private String vt_dtype;
	
	public InprogressVO(String vt_id, String vt_name, String vt_img_name, String vt_img_path, String vt_ag_name,
	int vt_total_num, int vt_ag_num, int vt_dag_num, Date vt_indate, Date vt_stdate, Date vt_enddate, String vt_type, String vt_dtype) {
		super();
		this.vt_id = vt_id;
		this.vt_name = vt_name;
		this.vt_img_name = vt_img_name;
		this.vt_img_path = vt_img_path;
		this.vt_ag_name = vt_ag_name;
		this.vt_total_num = vt_total_num;
		this.vt_ag_num = vt_ag_num;
		this.vt_dag_num = vt_dag_num;
		this.vt_indate = vt_indate;
		this.vt_stdate = vt_stdate;
		this.vt_enddate = vt_enddate;
		this.vt_type = vt_type;
		this.vt_dtype = vt_dtype;		
	}
	
	public InprogressVO() {
	}

	public String getVt_id() {
		return vt_id;
	}

	public void setVt_id(String vt_id) {
		this.vt_id = vt_id;
	}

	public String getVt_name() {
		return vt_name;
	}

	public void setVt_name(String vt_name) {
		this.vt_name = vt_name;
	}

	public String getVt_img_name() {
		return vt_img_name;
	}

	public void setVt_img_name(String vt_img_name) {
		this.vt_img_name = vt_img_name;
	}

	public String getVt_img_path() {
		return vt_img_path;
	}

	public void setVt_img_path(String vt_img_path) {
		this.vt_img_path = vt_img_path;
	}

	public String getVt_ag_name() {
		return vt_ag_name;
	}

	public void setVt_ag_name(String vt_ag_name) {
		this.vt_ag_name = vt_ag_name;
	}

	public int getVt_total_num() {
		return vt_total_num;
	}

	public void setVt_total_num(int vt_total_num) {
		this.vt_total_num = vt_total_num;
	}

	public int getVt_ag_num() {
		return vt_ag_num;
	}

	public void setVt_ag_num(int vt_ag_num) {
		this.vt_ag_num = vt_ag_num;
	}

	public int getVt_dag_num() {
		return vt_dag_num;
	}

	public void setVt_dag_num(int vt_dag_num) {
		this.vt_dag_num = vt_dag_num;
	}

	public Date getVt_indate() {
		return vt_indate;
	}

	public void setVt_indate(Date vt_indate) {
		this.vt_indate = vt_indate;
	}

	public Date getVt_stdate() {
		return vt_stdate;
	}

	public void setVt_stdate(Date vt_stdate) {
		this.vt_stdate = vt_stdate;
	}

	public Date getVt_enddate() {
		return vt_enddate;
	}

	public void setVt_enddate(Date vt_enddate) {
		this.vt_enddate = vt_enddate;
	}

	public String getVt_type() {
		return vt_type;
	}

	public void setVt_type(String vt_type) {
		this.vt_type = vt_type;
	}

	public String getVt_dtype() {
		return vt_dtype;
	}

	public void setVt_dtype(String vt_dtype) {
		this.vt_dtype = vt_dtype;
	}

	@Override
	public String toString() {
		return "InprogressVO [vt_id=" + vt_id + ", vt_name=" + vt_name + ", vt_img_name=" + vt_img_name
				+ ", vt_img_path=" + vt_img_path + ", vt_ag_name=" + vt_ag_name + ", vt_total_num=" + vt_total_num
				+ ", vt_ag_num=" + vt_ag_num + ", vt_dag_num=" + vt_dag_num + ", vt_indate=" + vt_indate
				+ ", vt_stdate=" + vt_stdate + ", vt_enddate=" + vt_enddate + ", vt_type=" + vt_type + ", vt_dtype="
				+ vt_dtype + "]";
	}
	//추가된 부분 --------------------------------
	public long getDday() {
		Date now = new Date();
		long nowTime = now.getTime();
		long diffSec = (this.vt_enddate.getTime() - nowTime)/1000;
		long diffDay = diffSec/(24*60*60);
		if(diffDay > -1 && diffDay < 0) {
			diffDay = 0;
		}
		System.out.println("diffDay : " + diffDay);
		return diffDay;
	}
	public String getWonSurv() {
		String won = null;
		
		if(this.vt_ag_num > this.vt_dag_num) {
			won="호";
		} else {
			won="불호";
		}
		
		return won;
	}
	
	public int getGapSurv() {
		int gap = 0;
		
		if(this.vt_ag_num > this.vt_dag_num) {
			gap = this.vt_ag_num - this.vt_dag_num;
		} else {
			gap = this.vt_dag_num - this.vt_ag_num;
		}
		
		return gap;
	}
	
	public float getPercentSurv() {
		float percent = 0.00f;
		
		if(this.vt_ag_num > this.vt_dag_num) {
			percent = (vt_ag_num*100)/vt_total_num;
		} else if(this.vt_ag_num < this.vt_dag_num) {
			percent = (vt_dag_num*100)/vt_total_num;
		} else if(this.vt_ag_num == this.vt_dag_num) {
			percent = 0;
		} else {
			percent = 0;
		}
		
		return percent;
	}
}
