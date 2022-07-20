package com.example.demo.dao.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_studentone", schema = "sc_arya")
@Setter
@Getter
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "code")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer code;

	@Column(name = "name")
	private String name;
    
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "dept", nullable=false)
	 */
	private DepartmentEntity deptCode;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public DepartmentEntity getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(DepartmentEntity deptCode) {
		this.deptCode = deptCode;
	}

}
