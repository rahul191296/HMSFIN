package com.cognizant.helper;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SessionCreator {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;
	
	@PostConstruct
	public Session createSession(){
		if(session==null)
		session=sessionFactory.openSession();
		
	    System.out.println("Session opened (SessionCreator):"+System.identityHashCode(session));
		return session;
	}
	@PreDestroy
	public void closeSession(){
		session.close();
		
	}
	
	
}
