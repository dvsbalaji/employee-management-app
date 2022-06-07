package com.ty.dao;

import java.time.Period;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.SalaryDto;

public class SalaryDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public boolean paySalary(SalaryDto dto) {
		
		
		if(dateValidation(dto)) {
			entityTransaction.begin();
			entityManager.persist(dto);
			entityTransaction.commit();
			return true ;
		}else {
			return false ;
		}
	}
	
	public List<SalaryDto> getSalById(int id){
		String sql = "SELECT s FROM SalaryDto s WHERE s.employeeDto.empid ="+id ;
		Query query = entityManager.createQuery(sql) ;
		return query.getResultList() ;
	}
	
	public List<SalaryDto> getAllSal(){
		String sql = "SELECT s FROM SalaryDto s " ;
		Query query = entityManager.createQuery(sql) ;
		return query.getResultList() ;
	}
	
	public boolean dateValidation(SalaryDto dto) {
		List<SalaryDto> salaries = getSalById(dto.getEmployeeDto().getEmpid()) ;
		for(SalaryDto salary : salaries) {
			int mon = Period.between(salary.getDate(), dto.getDate()).getMonths() ;
			if(mon == 1 || mon == 0 || mon == -1 ) {
				return false ;
			}
		}
		return true ;
	}
	
	
}
