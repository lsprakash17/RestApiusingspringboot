package org.jsp.bootcrudrest.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsp.bootcrudrest.dao.Studentdao;
import org.jsp.bootcrudrest.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Studentservice
{
	@Autowired
	Studentdao dao;
public Student save(Student student)
{

	int total=(student.getMathematics()+student.getComputerscience()+student.getPhysics());
	student.setTotal(total);
	double percentage=total/3.0;
	student.setPercentage(percentage);
	if(student.getPhysics() <35 || student.getComputerscience()<35 || student.getMathematics()<35)
	{
		student.setResult("Fail");
	}
	else {
		if(percentage>85)
			student.setResult("Distinction");
		else if(percentage>60)
			student.setResult("First Class");
		else
			student.setResult("Second Class");
	}
	return dao.save(student);
}
public List<Student> save(List<Student> list)
{
	for(Student student:list)
	{
		int total=(student.getMathematics()+student.getComputerscience()+student.getPhysics());
		student.setTotal(total);
		double percentage=total/3.0;
		student.setPercentage(percentage);
		if(student.getPhysics() <35 || student.getComputerscience()<35 || student.getMathematics()<35)
		{
			student.setResult("Fail");
		}
		else {
			if(percentage>85)
				student.setResult("Distinction");
			else if(percentage>60)
				student.setResult("First Class");
			else
				student.setResult("Second Class");
		}	
	}
	return dao.save(list);
}
public List<Student> fetchall() {
	return dao.fetchall();
}
public Student fetch(int id){
	return dao.fetch(id);
}

public void delete(int id) {
	dao.delete(id);
}
}
