package virtualDeanery.model;

public class Mark {

	private int markID;
	private int niu;
	private String acronym_subject;
	private double mark;
	
	public int getMarkID() {
		return markID;
	}
	public void setMarkID(int markID) {
		this.markID = markID;
	}
	public int getNiu() {
		return niu;
	}
	public void setNiu(int niu) {
		this.niu = niu;
	}
	public String getAcronym_subject() {
		return acronym_subject;
	}
	public void setAcronym_subject(String acronym_subject) {
		this.acronym_subject = acronym_subject;
	}
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}
	
}
