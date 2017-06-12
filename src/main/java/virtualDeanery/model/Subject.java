package virtualDeanery.model;

public class Subject {

	private String acronym_subject;
	private String name;
	private int hours;
	private int ects;
	private String semester_code;
	public String getAcronym_subject() {
		return acronym_subject;
	}
	public void setAcronym_subject(String acronym_subject) {
		this.acronym_subject = acronym_subject;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getEcts() {
		return ects;
	}
	public void setEcts(int ects) {
		this.ects = ects;
	}
	public String getSemester_code() {
		return semester_code;
	}
	public void setSemester_code(String semester_code) {
		this.semester_code = semester_code;
	}
	
	public String toString(){
		return name;
	}
	
	
	
}
