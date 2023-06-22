package org.jsp.bootcrudrest.service;
import java.util.List;
import org.jsp.bootcrudrest.dao.Studentdao;
import org.jsp.bootcrudrest.dto.Student;
import org.jsp.bootcrudrest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Studentservice
{
	@Autowired
	Studentdao dao;
	@Autowired
	Student dto;
	@Autowired
	StudentRepository repository;
	
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
public List<Student> fetchbyname(String name) {
	return dao.fetchbyname(name);
}
public List<Student> fetchbymobile(long mobile) {
	
	return dao.fetchbymobile(mobile);
}

public List<Student> Result(String result) {
	
	return dao.Result(result);
}
//public List<Student> findByMathssGreater(int marks) {
// return dao.findByMathsGreater(marks);
//}
//public List<Student> findByPhysicssGreater(int marks) {
//	return dao.findByPhysicsGreater(marks);
//}
public List<Student> findBySubject(String sub, int marks) {
	if(sub.equals("mathematics"))
		return dao.findByMathsGreater(marks);
	else if(sub.equals("physics"))
		return dao.findByPhysicsGreater(marks);
	else
		return dao.findByComputerscienceGreater(marks);
}
public List<Student> findByMinPhyAndMaxPhy(int minmark, int maxmark) {
 return dao. findByMinPhyAndMaxPhy(minmark,maxmark);
}
public Student updateUser(int id, Student student) {
	Student existingstudent = repository.findById(id).orElse(null);
	existingstudent.setMathematics(student.getMathematics());
	existingstudent.setComputerscience(student.getComputerscience());
	existingstudent.setPhysics(id);
	int total=(student.getMathematics()+student.getComputerscience()+student.getPhysics());
	existingstudent.setTotal(total);
	double percentage=total/3.0;
	existingstudent.setPercentage(percentage);
	if(existingstudent.getPhysics() <35 || existingstudent.getComputerscience()<35 || existingstudent.getMathematics()<35)
	{
		student.setResult("Fail");
	}
	else {
		if(percentage>85)
			existingstudent.setResult("Distinction");
		else if(percentage>60)
			existingstudent.setResult("First Class");
		else
			existingstudent.setResult("Second Class");
	}	
	return dao.save(existingstudent);
}
}