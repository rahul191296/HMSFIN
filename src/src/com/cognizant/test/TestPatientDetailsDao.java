package com.cognizant.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.Dao.PatientDetailsDAOImpl;
import com.cognizant.entity.Patient;
import com.cognizant.helper.SessionCreator;
import com.sun.media.sound.ModelAbstractOscillator;

@ContextConfiguration(locations="classpath:ApplicationContext.xml")
public class TestPatientDetailsDao
{
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
	private List<Patient> mockedPatientList;
	@Mock
	private Patient patient;
	
	@InjectMocks
	private PatientDetailsDAOImpl patientDetailsDaoImpl;
	
	private PatientDetailsDAOImpl patientDetailsDao;
	
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);

		ApplicationContext ioc= new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionCreator=(SessionCreator)ioc.getBean("sessionCreator");

		patientDetailsDaoImpl.setSessionCreator(this.sessionCreator);
		Mockito.when(mockedSessionCreator.createSession()).thenReturn(mockedSession);
		Mockito.when(mockedSession.beginTransaction()).thenReturn(mockedTransaction);
		Mockito.when(mockedSession.createQuery("from Patient")).thenReturn(mockedQuery);
		Mockito.when(mockedQuery.list()).thenReturn(mockedPatientList);
		patientDetailsDao = Mockito.spy(patientDetailsDaoImpl);
		mockedPatientList=Mockito.spy(patientDetailsDaoImpl.getAllPatients());
	}
	
	@After
	public void tearDown()
	{
		
	}
	
	@Test
	public void testGetPatientList_positive()
	{
		assertEquals(true,mockedPatientList.size()>0);
	}
		
	@Test
	public void testpersistPatient()
	{
		Patient patient=new Patient();
		//patient.setPatientId("sgd21");
		patient.setFirstName("dfdf");
		patient.setLastName("dfdfd");
		patient.setGender("Male");
		patient.setAge(45);
		patient.setAddressLine1("dfdf");
		patient.setAddressLine2("dfdfdf");
		patient.setDoB("dfdf");
		patient.setAltContactNumber("dfdfd");
		patient.setContactNumber("dfdfdf");
		patient.setCity("dfdf");
		patient.setZipCode("dfdfd");
		patient.setState("dfdf");
		patient.setEmailId("dfdfdfd");
		patient.setPassword("dfdfdf");
	
		boolean res=patientDetailsDao.persistPatient(patient);
		boolean expected=true;
		assertEquals(expected, res);
	
	}
}
