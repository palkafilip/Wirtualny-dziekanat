package virtualDeanery.model.repository;

import java.util.List;

import virtualDeanery.model.Group;
import virtualDeanery.model.Mark;
import virtualDeanery.model.StudentsMarks;
import virtualDeanery.model.Subject;
import virtualDeanery.model.User;

public interface GradesRepository {
		
	public List<Subject> showSubjectsFormSemester(String semesterCode, int userNiu);	
	public List<Group> getGroupsForSubject(String acronymSubject);
	public List<User> getStudentsForGroup(String cGroup);
	public List<Mark> getMarksForStudents(List<User> studentsList, String acronymSub);
	public void getMarksForStudents(List<StudentsMarks> studentsMarks, List<Double> newMarks);
}
