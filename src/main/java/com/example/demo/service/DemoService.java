package com.example.demo.service;

import java.text.ParseException;

import com.example.demo.dao.entity.Student;
import com.example.demo.exception.BusinessException;

public interface DemoService {
	
	public Student getStudentInfo(Integer id) throws BusinessException;
	public void createStudentInfo(Student info) throws BusinessException, ParseException;
	public void udateStudentInfo(Student info);
	public void deleteStudentInfo(Integer id);

}
