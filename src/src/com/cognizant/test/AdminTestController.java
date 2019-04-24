package com.cognizant.test;

import static org.junit.Assert.*;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.AssertTrue;

import org.dom4j.rule.Mode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.Dao.LoginDAO;
import com.cognizant.Dao.PatientDetailsDAO;
import com.cognizant.Dao.PatientDetailsDAOImpl;
import com.cognizant.Dao.PhysicianDetailsDAO;
import com.cognizant.Dao.PhysicianDetailsDAOImpl;
import com.cognizant.Dao.StorePatId;
import com.cognizant.controller.AdminController;
import com.cognizant.entity.Admin;
import com.cognizant.entity.Login;
import com.cognizant.entity.Patient;
import com.cognizant.entity.Physician;
import com.cognizant.exception.SpringException;
import com.cognizant.helper.SessionCreator;
import com.cognizant.model.AdminModel;
import com.cognizant.model.LoginModel;
import com.cognizant.model.PatientModel;
import com.cognizant.model.PhysicianModel;
import com.cognizant.service.AdminService;
import com.cognizant.service.DiagnosisService;
import com.cognizant.service.LoginService;
import com.cognizant.service.PatientService;
import com.cognizant.service.PhysicianService;
import com.cognizant.validation.LoginValidator;
import com.cognizant.validation.PatientValidator;
import com.cognizant.validation.PhysicianValidator;
import com.cognizant.validation.RegistrationValidator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:ApplicationContext.xml")
public class AdminTestController
{
	private MockMvc mockMvc;
	
	@Autowired
	@Mock
	private SessionCreator sessionCreator;
	
	@Autowired
	@Mock
	private LoginService loginService;
	
	@Autowired
	@Mock
	private AdminService adminService;
	
	@Autowired
	@Spy
	private PatientService patientService;
	
	@Autowired
	@Spy
	private PhysicianService physicianService;
	
	@Autowired
	@Mock
    private DiagnosisService diagnosisService;
	
	@Autowired
	@Spy
	@Qualifier("LoginValidator")
	private LoginValidator loginValidator; 
	
	@Autowired
	@Spy
	@Qualifier("RegistrationValidator")
	private RegistrationValidator registrationValidator;
	
	@Autowired
	@Qualifier(value="PatientValidator")
	@Spy
	private PatientValidator patientValidator;
	
	@Autowired
	@Qualifier(value="PhysicianValidator")
	@Spy
	private PhysicianValidator physicianValidator;
	
	@InjectMocks
	private AdminController adminController;
	
	@Before
    public void init()
	{
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(adminController)
                .build();
    }
	
	@After
	public void tearDown() throws Exception
	{
		
	}
	
	@Test
	public void testdoLogin_positive()
	{
			LoginModel login = new LoginModel();
			login.setAdminId("1");
			login.setPassword("abc");
			Errors errors= new BeanPropertyBindingResult("1","com.cognizant.entity.Login.adminIdAndPassword.duplicate");
	    	ModelMap map=new ModelMap();
	    	try
	    	{
	    		
	    		MockHttpSession session=new MockHttpSession();
	    		MockHttpServletRequest request=new MockHttpServletRequest();
	    		request.setSession(session);
	    		ModelAndView mv=adminController.dologin(login,errors,map,session);
		    	String actual=mv.getViewName();
		    	String expected="welcome";
		    	assertEquals(expected,actual);
	    	}
	    	catch(Exception e)
	    	{
	    		fail("Invalid User Id or Password");
	    	}
	}
	
