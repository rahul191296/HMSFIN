package com.cognizant.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Registration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.entity.Admin;
import com.cognizant.entity.Diagnosis;
import com.cognizant.entity.Login;
import com.cognizant.entity.Patient;
import com.cognizant.entity.Physician;
import com.cognizant.exception.SpringException;
import com.cognizant.helper.SessionCreator;
import com.cognizant.model.AdminModel;
import com.cognizant.model.DiagnosisModel;
import com.cognizant.model.LoginModel;
import com.cognizant.model.PatientModel;
import com.cognizant.model.PhysicianModel;
import com.cognizant.service.AdminService;
import com.cognizant.service.DiagnosisService;
import com.cognizant.service.LoginService;
import com.cognizant.service.PatientService;
import com.cognizant.service.PhysicianService;
import com.cognizant.validation.LoginValidator;

//import sun.rmi.runtime.Log;

@Controller
@SessionAttributes({"updatePatient","updatePhysician","updateDiagnosis","patientId","physicianId","patientList","physicianList","adminId"})
public class AdminController {
	
	@Autowired
	private SessionCreator sessionCreator;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
    private PatientService patientService;
	
	@Autowired
    private PhysicianService physicianService;
	
	@Autowired
    private DiagnosisService diagnosisService;
	
	@Autowired@Qualifier(value="LoginValidator")
    private Validator loginValidator;
    
    @Autowired@Qualifier(value="RegistrationValidator")
    private Validator registrationValidator;
    
    @Autowired@Qualifier(value="PatientValidator")
    private Validator patientValidator;
    
    @Autowired@Qualifier(value="PhysicianValidator")
    private Validator physicianValidator;
    
    public static final Logger logger=LoggerFactory.getLogger(AdminController.class);
    

//--------------------------------------------------------------------------------------------------------------------//
     
    //*********CREATING MODEL ATTRIBUTE OF LOGIN*********//
    @ModelAttribute("login")
	public LoginModel createAdminObject(){
    	logger.info("Creating Login object");
    	LoginModel login=new LoginModel();
		return login;
	}
    
//--------------------------------------------------------------------------------------------------------------------//
	
    //*********LOGIN FUNCTION*********//
	@RequestMapping(value="doLogin.htm",method=RequestMethod.POST)
	public ModelAndView dologin(@ModelAttribute("login")LoginModel loginModel,Errors errors,ModelMap map,HttpSession session){
		logger.info("This is login page");
		ModelAndView mv=new ModelAndView();
		
		ValidationUtils.invokeValidator(loginValidator, loginModel, errors);
    	if(errors.hasErrors())
    	{
    		logger.info("Login Error");
    		mv.setViewName("welcome");
    	}
    	else{
    		int adminLogin=loginService.checkLogin(loginModel);
    				session.setAttribute("adminId", loginModel.getAdminId());
    				
		if(adminLogin==4) {
			logger.info("Login Successfully");
				map.addAttribute("adminId",loginModel.getAdminId());
				mv.setViewName("home");
			
	    	return mv;
		}
		else {
			logger.info("Login Failed");
			mv.addObject("status","Login failed");
		}
		mv.setViewName("welcome");
    	}
		
		return mv;	
	}
	
//--------------------------------------------------------------------------------------------------------------------//
	
	//*********IT LOADS THE HOME PAGE*********//
		@RequestMapping(value="home.htm",method=RequestMethod.GET)
		public String loadHomeForm(){
			logger.info("It Loads the Home Page");
			return "home";
		}
	
//--------------------------------------------------------------------------------------------------------------------//
		
		//*********IT LOADS THE LOGIN PAGE*********//
		@RequestMapping(value="login.htm",method=RequestMethod.GET)
		public String loadLoginForm(){
			logger.info("It Loads the Login Page");
			return "welcome";
		}
		
	
//--------------------------------------------------------------------------------------------------------------------//
	
	 //*********IT LOADS THE FRONT PAGE*********//
	  @RequestMapping(value="index.htm",method=RequestMethod.GET)
	  public String loadFrontForm(){
		 logger.info("It Loads the Front Page");
		 return "welcome";
	  }
	  

//--------------------------------------------------------------------------------------------------------------------//
	
