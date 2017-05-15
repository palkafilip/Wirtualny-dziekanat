package virtualDeanery.model;

public class Msg_recipient {
	
	private int niu_recipient;
	private int msg_id;
	private int is_read;
	
	public int getNiu_recipient() {
		return niu_recipient;
	}
	public void setNiu_recipient(int niu_recipient) {
		this.niu_recipient = niu_recipient;
	}
	public int getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(int msg_id) {
		this.msg_id = msg_id;
	}
	public int isIs_read() {
		return is_read;
	}
	public void setIs_read(int is_read) {
		this.is_read = is_read;
	}
	
	@Override
	public String toString() {
		return "msg_recipient [niu_recipient=" + niu_recipient + ", msg_id=" + msg_id + ", is_read=" + is_read + "]";
	}
	
	

}
