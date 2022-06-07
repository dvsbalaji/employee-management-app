package com.ty.service;

import java.time.LocalDate;
import java.util.List;

import com.ty.dao.EmployeeDao;
import com.ty.dto.EmployeeDto;

import Helper.AgeCaliclator;

public class EmployeeService {

	EmployeeDao employeeDao = new EmployeeDao() ;
	
	public boolean saveEmployee(EmployeeDto employeeDto) {
		LocalDate dob = LocalDate.parse(employeeDto.getDob()) ;
		int age = AgeCaliclator.caliculateAge(dob) ;
		if((age >= 18) && (age <= 58)) {

		return employeeDao.saveEmployee(employeeDto) ;
		}else {
			return false ;
		}
	}

	public boolean validateEmployee(int empid, String fname) {
		return employeeDao.validateEmployee(empid, fname) ;
	}

	public List<EmployeeDto> getAllEmployees() {
		return employeeDao.getAllEmployees() ;
	}

	public EmployeeDto findEmployeeById(int empid) {
		return employeeDao.findEmployeeById(empid) ;
	}
	
	public void updateEmployee(EmployeeDto employeeDto) {
		employeeDao.updateEmployee(employeeDto);
	}
	
	public void deleteEmployeeByid(int empid) {
		employeeDao.deleteEmployeeByid(empid);
	}
	
	public List<EmployeeDto> searchEmployeeByName(String fname){
		return employeeDao.searchEmployeeByName(fname) ;
	}
}
