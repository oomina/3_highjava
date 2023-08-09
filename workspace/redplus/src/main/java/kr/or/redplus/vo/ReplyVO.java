package kr.or.redplus.vo;

public class ReplyVO {
	String reply_code   ;	// 댓글 코드
	String client_id    ;	// 작성자
	String board_code   ;	// 글 코드
	String reply_content;	// 댓글
	String reply_date   ;	// 작성일
	String reply_modify ;	// 수정일
	
	public String getReply_code() {
		return reply_code;
	}
	public void setReply_code(String reply_code) {
		this.reply_code = reply_code;
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getBoard_code() {
		return board_code;
	}
	public void setBoard_code(String board_code) {
		this.board_code = board_code;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getReply_date() {
		return reply_date;
	}
	public void setReply_date(String reply_date) {
		this.reply_date = reply_date;
	}
	public String getReply_modify() {
		return reply_modify;
	}
	public void setReply_modify(String reply_modify) {
		this.reply_modify = reply_modify;
	}
	
	
}
