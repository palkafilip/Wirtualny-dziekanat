package virtualDeanery.model;

public class Message {
	
	private int msg_id;
	private String title;
	private String content;
	private String send_date;
	private int niu_sender;
	
	public int getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(int msg_id) {
		this.msg_id = msg_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSend_date() {
		return send_date;
	}
	public void setSend_date(String send_date) {
		this.send_date = send_date;
	}
	public int getNiu_sender() {
		return niu_sender;
	}
	public void setNiu_sender(int niu_sender) {
		this.niu_sender = niu_sender;
	}
	
	
	@Override
	public String toString() {
		return "Message [msg_id=" + msg_id + ", title=" + title + ", content=" + content + ", send_date=" + send_date
				+ ", niu_sender=" + niu_sender + "]";
	}
	
}
