package virtualDeanery.model.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import virtualDeanery.model.Student;
import virtualDeanery.model.repository.StudentRepository;


@Repository
public class StudentRepositoryImpl implements StudentRepository
{

private List<Student> listOfStudents = new ArrayList<Student>();
	
	public StudentRepositoryImpl()
	{
		Student student1 = new Student("Filip", "Pa³ka", "Krakow ul. Rydla", "filip@palka.com", 123456789, 333222111);
		Student student2 = new Student("Mateusz", "G³adysz", "Krakow ul. Rydla", "mateusz@gladysz.com", 123456789, 333222111);
		
		listOfStudents.add(student1);
		listOfStudents.add(student2);
	}

	public List<Student> getAllStudents()
	{
		return listOfStudents;
	}


}
