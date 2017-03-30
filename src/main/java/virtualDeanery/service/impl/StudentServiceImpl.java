package virtualDeanery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import virtualDeanery.model.Student;
import virtualDeanery.model.repository.StudentRepository;
import virtualDeanery.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService
{

	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> getAllStudents()
	{
		return studentRepository.getAllStudents();
	}

	public void addStudent(Student student)
	{
		studentRepository.addStudent(student);
		
	}

	public Student getStudentByPesel(String pesel)
	{
		return studentRepository.getStudentByPesel(pesel);
	}

}
