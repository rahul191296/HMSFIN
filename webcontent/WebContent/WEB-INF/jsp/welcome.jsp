<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="springcore"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
*{
    padding:0px;
    margin:0px;
}
#header
{
background-color:black;
position:fixed;
width:100%;
color:white;
opacity:0.6;
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  padding-top:15px;
  padding-bottom:15px;
  padding-left:25px;

}

li {
  float:left;
  }

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 12px 16px;
  text-decoration: none;
  font-weight:900;
  font-size:18px;
  cursor:pointer;
  


}


li a:hover:not(.active) {
  border-bottom: 2px solid Dodgerblue;
  

}

.active {
  background-color:  Dodgerblue;
  color:white;
}

#screen1
{
    background:url("https://assets.parents.com/s3fs-public/styles/nfp_1080_portrait/public/shutterstock_390833533.jpg?UIDVb7pCd6S0zBO00L2bpEn7BR3eLNGq");
    width:100%;
    height:680px;
    background-size:100% 680px;
    background-repeat:no-repeat;
   background-attachment: fixed;
    
    
}
.layer {
    background-color: rgba(0, 0, 0, 0.6);
    width: 100%;
    height: 100%;
}

#screen2
{
  width:100%;
  height:480px;
  
}

#screen2 h1
{
 padding-top:20px;
 padding-left:20px;
 font: 15px arial, sans-serif;
 text-align:center;
 
}

#screen3
{
    background-image:url("https://cdn-images-1.medium.com/max/2600/1*yfcSW9LZ6VNeCjZZOJTqqQ.jpeg");
    width:100%;
    height:680px;
    background-size:100% 680px;
    background-repeat:no-repeat;
    background-attachment: fixed;
    
    
}

#screen4
{
 height:620px;
}

#screen4 input
{
 background-color:white;
 border:1px solid black;
 
}

#screen1 form

{
    
width:30%;
    
height:420px;
     
float:right;

margin-top:20%;
   
margin-right:5%;

outline:none;
}


#screen4 form
{
  width:30%;
    
  height:420px;
     
  float:right;


  margin-right:5%;

  margin-top:10%;
  outline:none;
}

#screen4 input
{
   padding:15px 25px;
  
   text-align:center;
 
     
   color:black;
    
   width:80%;

   border-radius:30px;
   outline:none;
}
input

{
   
   padding:15px 25px;
  
   text-align:center;
 
   background-color:rgba(0,0,0,0.5);
  
   border:none;
   
   color:white;
    
   width:80%;

   border-radius:30px;
   outline:none;
 
}

button

{
   
 padding:15px 25px;
    
 width:45%;
    
 color:white;
    
 background-color:Dodgerblue;   
 border:none;
   
 cursor:pointer;

 border-radius:30px;

}

button:hover {
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}
hr { 
  display: block;
  margin-top: 0.5em;
  margin-bottom: 0.5em;
  margin-left: auto;
  margin-right: auto;
  border-style: inset;
  border-width: 1px;
}



#screen4 img
{
 width:45%;
 heigth:600px;
 margin:10%;
 
}

</style>

<script>
function AboutUs() {
  window.scrollBy(0, 560);
}

function Contact()
{
  window.scrollBy(0,1800);
}
</script>
</head>
<body>

<div id="header">
<ul>
  <li><a class="active" href="#news"><strong>Medicenter</strong></a></li>
  <li><a  href="#home">Home</a></li>
  <li><a onclick="AboutUs()" >About Us</a></li>
  <li><a onclick="Contact()">Contact</a></li>
  <li  style="float:right;"><a href="registration.htm">Signup</a></li>
  
</ul>
</div>

<div id="screen1">
  <div class="layer">
   <springform:form modelAttribute="login" action="doLogin.htm" method="post">
    
       <center><springform:input type ="text" placeholder="Enter Username" path="adminId" ></springform:input></center><br>
   
       <center><springform:input type = "password" placeholder ="Password" path="password"  id="psw"  
 ></springform:input><br><br></center><br><br>
 
        <center><springform:errors path="adminId" style="color:red"></springform:errors></center>
       <center><button type= "submit">LOGIN</button></center>

  </springform:form>


    </div>
</div>

<div id="screen2">
 <center><h1>ABOUT US</h1><hr>
 <p style="float:left; width:50%; padding:15px; margin-top:5%;">Medicenter is a leading integrated healthcare delivery service provider in India.
 The healthcare verticals of the company primarily comprise hospitals, diagnostics and day care specialty facilities.
 Currently, the company operates its healthcare delivery services in India,
 Dubai, Mauritius and Sri Lanka with 43 healthcare facilities (including projects under development),
 approximately 9,000 potential beds and 392 diagnostic centres.<br><br>
 In a global study of the 30 most technologically advanced hospitals in the world, its flagship,
 the Fortis Memorial Research Institute’ (FMRI), was ranked No.2, by 
‘topmastersinhealthcare.com, and placed ahead of many other outstanding medical institutions in the world.
 Hospitals complement and amplify the effectiveness of many other parts of the health system,
 providing continuous availability of services for acute and complex conditions.
 Hospitals concentrate scarce resources within well-planned referral networks to respond efficiently to population health needs.
 They are an essential element of Universal Health Coverage and will be critical to meeting the Sustainable Development Goals.</p>

<img style="width:45%; heigth:320px; margin-top:5%;" src="http://ilshospitals.com/blog/wp-content/uploads/2017/03/cuide-coracao-1-1024x576.jpg"/>
</div>

<div id="screen3">
 <div class="layer">

 </div>
</div>

<div id="screen4">
 <img src="https://mondrian.mashable.com/uploads%252Fcard%252Fimage%252F919545%252Fa212b37f-fdc1-4a22-8d7e-64309869b016.jpg%252F950x534__filters%253Aquality%252890%2529.jpg?signature=HqGL1sLS100TkfApW5oai1EwdXE=&source=https%3A%2F%2Fblueprint-api-production.s3.amazonaws.com"/>
 <form action="contactPage.htm" method="post">
 <button style ="width:80%;">CONTACT US</button><br><br>
 <input type="text" placeholder="Enter Your Name" name="Username" required/><br><br>
 <input type="text" placeholder="Email-Id" name="emailid" required/><br><br>
 <input type="text" placeholder="Contact No." required/><br><br> 
 <input style ="padding-top:50px; padding-bottom:50px;" type="text" placeholder="message" required/><br><br>
 <center><button style="margin-right:10%;" type="submit">Send</button></center>
 </form>
</div>
</body>
</html>