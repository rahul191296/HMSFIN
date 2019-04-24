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

import com.cognizant.Dao.DiagnosisDetailsDAOImpl;
import com.cognizant.entity.Diagnosis;
import com.cognizant.helper.SessionCreator;

@ContextConfiguration(locations="classpath:ApplicationContext.xml")
public class TestDiagnosisDetailsDao
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
	private List<Diagnosis> mockedDiagnosisList;
	@Mock
	private Diagnosis diagnosis;
	
	@InjectMocks
	private DiagnosisDetailsDAOImpl diagnosisDetailsDaoImpl;
	
	private DiagnosisDetailsDAOImpl diagnosisDetailsDao;
	
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);

		ApplicationContext ioc= new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionCreator=(SessionCreator)ioc.getBean("sessionCreator");

		diagnosisDetailsDaoImpl.setSessionCreator(this.sessionCreator);
		Mockito.when(mockedSessionCreator.createSession()).thenReturn(mockedSession);
		Mockito.when(mockedSession.beginTransaction()).thenReturn(mockedTransaction);
		Mockito.when(mockedSession.createQuery("from Diagnosis")).thenReturn(mockedQuery);
		Mockito.when(mockedQuery.list()).thenReturn(mockedDiagnosisList);
		diagnosisDetailsDao = Mockito.spy(diagnosisDetailsDaoImpl);
		mockedDiagnosisList=Mockito.spy(diagnosisDetailsDaoImpl.getAllDiagnosis());
	}
	
	@After
	public void tearDown()
	{
		
	}
	
	@Test
	public void testGetDiagnosisList_positive()
	{
		assertEquals(true, mockedDiagnosisList.size()>0);
	}
}
