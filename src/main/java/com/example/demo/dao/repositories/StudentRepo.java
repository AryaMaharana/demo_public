package com.example.demo.dao.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.entity.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer>, JpaSpecificationExecutor<Student>{

}
