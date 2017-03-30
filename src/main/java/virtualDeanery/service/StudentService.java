package virtualDeanery.service;

import java.util.List;

import virtualDeanery.model.Student;

public interface StudentService
{
	List <Student> getAllStudents();
	void addStudent(Student student);
	Student getStudentByPesel(String pesel);
}
