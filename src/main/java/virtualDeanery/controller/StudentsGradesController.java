package virtualDeanery.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import virtualDeanery.model.Group;
import virtualDeanery.model.Mark;
import virtualDeanery.model.StudentsMarks;
import virtualDeanery.model.Subject;
import virtualDeanery.model.User;
import virtualDeanery.service.GradesService;

@Controller
public class StudentsGradesController
{
	
	@Autowired
	GradesService gradesService;
	
	String acronymSub;
	List<StudentsMarks> studentsMarks = new LinkedList<StudentsMarks>();
	
	@RequestMapping("/studentsGrades")
	public String studentsGradesController(Model model)
	{
		return "studentsGrades";
	}
	
	@RequestMapping(value = "/showSubjects", method = RequestMethod.POST)
	public String showSubjects(@RequestParam String semesterCode, HttpSession session, Model model) {
		studentsMarks.clear();
		User user = (User) session.getAttribute("loggedInUser");
		
		List<Subject> subjectsList = gradesService.showSubjectsFormSemester(semesterCode, user.getId());
		//List<String> subjectsListString = new LinkedList<String>();
		
				
		if(subjectsList.isEmpty()){
			model.addAttribute("error","Brak przedmiotów do wyœwietlenia");
			return "studentsGrades";
		}
		
		for(Subject s1: subjectsList){
			for(Subject s2: subjectsList)
				if(s1.getAcronym_subject().equals(s2.getAcronym_subject())){
					subjectsList.remove(s2);
				}
		}
		
		model.addAttribute("instructorSubjects",subjectsList);
		return "studentsGrades";

	}
	
	@RequestMapping(value = "/cSubject", method=RequestMethod.POST)
	public String showGroups(@RequestParam String cSub, HttpSession session, Model model){
		acronymSub = cSub;
		System.out.println("cSUB: " + cSub);
		User user = (User) session.getAttribute("loggedInUser");
		
		List<Group> groups = gradesService.getGroupsForSubject(cSub);
		
		
		
		for(Group g: groups){
			System.out.println(g.getGroup_id());
		}
		
		model.addAttribute("groupsList", groups);
		return "studentsGrades";

	} 
	
	@RequestMapping(value = "/cGroups", method=RequestMethod.POST)
	public String showStudents(@RequestParam String cGroup, HttpSession session, Model model){
		System.out.println("cGroup: " + cGroup);
		List<User> studentsList = gradesService.showStudentsForGroup(cGroup);
		studentsMarks.clear();
		System.out.println("SIZE SM:::: " + studentsMarks.size());		
		List<Mark> marks = gradesService.getMarksForStudents(studentsList, acronymSub);
		
		
		studentsMarks = gradesService.getStudentsMarks(studentsList, marks);
		
		for(StudentsMarks sm: studentsMarks){
			System.out.println(sm.getFirstname() + " " + sm.getLastname() + " " + sm.getMark());
		}
		
		model.addAttribute("studentsList", studentsList);
		model.addAttribute("marksList", marks);
		model.addAttribute("studentsMarks", studentsMarks);
		
		return "studentsGrades2";
	}
	
	@RequestMapping(value = "/saveGrades", method=RequestMethod.POST)
	public String saveGrades(@RequestParam String studentMark, HttpSession session, Model model){
		
		System.out.println(studentMark);
		
		List<Double> newMarks = new LinkedList<Double>();
		
		System.out.println(studentMark.charAt(studentMark.length()-1));
		
		if(studentMark.charAt(studentMark.length()-1) == ','){
			System.out.println("jestem w warunku");
			studentMark = (studentMark + "0.0,");
		}
		System.out.println(studentMark);
		
		
		String[] tempStudentMark = studentMark.split(",");
		
		System.out.println("temp size: " + tempStudentMark.length);
		for(String mark: tempStudentMark){
			if(mark.isEmpty() || mark == null || mark.equals(""))
				newMarks.add(0.0);
			else
				newMarks.add(Double.parseDouble(mark));
		}
		
		for(Double nm: newMarks){
			System.out.println("Ocena: " + nm);
		}
		
		gradesService.saveMarksForGroup(studentsMarks, newMarks);
		
		
		return "studentsGrades";	
	}
	
	

}
