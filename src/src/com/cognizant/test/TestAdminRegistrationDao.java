package com.cognizant.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.Assert.*;

import com.cognizant.Dao.AdminRegistrationDAOImpl;
import com.cognizant.Dao.DiagnosisDetailsDAOImpl;
import com.cognizant.Dao.LoginDAOImpl;
import com.cognizant.Dao.PatientDetailsDAOImpl;
import com.cognizant.Dao.PhysicianDetailsDAOImpl;
import com.cognizant.entity.Admin;
import com.cognizant.entity.Diagnosis;
import com.cognizant.entity.Login;
import com.cognizant.entity.Patient;
import com.cognizant.entity.Physician;
import com.cognizant.helper.SessionCreator;

@ContextConfiguration(locations="classpath:ApplicationContext.xml")
public class TestAdminRegistrationDao {

	private SessionCreator sessionCreator;
	
	@Mock
	private ApplicationContext ioc;
	
	@Mock
	private SessionCreator mockedSessionCreator;
	
	@Mock
	private Session mockedSession;
	@Mock
	private Transaction mockedTransaction;
	@Mock
	private Query mockedQuery;
	@Mock
	private List<Admin> mockedAdminList;
	@Mock
	private Admin admin;
	
	@InjectMocks
	private AdminRegistrationDAOImpl adminRegistrationDaoImpl;

	private AdminRegistrationDAOImpl adminRegistrationDao;
	
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);

		ApplicationContext ioc= new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionCreator=(SessionCreator)ioc.getBean("sessionCreator");
		
		adminRegistrationDaoImpl.setSessionCreator(this.sessionCreator);
		Mockito.when(mockedSessionCreator.createSession()).thenReturn(mockedSession);
		Mockito.when(mockedSession.beginTransaction()).thenReturn(mockedTransaction);
		Mockito.when(mockedSession.createQuery("from Admin")).thenReturn(mockedQuery);
		Mockito.when(mockedQuery.list()).thenReturn(mockedAdminList);
		adminRegistrationDao = Mockito.spy(adminRegistrationDaoImpl);
		mockedAdminList=Mockito.spy(adminRegistrationDaoImpl.getAllAdmin());
	}
	@Test
	public void testGetAdminList_positive() 
	{
		assertEquals(true,mockedAdminList.size()>0);	
	}
}