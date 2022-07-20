package com.example.demo.mapping;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.example.demo.dao.entity.DepartmentEntity;
import com.example.demo.dao.entity.Student;

public class StudentMapping {
	
	public static Student studentEntityMap(Student entity, Student request) {
		Student getStudent = new Student();
		BeanUtils.copyProperties(entity, getStudent);
		if(Objects.nonNull(entity)) {
			getStudent.setAddress(request.getAddress());
			getStudent.setName(request.getName());
			
		}
		
		return getStudent;
	}

}
