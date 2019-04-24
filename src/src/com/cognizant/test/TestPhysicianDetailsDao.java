package com.cognizant.test;

import static org.junit.Assert.assertEquals;

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

import com.cognizant.Dao.PhysicianDetailsDAOImpl;
import com.cognizant.entity.Physician;
import com.cognizant.helper.SessionCreator;

@ContextConfiguration(locations="classpath:ApplicationContext.xml")
public class TestPhysicianDetailsDao
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
	private List<Physician> mockedPhysicianList;
	@Mock
	private Physician physician;
	
	@InjectMocks
	private PhysicianDetailsDAOImpl physicianDetailsDaoImpl;
	
	private PhysicianDetailsDAOImpl physicianDetailsDao;
	
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);

		ApplicationContext ioc= new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionCreator=(SessionCreator)ioc.getBean("sessionCreator");

		physicianDetailsDaoImpl.setSessionCreator(this.sessionCreator);
		Mockito.when(mockedSessionCreator.createSession()).thenReturn(mockedSession);
		Mockito.when(mockedSession.beginTransaction()).thenReturn(mockedTransaction);
		Mockito.when(mockedSession.createQuery("from Physician")).thenReturn(mockedQuery);
		Mockito.when(mockedQuery.list()).thenReturn(mockedPhysicianList);
		physicianDetailsDao = Mockito.spy(physicianDetailsDaoImpl);
		mockedPhysicianList=Mockito.spy(physicianDetailsDaoImpl.getAllPhysicians());
	}
	
	@After
	public void tearDown()
	{
		
	}
	
	@Test
	public void testGetPhysicianList_positive()
	{
		assertEquals(true, mockedPhysicianList.size()>0);
	}
	
	@Test
	public void testpersistPhysician_positive()
	{
		Physician physician=new Physician();
		physician.setFirstName("dfdf");
		physician.setLastName("dfdfd");
		physician.setGender("Male");
		physician.setAge(45);
		physician.setAddressLine1("dfdf");
		physician.setAddressLine2("dfdfdf");
		physician.setDoB("dfdf");
		physician.setAltContactNumber("dfdfd");
		physician.setContactNumber("dfdfdf");
		physician.setCity("dfdf");
		physician.setZipCode("ghdetr");
		physician.setState("dfdf");
		physician.setEmailId("dfdfdfd");
		physician.setPassword("dfdfdf");
		physician.setDegree("degree");
		physician.setSpeciality("vcjhs");
		physician.setWorkHours("12");
		physician.setHospitalName("vsvsvs");
		
		boolean res=physicianDetailsDao.persistPhysician(physician);
		boolean expected=true;
		assertEquals(expected, res);
	}
}
