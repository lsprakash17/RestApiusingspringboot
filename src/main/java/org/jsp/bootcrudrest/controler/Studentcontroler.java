package org.jsp.bootcrudrest.controler;

import java.util.List;

import org.jsp.bootcrudrest.dto.Student;
import org.jsp.bootcrudrest.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Studentcontroler 
{
	@Autowired
	Studentservice service;
	
 @PostMapping("students")
 public Student save(@RequestBody Student student)
 {
	 return  service.save(student);
 }
 @PostMapping("students/all")
 public List<Student> save(@RequestBody List<Student> student)
 {
	 return service.save(student);
 }
 
 @GetMapping("students/all")
 public  List<Student> fetch()
 {
	 return service.fetchall();
 }
 @GetMapping("students")
 public Student fetch(@RequestParam int id)
 {
	 return service.fetch(id);
 }
 @DeleteMapping("students/sid")
 public void delete(@RequestParam int id)
 {
     service.delete(id);
 }

}
