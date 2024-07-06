package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import com.jsp.dto.Student;

public class StudentDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public Student findByemail(String email) {
		@SuppressWarnings("unchecked")
		List<Student> lOS = em.createQuery("select s from Student s where s.email=?1").setParameter(1, email).getResultList();;
		if(!lOS.isEmpty()) {
			return lOS.get(0);
		}
		return null;
	}
	
	public void createStudent(Student s) {
		et.begin();
		em.persist(s);
		et.commit();
	}
	
	public List<Student> findAllStudent(){
		@SuppressWarnings("unchecked")
		List<Student> lOS = em.createQuery("select s from Student s").getResultList();;
		if(!lOS.isEmpty()) {
			return lOS;
		}
		return null;
	}

	public void updateStudent(Student s) {
		et.begin();
		em.merge(s);
		et.commit();
	}

	public Student findById(int id) {
		Student s = em.find(Student.class, id);
		if(s!=null) {
			return s;
		}
		return null;
	}

	public void deleteStudentById(int id) {
		Student s = findById(id);
		et.begin();
		em.remove(s);
		et.commit();
	}
}
