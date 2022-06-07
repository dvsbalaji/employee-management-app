package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.AdminDto;

public class AdminDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public boolean createAdmin(AdminDto adminDto) {
		entityTransaction.begin();
		entityManager.persist(adminDto);
		entityTransaction.commit();

		AdminDto found = entityManager.find(AdminDto.class, adminDto.getId());

		if (found != null) {
			return true;
		} else {
			return false;
		}

	}
	
	public boolean validateAdmin(String email ,String password) {
		String sql = "SELECT a FROM AdminDto a WHERE a.email = ?1 AND a.password = ?2" ;
		Query query = entityManager.createQuery(sql) ;
		query.setParameter(1, email) ;
		query.setParameter(2, password) ;
		List<AdminDto> admin = query.getResultList() ;
		if(admin.size() > 0 ) {
			return true ;
		}else {
			return false ;
		}
	}
}
