package virtualDeanery.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import virtualDeanery.model.Group;
import virtualDeanery.model.Mark;
import virtualDeanery.model.StudentsMarks;
import virtualDeanery.model.Subject;
import virtualDeanery.model.User;
import virtualDeanery.service.GradesService;
import virtualDeanery.model.repository.GradesRepository;


@Service
public class GradesServiceImpl  implements GradesService{
	
	
	@Autowired
	GradesRepository gradesRepository;

	public List<Subject> showSubjectsFormSemester(String semesterCode, int userNiu) {
		// TODO Auto-generated method stub
		return gradesRepository.showSubjectsFormSemester(semesterCode, userNiu);
	}


	public List<Group> getGroupsForSubject(String acronymSubject) {
		// TODO Auto-generated method stub
		return  gradesRepository.getGroupsForSubject(acronymSubject);
	}
	
	public List<User> showStudentsForGroup(String cGroup){
		
		return gradesRepository.getStudentsForGroup(cGroup);
	}


	public List<Mark> getMarksForStudents(List<User> studentsList, String acronymSub) {
		// TODO Auto-generated method stub
		return  gradesRepository.getMarksForStudents(studentsList, acronymSub);
	}


	public List<StudentsMarks> getStudentsMarks(List<User> studentsList, List<Mark> marksList) {
		List<StudentsMarks> studentsMarksList = new LinkedList<StudentsMarks>();
		int counter = 0;
		
		for(User stL: studentsList){
			if(stL.getId() == marksList.get(counter).getNiu())
				studentsMarksList.add(new StudentsMarks(stL.getId(), stL.getFirstname(), stL.getLastname(), marksList.get(counter).getAcronym_subject(), marksList.get(counter).getMark()));
			else
				studentsMarksList.add(new StudentsMarks(stL.getId(), stL.getFirstname(), stL.getLastname(), marksList.get(counter).getAcronym_subject(), 0.));
			if(counter < marksList.size()-1){
				counter++;	
			}
					
		}
		
		return studentsMarksList;
	}


	public void saveMarksForGroup(List<StudentsMarks> studentsMarks, List<Double> newMarks) {
		// TODO Auto-generated method stub
		gradesRepository.getMarksForStudents(studentsMarks, newMarks);
	}

}
