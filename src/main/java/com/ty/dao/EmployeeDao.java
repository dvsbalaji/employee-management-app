package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.EmployeeDto;

public class EmployeeDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public boolean saveEmployee(EmployeeDto employeeDto) {

		entityTransaction.begin();
		entityManager.persist(employeeDto);
		entityTransaction.commit();

		EmployeeDto found = entityManager.find(EmployeeDto.class, employeeDto.getEmpid());

		if (found != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validateEmployee(int empid, String fname) {
		String sql = "SELECT e FROM EmployeeDto e WHERE e.empid = ?1 AND e.fname = ?2";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, empid);
		query.setParameter(2, fname);
		List<EmployeeDto> employee = query.getResultList();
		if (employee.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<EmployeeDto> getAllEmployees() {
		String sql = "SELECT e FROM EmployeeDto e ";
		Query query = entityManager.createQuery(sql);
		return query.getResultList();
	}

	public EmployeeDto findEmployeeById(int empid) {

		EmployeeDto employeeDto = entityManager.find(EmployeeDto.class, empid);
		return employeeDto;

	}
	
	public void updateEmployee(EmployeeDto employeeDto) {
		
		entityTransaction.begin();
		entityManager.merge(employeeDto);
		entityTransaction.commit();
		
	}
	
	public void deleteEmployeeByid(int empid) {
		
		EmployeeDto employeeDto = entityManager.find(EmployeeDto.class, empid);
		entityTransaction.begin();
		entityManager.remove(employeeDto);
		entityTransaction.commit();
		
	}
	
	public List<EmployeeDto> searchEmployeeByName(String fname){
	
		String sql = "SELECT e FROM EmployeeDto e WHERE e.fname LIKE :code";
		Query query = entityManager.createQuery(sql);
		query.setParameter("code", "%"+fname+"%") ;
		return query.getResultList();
		
	}
}
