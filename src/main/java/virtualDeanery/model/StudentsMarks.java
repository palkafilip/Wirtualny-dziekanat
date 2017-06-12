package virtualDeanery.model;

public class StudentsMarks {
	public StudentsMarks(int niu, String firstname, String lastname, String acronym_subject,
			double mark) {		
		
		this.niu = niu;
		this.firstname = firstname;
		this.lastname = lastname;
		this.acronym_subject = acronym_subject;
		this.mark = mark;
	}
	private int markID;
	private int niu;
	private String firstname;
    private String lastname;
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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
