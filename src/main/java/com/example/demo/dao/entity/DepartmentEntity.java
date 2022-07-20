package com.example.demo.dao.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_dept", schema = "sc_arya")
@Setter
@Getter
public class DepartmentEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7922534663866320555L;
	
	@Id
	@Column(name = "dept_code")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deptCode;
	
	@Column(name = "dept_name")
	private String deptName;
	
	@Column(name = "count")
	private Integer count;
	
	@OneToMany(mappedBy = "deptCode", cascade = CascadeType.ALL)
	private List<Student> studentName = new ArrayList<>();

	public Integer getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(Integer deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<Student> getStudentName() {
		return studentName;
	}

	public void setStudentName(List<Student> studentName) {
		this.studentName = studentName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(count, deptCode, deptName, studentName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartmentEntity other = (DepartmentEntity) obj;
		return Objects.equals(count, other.count) && Objects.equals(deptCode, other.deptCode)
				&& Objects.equals(deptName, other.deptName) && Objects.equals(studentName, other.studentName);
	}

	@Override
	public String toString() {
		return "DepartmentEntity [deptCode=" + deptCode + ", deptName=" + deptName + ", count=" + count
				+ ", studentName=" + studentName + "]";
	}

}
