package virtualDeanery.service;

import java.util.List;

import virtualDeanery.model.Group;
import virtualDeanery.model.Mark;
import virtualDeanery.model.StudentsMarks;
import virtualDeanery.model.Subject;
import virtualDeanery.model.User;

public interface GradesService {
		
	public List<Subject> showSubjectsFormSemester(String semesterCode, int userNiu);
	

	public List<Group> getGroupsForSubject(String acronymSubject);

	public List<User> showStudentsForGroup(String cGroup);


	public List<Mark> getMarksForStudents(List<User> studentsList, String acronymSub);
	
	public List<StudentsMarks> getStudentsMarks(List<User> studentsList, List<Mark> marksList);


	public void saveMarksForGroup(List<StudentsMarks> studentsMarks, List<Double> newMarks);
}