	//*********LOADS THE REGISTRATION PAGE*********//
	 @RequestMapping(value="registration.htm",method=RequestMethod.GET)
	   public ModelAndView loadForm(){
		 logger.info("It loads the Registration form");
		 List<String> gender=new ArrayList<String>();
		 gender.add("Male");
		 gender.add("Female");
		 ModelAndView mv=new ModelAndView();
		 mv.addObject("Gender",gender);
		 mv.setViewName("registration");
		   return mv;
	 }
	 
//--------------------------------------------------------------------------------------------------------------------//
	
	//*********CREATES THE MODEL ATTRIBUTE OF ADMIN*********//
	@ModelAttribute("admin")
	public AdminModel createCommandobject()
	{	
		logger.info("Creates the Model Attribute of Admin");
		AdminModel admin=new AdminModel();
		return admin;
	}
	
//--------------------------------------------------------------------------------------------------------------------//
	
	//*********REGISTRATION PAGE*********//
	@RequestMapping(value="doRegistration.htm",method=RequestMethod.POST)
	@ExceptionHandler({SpringException.class})
    public ModelAndView persistAdmin(@ModelAttribute("admin")AdminModel adminModel,Errors errors,ModelMap map)
    {    
		logger.info("This is Registration Page");
    	ModelAndView mv=new ModelAndView();
    	ValidationUtils.invokeValidator(registrationValidator, adminModel, errors);
    	
    	if(errors.hasErrors())
    	{
    		logger.info("Registration Error");
    		mv.setViewName("registration");
    	}
    	else{
    		
    		AdminModel afterpersistAdmin=adminService.persistsAdmin(adminModel);
		
		if(afterpersistAdmin.getContactNumber()==adminModel.getContactNumber()){
			
			logger.info("Successfully Registered");
			mv.addObject("adminId",afterpersistAdmin.getAdminId());
			mv.addObject("status", "Admin sucessfully registered");
			
			List<Admin> adminList=adminService.getAllAdmin();
	    	mv.addObject("adminList",adminList);
	    	mv.setViewName("adminid");
	    	return mv;	
		}
		else
		{
			logger.info("Registration Failed");
			logger.info("Registration Failed");
			mv.addObject("status"," registration failed");
		}
    	
		mv.setViewName("registration");
    	}
    	return mv;
    }
	
//--------------------------------------------------------------------------------------------------------------------//
	
	//*********LOGOUT METHOD*********//
	 @RequestMapping(value="logoutUser.htm",method=RequestMethod.GET )
	    public String logoutAdmin(HttpSession session){
		 logger.info("Logout Method");
		 session.removeAttribute("adminId");
		 session.invalidate();
		 return "welcome"; 
	    }
   
//-----------------------------------------------------PATIENT MODULE-------------------------------------------------//
	 
	 //*********CREATES THE MODEL ATTRIBUTE OF PATIENT*********//
	 @ModelAttribute("patient")
		public PatientModel createPatientobject()
		{
		    logger.info("creating patient object");
		    PatientModel patient=new PatientModel();
			return patient;
		}
	 
//--------------------------------------------------------------------------------------------------------------------//
	
	 //*********CREATE PATIENT RECORD*********//
	 @RequestMapping(value="addPatientDetails.htm",method=RequestMethod.GET)
	 @ExceptionHandler({SpringException.class})
	  public ModelAndView addPatientDetails(@ModelAttribute("patient")PatientModel patientModel,Errors errors,ModelMap map){
		      logger.info("Adding Patient Details");
		      ModelAndView mv=new ModelAndView();
			ValidationUtils.invokeValidator(patientValidator, patientModel, errors);
				
				boolean persistPatient=patientService.patientPersist(patientModel);
				if(persistPatient)
				{
					logger.info("Patient Successfully Registered");
					mv.addObject("status", "Patient Sucessfully registered");
					List<Patient> patientList=patientService.getAllPatients();
					map.addAttribute("patientList", patientList);
					mv.setViewName("successfulregistration");
					return mv;
				}
				else
				{
					logger.info("Patient Registeration Failed");
					mv.addObject("status", "Registered failed");	
				}
				mv.setViewName("home");	
			return mv;
	 }
	
//--------------------------------------------------------------------------------------------------------------------//
	
