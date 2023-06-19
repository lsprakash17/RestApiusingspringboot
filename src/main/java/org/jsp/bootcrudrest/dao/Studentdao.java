package org.jsp.bootcrudrest.dao;

import java.util.List;
import java.util.Optional;

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
	public List<Student> save(List<Student> list) 
	{
      return repository.saveAll(list);		
	}

	public Student fetch(int id) {
//		Optional<Student> op=repository.findById(id);
//		if(op.isPresent())
//			return op.get();
//		else
//			return null;
		return repository.findById(id).orElse(null);
	}

	public void delete(int id) {
        repository.deleteById(id);
	}
}
