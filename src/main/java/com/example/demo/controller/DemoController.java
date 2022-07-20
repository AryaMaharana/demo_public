package com.example.demo.controller;

import java.lang.invoke.MethodHandles;
import java.text.ParseException;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.entity.Student;
import com.example.demo.exception.AppExceptionHandler;
import com.example.demo.exception.BusinessException;
import com.example.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Validated
public class DemoController {
	Logger log = LoggerFactory.getLogger(DemoController.class);
	/*
	 * final String CLASS_NAME = this.getClass().getSimpleName(); final String ENTER
	 * = "ENTER"; final String EXIT = "EXIT";
	 */

	@Autowired
	private DemoService demoService;

	@GetMapping(value = "/hello/{id}")
	public String getAddress(@PathVariable("id") String name) {
		return "ID " + name;
	}

	@GetMapping(value = "/get")
	public ResponseEntity<Object> getAddressRequestParam(@Valid @RequestParam(name = "id", required = true) Integer id)
			throws BusinessException {
		log.info("getAddressRequestParam Entry");
		Student getStudent = new Student();

		getStudent = demoService.getStudentInfo(id);
		log.info("getAddressRequestParam Exit");
		return new ResponseEntity<>(getStudent, HttpStatus.OK);
	}

	@PostMapping(value = "/create")
	public ResponseEntity<Object> createAddressInfo(@Valid @RequestBody Student getStudentInfo)
			throws BusinessException {
		try {
			demoService.createStudentInfo(getStudentInfo);
		} catch (ConstraintViolationException | DataIntegrityViolationException | ParseException e) {
			throw new BusinessException("Error while inserting into Student table", "ERROR_01");
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<Object> udateStudentInfo(@Valid @RequestBody Student getStudentInfo) throws ParseException {
		try {
			demoService.udateStudentInfo(getStudentInfo);
		} catch (ConstraintViolationException | DataIntegrityViolationException e) {
			throw new BusinessException("Error while Update into Student table", "ERROR_02");
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<String> deleteStudentInfo(@Valid @RequestParam(name = "id", required = true) Integer id) {
		demoService.deleteStudentInfo(id);
		return new ResponseEntity<>("", HttpStatus.OK);

	}

}