	 //*********VIEW PHYSICIAN RECORDS*********//
	 @RequestMapping(value="viewpatient.htm",method=RequestMethod.GET)
		public ModelAndView viewPatientDetails(HttpServletRequest request)
		{
		 	
		 HttpSession session = request.getSession(false);
		 if(session.getAttribute("adminId")==null){
			 throw new SpringException("hello its an error");
		 }
			List<Patient> patientList= patientService.getAllPatients();
			ModelAndView mv=new ModelAndView();
			mv.addObject("patientList", patientList);
			mv.setViewName("viewpatient");
			return mv;
		}  
	 
	 

//--------------------------------------------------------------------------------------------------------------------//		 

	 //*********SHOW THE COMPLETE DETAILS OF PATIENT*********//
	 @RequestMapping(value="showPatientDetails.htm",method=RequestMethod.GET)
		public ModelAndView showPatientDetails(@RequestParam("patientId")String patientId,ModelMap map)
		{ 
		    logger.info("It shows the complete details of a patient");
			PatientModel patient=patientService.getPatientObject(patientId);
			patient.getAge();
			map.addAttribute("updatePatient",patient);
			ModelAndView mv=new ModelAndView();
			mv.setViewName("displaypatientdetails");
			return mv;
		}
	 
//--------------------------------------------------------------------------------------------------------------------//
	 
	 //*********UPDATE PATIENT DETAILS*********//
	 @RequestMapping(value="updatePatientDetails.htm",method=RequestMethod.GET)
	 @ExceptionHandler({SpringException.class})
	 public ModelAndView updatePatientDetails(@ModelAttribute("updatePatient")PatientModel patientModel,Errors errors,ModelMap map){
	    logger.info("Updating patient deatils");
	    
		ModelAndView mv=new ModelAndView();
		boolean updatePatient=patientService.patientUpdate(patientModel);
		List<Patient> patientList=patientService.getAllPatients();
		map.addAttribute("patientList",patientList);
		mv.setViewName("displaypatientdetails");
		 return mv;	 
	 }
	 
//--------------------------------------------------------------------------------------------------------------------//
	 
	 //*********LOAD UPDATE PATIENT FORM*********//
	 @RequestMapping(value="editPatient.htm",method=RequestMethod.GET)
		public ModelAndView loadUpdatePatientForm(){
		 logger.info("Load update patient form");
		 
		 ModelAndView mv=new ModelAndView();
		 mv.setViewName("updatepatient");
	     return mv;
		}
	 
//-------------------------------------------------------PHYSICIAN MODULE---------------------------------------------//
	 
	//*********CREATES THE MODEL ATTRIBUTE OF PHYSICIAN*********//
	 @ModelAttribute("physician")
		public PhysicianModel createPhysicianobject()
		{
		 logger.info("Creating object of Physician");
		 PhysicianModel physician=new PhysicianModel();
			return physician;
		}
	 
//--------------------------------------------------------------------------------------------------------------------//
	 
	 //*********CREATE PHYSICIAN RECORD*********//
	 @RequestMapping(value="addPhysicianDetails.htm",method=RequestMethod.GET)
	 @ExceptionHandler({SpringException.class})
	  public ModelAndView addPhysicianDetails(@ModelAttribute("physician")PhysicianModel physicianModel,Errors errors,ModelMap map){
		 logger.info("Adding the physician details");
		 ModelAndView mv=new ModelAndView();
		ValidationUtils.invokeValidator(physicianValidator, physicianModel, errors);
		
		 boolean persistPhysician=physicianService.physicianPersist(physicianModel);
				if(persistPhysician)
				{
					logger.info("Physician Successfully Registered");
					mv.addObject("status", "Physician Sucessfully registered");
					List<Physician> physicianList=physicianService.getAllPhysicians();
					map.addAttribute("physicianList", physicianList);
					mv.setViewName("successfulregistration");
					return mv;
				}
				else
				{
					logger.info("Physician Registration Failed");
					mv.addObject("status", "Registered failed");	
				}
				mv.setViewName("home");
			return mv;
	 }
	 
//--------------------------------------------------------------------------------------------------------------------//
		
