package com.ty.service;

import java.util.List;

import com.ty.dao.SalaryDao;
import com.ty.dto.SalaryDto;

public class SalaryService {

	SalaryDao dao = new SalaryDao() ;
	public boolean paySalary(SalaryDto dto) {
		return dao.paySalary(dto) ;
 	}
	
	public List<SalaryDto> getSalById(int id){
		return dao.getSalById(id) ;
	}
	
	public List<SalaryDto> getAllSal(){
		return dao.getAllSal() ;
	}
}
