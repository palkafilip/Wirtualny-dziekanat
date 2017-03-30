package virtualDeanery.model.repository;

import java.util.List;

import virtualDeanery.model.Student;

public interface StudentRepository
{
	List <Student> getAllStudents();
	void addStudent(Student student);
	Student getStudentByPesel(String pesel);
}
