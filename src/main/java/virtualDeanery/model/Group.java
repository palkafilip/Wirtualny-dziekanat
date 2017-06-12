package virtualDeanery.model;

public class Group {
	private String group_id;
	private String acronym_subject;
	private String time;
	private int niu_instructor;
	
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public String getAcronym_subject() {
		return acronym_subject;
	}
	public void setAcronym_subject(String acronym_subject) {
		this.acronym_subject = acronym_subject;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getNiu_instructor() {
		return niu_instructor;
	}
	public void setNiu_instructor(int niu_instructor) {
		this.niu_instructor = niu_instructor;
	}
	

}
