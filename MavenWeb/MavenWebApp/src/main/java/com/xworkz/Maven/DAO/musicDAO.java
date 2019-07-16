package com.xworkz.Maven.DAO;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.Maven.DTO.musicDTO;
@Component
public class musicDAO {

	public musicDAO() {
		System.out.println("created musicdao"+this.getClass().getSimpleName());
	}
	@Autowired
	private SessionFactory factory;
	
	
	public Integer saveDataUsingSpring(musicDTO  dto)
	{
		System.out.println("invoked save and return id");
	    Session session=factory.openSession();
	    try {
	    	
	    	System.out.println("saving Biometric"+dto);
	    	session.beginTransaction();
	    	Serializable aftersave=session.save(dto);
			Integer id=(Integer) aftersave;
			session.getTransaction().commit();
			System.out.println("returning the id after save "+id);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			session.beginTransaction().rollback();
		}
	    finally
	    {
	    	session.close();//clear cache ,release base conn,close
	    }
		return 0;	
	}
}