		//*********VIEW PHYSICIAN RECORDS*********//
		 @RequestMapping(value="viewphysician.htm",method=RequestMethod.GET)
			public ModelAndView viewPhysicianDetails()
			{
				List<Physician> physicianList= physicianService.getAllPhysicians();
				ModelAndView mv=new ModelAndView();
				mv.addObject("physicianList", physicianList);
				mv.setViewName("viewphysician");
				return mv;
			} 
	 
//--------------------------------------------------------------------------------------------------------------------//
	 
	//*********SHOW THE COMPLETE DETAILS OF PHYSICIAN*********//
	 @RequestMapping(value="showPhysicianDetails.htm",method=RequestMethod.GET)
		public ModelAndView showPhysicianDetails(@RequestParam("physicianId")String physicianId,ModelMap map)
		{ 
		    logger.info("Updating patient deatils");
			PhysicianModel physician=physicianService.getPhysicianObject(physicianId);
			physician.getAge();
			map.addAttribute("updatePhysician",physician);
			ModelAndView mv=new ModelAndView();
			mv.setViewName("displayphysiciandetails");
			return mv;
		}
	
//--------------------------------------------------------------------------------------------------------------------//
	 
	//*********LOAD UPDATE PHYSICIAN FORM*********//
	 @RequestMapping(value="editPhysician.htm",method=RequestMethod.GET)
		public ModelAndView loadUpdatePhysicianForm(){
		     logger.info("Updating patient deatils");
		 	 
			 ModelAndView mv=new ModelAndView();
			
			 mv.setViewName("updatephysician");
			return mv;
		}
	 
//--------------------------------------------------------------------------------------------------------------------//
	 
	 //*********UPDATE PHYSICIAN DETAILS*********//
	 @RequestMapping(value="updatePhysicianDetails.htm",method=RequestMethod.GET)
	 @ExceptionHandler({SpringException.class})
	 public ModelAndView updatePhysicianDetails(@ModelAttribute("updatePhysician")PhysicianModel physicianModel,Errors errors,ModelMap map){
		 logger.info("It shows the complete details of a patient");
		
		 ModelAndView mv=new ModelAndView();
		 boolean updatePhysician=physicianService.physicianUpdate(physicianModel);
		 List<Physician> physicianList= physicianService.getAllPhysicians();
		 map.addAttribute("physicianList",physicianList);
		 mv.setViewName("displayphysiciandetails");
		 return mv;
	 }
	
//--------------------------------------------------DIAGNOSIS MODULE--------------------------------------------------//
	 
	//*********CREATES THE MODEL ATTRIBUTE OF DIAGNOSIS*********//
	 @ModelAttribute("diagnosis")
	 public DiagnosisModel createcommandObject1(){
		 logger.info("Create Diagnosis Object");
	 	 DiagnosisModel diagnosis=new DiagnosisModel();
	 	return diagnosis;
	 }
	 
//--------------------------------------------------------------------------------------------------------------------//
	 
	 //*********IT CHECKS WHETHER TO ADD OR VIEW THE DIAGNOSIS DETAILS*********//
	 @RequestMapping(value="displayDiagnosis.htm", method=RequestMethod.GET)
	 public ModelAndView displayDiagnosis(@RequestParam("patientId")String patientId,ModelMap map){
		
		  map.addAttribute("patientId",patientId);
		  ModelAndView mv =new ModelAndView();
		  boolean checkReportId=diagnosisService.getReportId(patientId);
		  if(checkReportId == true)
		  {	     logger.info("Check reportId is True");
			 	 List<String> physicianIdList=physicianService.getAllPhysiciansId();
				 mv.addObject("physicianIdList",physicianIdList);
				 mv.addObject("patientId",patientId);
				 mv.setViewName("adddiagnosis");	
		  }
		  else
		  {
			  Diagnosis diagnosis1=null;
			  DiagnosisModel updateDiagnosisObj=diagnosisService.getReportDetail(patientId);
				 map.addAttribute("updateDiagnosis",updateDiagnosisObj);
				 mv.setViewName("viewdiagnosisdetails"); 
		  }
		  return mv; 
	 }
	 
//--------------------------------------------------------------------------------------------------------------------//
	 
