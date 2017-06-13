package virtualDeanery.model.repository.impl;

import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import virtualDeanery.model.Group;
import virtualDeanery.model.Group_User;
import virtualDeanery.model.Mark;
import virtualDeanery.model.StudentsMarks;
import virtualDeanery.model.Subject;
import virtualDeanery.model.User;
import virtualDeanery.model.repository.GradesRepository;


@Repository
public class GradesRepositoryImpl implements GradesRepository{
	
	@Autowired
	DataSource datasource;
	List<Group> groups = null;
	
	
	private SessionFactory sessionFactory;

	@Autowired
	public GradesRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@SuppressWarnings({ "unchecked", "null" })
	@Transactional
	public List<Subject> showSubjectsFormSemester(String semesterCode, int userNiu) {
		
		
		List<Subject> subjects = new LinkedList<Subject>();
		List<Subject> tempSubjects = null;		
		
		tempSubjects = sessionFactory.getCurrentSession().createCriteria(Subject.class).add(Restrictions.like("semester_code", semesterCode)).list();
		groups = sessionFactory.getCurrentSession().createCriteria(Group.class).add(Restrictions.eq("niu_instructor", new Integer(userNiu))).list();
		
		for(Subject s: tempSubjects){
			for(Group g: groups){
				if(s.getAcronym_subject().equals(g.getAcronym_subject())){
					subjects.add(s);
				}
			}			
		}
		return subjects;
	}
	
		
	public List<Group> getGroupsForSubject(String acronymSubject) {
		List<Group> tempGroups = new LinkedList<Group>();
		
		for(Group g: groups){
			if(g.getAcronym_subject().equals(acronymSubject)){
				tempGroups.add(g);
			}
				
		}
		
		return tempGroups;
	}
	
	@SuppressWarnings({ "unchecked", "null" })
	@Transactional
	public List<User> getStudentsForGroup(String cGroup){
		System.out.println("jestem w getStudents!" + cGroup);
		List<User> studentsList = new LinkedList<User>();
		
		List<Group_User> groupUsers;		
		
		groupUsers = sessionFactory.getCurrentSession().createCriteria(Group_User.class).add(Restrictions.like("group_id", cGroup)).list();
		
		
		for(Group_User gu: groupUsers){
			studentsList.addAll(sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.like("niu", gu.getNiu())).list());
			System.out.println("NIU: " + gu.getNiu());
		}
				
		return studentsList;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Mark> getMarksForStudents(List<User> studentsList, String acronymSub){
						
		List<Mark> marks = new LinkedList<Mark>();
		
		for(User stL: studentsList){
			marks.addAll(sessionFactory.getCurrentSession().createCriteria(Mark.class).add(Restrictions.like("niu", stL.getId())).add(Restrictions.like("acronym_subject", acronymSub)).list());
		}
		
		for(Mark m: marks){
			System.out.println(m.getMarkID() + "  " + m.getAcronym_subject()+ "  " + m.getMark());
		}
					
		
		return marks;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void getMarksForStudents(List<StudentsMarks> studentsMarks, List<Double> newMarks) {
		
		int counter = 0;
		for(StudentsMarks sm: studentsMarks){
			System.out.println("newMarks counte: "  + newMarks.get(counter));
			if(newMarks.get(counter) > 1.0){
				List<Mark> temp2Mark = sessionFactory.getCurrentSession().createCriteria(Mark.class).add(Restrictions.like("niu", sm.getNiu())).add(Restrictions.like("acronym_subject", sm.getAcronym_subject())).list();
				Mark tempMark = null;
				if(temp2Mark.size() > 0){
				   tempMark = temp2Mark.get(0);
				}
				if(tempMark == null)
					sessionFactory.getCurrentSession().merge(new Mark(sm.getNiu(), sm.getAcronym_subject(), newMarks.get(counter)));
				else
					sessionFactory.getCurrentSession().merge(new Mark(tempMark.getMarkID(), sm.getNiu(), sm.getAcronym_subject(), newMarks.get(counter)));
			}
			counter++;
		}
		
		System.out.println("zapisa³em!");
		
	}
	
	
	

}