	@Test
	public void testdoLogin_negative()
	{
		LoginModel login= new LoginModel();
		login.setAdminId("21");
		login.setPassword("abc");
		Errors errors= new BeanPropertyBindingResult("1","com.cognizant.entity.Login.adminIdAndPassword.duplicate");
		ModelMap map=new ModelMap();
		MockHttpSession session=new MockHttpSession();
		MockHttpServletRequest request=new MockHttpServletRequest();
		request.setSession(session);
		try
		{
			ModelAndView mv=adminController.dologin(login,errors,map,session);
	    	String actual=mv.getViewName();
	    	String expected="welcome";
	    	assertTrue(false);
		}
		catch(Exception e)
		{
			ModelAndView mv=adminController.dologin(login,errors,map,session);
			assertTrue(true);
			String actual=mv.getViewName();
			String expected="home";
			assertEquals(actual,expected);
		}
	}
	
	@Test
	public void testupdatePatientDetails_positive()
	{
		PatientModel patient=new PatientModel();
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
		//patient.setPatientId("dhj123");
		Errors errors= new BeanPropertyBindingResult("10","com.cognizant.controller.AdminTestController.AnyUserData");
		ModelMap map=new ModelMap();
		try
		{
			ModelAndView mv=adminController.updatePatientDetails(patient,errors, map);
			String res=mv.getViewName();
			String actual="displaypatientdetails";
			assertEquals(res,actual);
		}
		catch(Exception e)
		{
			fail("Incorrect Data");
		}
	}
	
	@Test
	public void testupdatePatientDetails_negative()
	{
		PatientModel patient=new PatientModel();
		patient.setFirstName("jnfn");
		patient.setLastName("ghfh");
		patient.setGender("fghfh");
		patient.setAge(45);
		patient.setAddressLine1("fhhfh");
		patient.setAddressLine2("dgdvsvf");
		patient.setDoB("gfhfgh");
		patient.setAltContactNumber("jgh");
		patient.setContactNumber("nbnbvn");
		patient.setCity("nbncn");
		patient.setZipCode("hfhfh");
		patient.setState("dfdhghfghf");
		patient.setEmailId("hfhh");
		patient.setPassword("fghfhf");
		//patient.setPatientId("d123");
		Errors errors= new BeanPropertyBindingResult("10","com.cognizant.controller.AdminTestController.AnyUserData");
		ModelMap map=new ModelMap();
		try
		{
			ModelAndView mv=adminController.updatePatientDetails(patient,errors,map);
			String res=mv.getViewName();
			String actual="displaypatientdetails";
			assertTrue(false);
		}
		catch(Exception e)
		{
			assertTrue(true);
			String expected="Data doesn't match";
			assertEquals(expected,errors);
		}
	}
	
	@Test
	public void testupdatePhysicianDetails_positive()
	{
		PhysicianModel physician=new PhysicianModel();
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
		//physician.setPhysicianId("phy21");
		Errors errors= new BeanPropertyBindingResult("10","com.cognizant.controller.AdminTestController.AnyUserData");
		ModelMap map=new ModelMap();
		try
		{
			ModelAndView mv=adminController.updatePhysicianDetails(physician,errors,map);
			String res=mv.getViewName();
			String actual="displayphysiciandetails";
			assertEquals(res,actual);
		}
		catch(Exception e)
		{
			fail("Insufficient data");
		}
	}
	
	@Test
	public void testpersistAdmin_positive()
	{
		AdminModel admin = new AdminModel();
		admin.setFirstName("Dhanakshi");
		admin.setLastName("Jain");
		admin.setAge(21);
		admin.setDoB("12/09/1997");
		admin.setContactNumber("998835746");
		admin.setAltContactNumber("7888516448");
		admin.setGender("Female");
		admin.setEmailId("djain8.dj@gmail.com");
		admin.setPassword("Dhani");
		admin.setAdminId("vbjhs123");
		Errors errors= new BeanPropertyBindingResult(admin,"com.cognizant.controller.AdminTestController.AnyUserData");
    	ModelMap map=new ModelMap();
    	
    		ModelAndView mv=adminController.persistAdmin(admin,errors,map);
	    	String actual=mv.getViewName();
	    	String expected="adminid";
	    	assertEquals(expected,actual);
    	
	}
}