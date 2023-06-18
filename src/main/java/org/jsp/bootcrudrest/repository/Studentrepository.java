package org.jsp.bootcrudrest.repository;

import org.jsp.bootcrudrest.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Studentrepository extends JpaRepository<Student, Integer>
//implementation class simple JPA repository 
{

}
