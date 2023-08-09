package kr.or.redplus.vo.bdhres;

public class BdhResVO {
	private String res_code; // 예약코드
	private String res_type; // 헌혈종류
	private String res_date; // 헌혈예약한 날짜
	private String eq_code;  // 전자문진코드
	private String mem_id;   // 회원아이디
	private String bdh_id;   // 혈액원아이디
	private String day_code; // 날짜
	private String time_code; //
	private int max_user; // 최대인원수
	private int cnt_user; // 현재인원수
	private String client_id; // 헌혈의집 아이디
	private String client_name; // 헌혈의집 이름
	private String client_tel; // 헌혈의집 번호
	private String client_addr; // 헌혈의집 주수
	private String bdh_region; // 헌혈의집 지역
	private String year; // 년
	private String month; // 월
	private String day; // 일
	private String dt_type; // 헌혈종류(기본값)
	private String mem_regno1;
	private String res_able; // 다음 헌혈가능일
	private String dt_period;
	private String bb_name;
	private String dd_able; // 마지막 지정헌혈 예약일
	
	public String getDd_able() {
		return dd_able;
	}
	public void setDd_able(String dd_able) {
		this.dd_able = dd_able;
	}
	public String getBb_name() {
		return bb_name;
	}
	public void setBb_name(String bb_name) {
		this.bb_name = bb_name;
	}
	public String getBdh_name() {
		return bdh_name;
	}
	public void setBdh_name(String bdh_name) {
		this.bdh_name = bdh_name;
	}
	private String bdh_name;
	
	
	public String getDt_period() {
		return dt_period;
	}
	public void setDt_period(String dt_period) {
		this.dt_period = dt_period;
	}
	public String getRes_able() {
		return res_able;
	}
	public void setRes_able(String res_able) {
		this.res_able = res_able;
	}
	public String getMem_regno1() {
		return mem_regno1;
	}
	public void setMem_regno1(String mem_regno1) {
		this.mem_regno1 = mem_regno1;
	}
	public int getMax_user() {
		return max_user;
	}
	public void setMax_user(int max_user) {
		this.max_user = max_user;
	}
	public int getCnt_user() {
		return cnt_user;
	}
	public void setCnt_user(int cnt_user) {
		this.cnt_user = cnt_user;
	}
	public String getDt_type() {
		return dt_type;
	}
	public void setDt_type(String dt_type) {
		this.dt_type = dt_type;
	}
	public String getRes_code() {
		return res_code;
	}
	public void setRes_code(String res_code) {
		this.res_code = res_code;
	}
	public String getRes_type() {
		return res_type;
	}
	public void setRes_type(String res_type) {
		this.res_type = res_type;
	}
	public String getRes_date() {
		return res_date;
	}
	public void setRes_date(String res_date) {
		this.res_date = res_date;
	}
	public String getEq_code() {
		return eq_code;
	}
	public void setEq_code(String eq_code) {
		this.eq_code = eq_code;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getBdh_id() {
		return bdh_id;
	}
	public void setBdh_id(String bdh_id) {
		this.bdh_id = bdh_id;
	}
	public String getDay_code() {
		return day_code;
	}
	public void setDay_code(String day_code) {
		this.day_code = day_code;
	}
	public String getTime_code() {
		return time_code;
	}
	public void setTime_code(String time_code) {
		this.time_code = time_code;
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public String getClient_tel() {
		return client_tel;
	}
	public void setClient_tel(String client_tel) {
		this.client_tel = client_tel;
	}
	public String getClient_addr() {
		return client_addr;
	}
	public void setClient_addr(String client_addr) {
		this.client_addr = client_addr;
	}
	public String getBdh_region() {
		return bdh_region;
	}
	public void setBdh_region(String bdh_region) {
		this.bdh_region = bdh_region;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	
}
