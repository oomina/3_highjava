package kr.or.redplus.vo;

public class Blood_stockVO {
	private String bs_blood_type;
	private String store_day;
	private String release_day;
	private String dt_type;
	private String bdh_id;
	private String bd_code;
	private String bd_region;
	
	public String getBd_region() {
		return bd_region;
	}
	public void setBd_region(String bd_region) {
		this.bd_region = bd_region;
	}
	public String getBs_blood_type() {
		return bs_blood_type;
	}
	public void setBs_blood_type(String bs_blood_type) {
		this.bs_blood_type = bs_blood_type;
	}
	public String getStore_day() {
		return store_day;
	}
	public void setStore_day(String store_day) {
		this.store_day = store_day;
	}
	public String getRelease_day() {
		return release_day;
	}
	public void setRelease_day(String release_day) {
		this.release_day = release_day;
	}
	public String getDt_type() {
		return dt_type;
	}
	public void setDt_type(String dt_type) {
		this.dt_type = dt_type;
	}
	public String getBdh_id() {
		return bdh_id;
	}
	public void setBdh_id(String bdh_id) {
		this.bdh_id = bdh_id;
	}
	public String getBd_code() {
		return bd_code;
	}
	public void setBd_code(String bd_code) {
		this.bd_code = bd_code;
	}
	
}
