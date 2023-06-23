package org.jsp.bootcrudrest.helper;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;


@Data
public class ResponseStructure<T>
{
String message;
int status;
T data;
}
