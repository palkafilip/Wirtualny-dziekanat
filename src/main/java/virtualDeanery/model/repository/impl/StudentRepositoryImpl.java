package virtualDeanery.model.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import virtualDeanery.model.Student;
import virtualDeanery.model.repository.StudentRepository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

	@Autowired
	DataSource datasource;
	private List<Student> listOfStudents = new ArrayList<Student>();

	public List<Student> getAllStudents() {
		listOfStudents.clear();
		
		String sql = "SELECT * FROM student";

		Connection conn = null;

		try {
			
			conn = datasource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			Student student = null;
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
					student = new Student(rs.getString("imie"), rs.getString("nazwisko"), rs.getString("adres"),
							rs.getString("email"), rs.getString("pesel"), rs.getString("numerTel"));
					listOfStudents.add(student);
			}
			
			
			rs.close();
			ps.close();
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return listOfStudents;
	}

}
