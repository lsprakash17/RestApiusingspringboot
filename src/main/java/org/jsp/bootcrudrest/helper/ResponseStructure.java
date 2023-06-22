package org.jsp.bootcrudrest.helper;

import lombok.Data;


@Data
public class ResponseStructure<Student>
{
String message;
int status;
Student data;
}
