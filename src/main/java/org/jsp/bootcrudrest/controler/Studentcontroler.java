package org.jsp.bootcrudrest.controler;

import java.util.List;

import org.jsp.bootcrudrest.dto.Student;
import org.jsp.bootcrudrest.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

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
 @GetMapping("students/{name}")
public List<Student>fetchbyname(@PathVariable String name)
{
	 return service.fetchbyname(name);
 
}
 @GetMapping("student/{mobile}")
 public List<Student> fetchbymobile(@PathVariable long mobile)
 
 {
	 return service.fetchbymobile(mobile);
 }
 @GetMapping("students/results/{result}")
 public List<Student> Result(@PathVariable String result)
 {
	 return service.Result(result);
 }
//@GetMapping("students/mathematics/{marks}")
//public List<Student> findByMathsGreater(@PathVariable int marks)
//{
//	 return service.findByMathssGreater(marks);
//}
//@GetMapping("students/physics/{marks}")
//public List<Student> findByphysicsGreater(@PathVariable int marks)
//{
//	 return service.findByPhysicssGreater(marks);
//}
 @GetMapping("students/{subject}/{marks}")
 public List<Student> findBySubject(@PathVariable String subject,@PathVariable int marks)
 {
	 return service.findBySubject(subject,marks);
 }
 @GetMapping("studentss/{minmark}/{maxmark}")
 public List<Student> findByMinPhyAndMaxPhy(@PathVariable int minmark ,@PathVariable int maxmark)
 {
	 return  service.findByMinPhyAndMaxPhy(minmark,maxmark);
 }
 @PutMapping("studentss/{id}")
 public Student edit(@PathVariable int id,@RequestBody Student student )
 {
	 return service.updateUser(id, student);
 }
 
}