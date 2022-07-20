package com.example.demo.dao.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.entity.DepartmentEntity;

@Repository
public interface DeptRepo extends CrudRepository<DepartmentEntity, Integer> , JpaSpecificationExecutor<DepartmentEntity>{

}
