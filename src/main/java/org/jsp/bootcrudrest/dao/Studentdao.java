package org.jsp.bootcrudrest.dao;

import java.util.List;
import org.jsp.bootcrudrest.dto.Student;
import org.jsp.bootcrudrest.repository.Studentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Studentdao 
{
	@Autowired 
	 Studentrepository repository;
	
	public Student save(Student student)
	{
	  return repository.save(student);
	}

	public List<Student> fetchall() {
		
		return repository.findAll();
	}
}