	 //*********ADD DIAGNOSIS DETAILS*********//
	 @RequestMapping(value="addDiagnosisDetails.htm",method=RequestMethod.GET)
	 public ModelAndView addDiagnosis(@ModelAttribute("diagnosis")DiagnosisModel diagnosisModel,Errors error,ModelMap map){

		    logger.info("Add Diagnosis Page");
		 	map.addAttribute("updateDiagnosis",diagnosisModel);
	    	ModelAndView mv= new ModelAndView();
	    	{
	    		boolean persistDiagnosis=diagnosisService.diagnosisPersist(diagnosisModel);
	    		if(persistDiagnosis)
	    		{
	    			logger.info("Diagnosis Added Successfully");
	    			mv.addObject("status","successfull");
	    			List<Diagnosis> diagnosisList=diagnosisService.getAllDiagnosis();
	    			mv.addObject("diagnosisList", diagnosisList);
	    			
	    			List<Patient> patientList= patientService.getAllPatients();
	    			mv.addObject("patientList", patientList);
	    			mv.setViewName("home");
	    			return mv;
	    		}
	    		else{
	    			logger.info("Diagnosis Failed");
	    			mv.addObject("status","fails");
	    		     }
	    		mv.setViewName("adddiagnosis");
	    	}
			return mv;
	    }
	 
//--------------------------------------------------------------------------------------------------------------------//
	 
	 //*********SHOW DIAGNOSIS DETAILS*********//
	 @RequestMapping(value="showDiagnosisDetails.htm",method=RequestMethod.GET)
		public ModelAndView showDiagnosisDetails(@RequestParam(value="patientId",required= false)String patientId,ModelMap map)
		{ 
		    logger.info("Show Diagnosis Details");
			DiagnosisModel diagnosis=diagnosisService.getDiagnosisObject(patientId);
			map.addAttribute("updateDiagnosis",diagnosis);
			ModelAndView mv=new ModelAndView();
			mv.setViewName("viewdiagnosisdetails");
			return mv;
		}
	 
//--------------------------------------------------------------------------------------------------------------------//
	 
	 //*********UPDATE DIAGNOSIS DETAILS*********//
	 @RequestMapping(value="updateDiagnosisDetails.htm",method=RequestMethod.GET)
	 public ModelAndView updateDiagnosisDetails(@ModelAttribute("updateDiagnosis")DiagnosisModel diagnosisModel,Errors errors,ModelMap map){
		 logger.info("Update the diagnosis details");
		 ModelAndView mv=new ModelAndView();
		 String patId=diagnosisModel.getPatientId();
		 boolean updateDiagnosis=diagnosisService.diagnosisUpdate(diagnosisModel);
		 DiagnosisModel diagnosis=diagnosisService.getReportDetail(patId);
		 map.addAttribute("updateDiagnosis",diagnosis);
		 mv.setViewName("viewdiagnosisdetails");
		 return mv;
		 
	 } 
	 
//--------------------------------------------------------------------------------------------------------------------//
	 
	  //*********LOAD UPDATE DIAGNOSIS FORM*********//
	  @RequestMapping(value="editDiagnosis.htm",method=RequestMethod.GET)
		public ModelAndView loadUpdateDiagnosisForm(){
		  logger.info("Load update Diagnosis page");
		  ModelAndView mv=new ModelAndView();
		  mv.setViewName("updatediagnosis");
		  return mv;
		}


//--------------------------------------------------------------------------------------------------------------------//

//*********LOAD CONTACT FORM*********//
	  @RequestMapping(value="contactPage.htm",method=RequestMethod.POST)
	  	public ModelAndView loadContactPageForm(){
		  logger.info("Load contact details page");
		  ModelAndView mv=new ModelAndView();
		  mv.setViewName("contactpage");
		  return mv;
	}
}