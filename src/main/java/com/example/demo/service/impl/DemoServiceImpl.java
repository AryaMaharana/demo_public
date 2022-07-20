package com.example.demo.service.impl;

import java.text.ParseException;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.entity.DepartmentEntity;
import com.example.demo.dao.entity.Student;
import com.example.demo.dao.repositories.AddressRepo;
import com.example.demo.dao.repositories.DeptRepo;
import com.example.demo.dao.repositories.StudentRepo;
import com.example.demo.exception.BusinessException;
import com.example.demo.mapping.StudentMapping;
import com.example.demo.service.DemoService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DemoServiceImpl implements DemoService {

	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private DeptRepo deptRepo;
	
	@Autowired
	private AddressRepo addressRepo;

	@Override
	public Student getStudentInfo(Integer id) throws BusinessException {
		Optional<Student> getStudent = studentRepo.findById(id);
		Student getList = new Student();
		if (getStudent.isPresent()) {
			getList = getStudent.get();
		}
		
		
		return getList;
	}

	@Override
	public void createStudentInfo(Student info) throws BusinessException, ParseException {
               System.out.println(info);
		Student saveStudent = new Student();
		
		if (Objects.nonNull(info)) {
			BeanUtils.copyProperties(info, saveStudent);
			studentRepo.save(saveStudent);
		}

	}

	@Override
	public void udateStudentInfo(Student info) {
		if (Objects.nonNull(info)) {
			Optional<Student> getStudent = studentRepo.findById(info.getCode());
			if (getStudent.isPresent()) {
				studentRepo.save(StudentMapping.studentEntityMap(getStudent.get(), info));
			}
		}
	}

	@Override
	public void deleteStudentInfo(Integer id) {
		if (Objects.nonNull(id)) {
			studentRepo.deleteById(id);
		}

	}

}
