package virtualDeanery.model;

public class Group_User {
	
	private int ID_GU;
	private int niu;
	private String group_id;
	
	public int getNiu() {
		return niu;
	}
	public void setNiu(int niu) {
		this.niu = niu;
	}
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	
	@Override
	public String toString() {
		return "Group_User [niu=" + niu + ", group_id=" + group_id + "]";
	}

}
