<%@ page import="com.construction.servlet.Register" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration</title>
<link
  href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&family=Ubuntu:wght@500&display=swap"
  rel="stylesheet">
<link rel="stylesheet"
  href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
  integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
  crossorigin="anonymous">
<link rel="stylesheet" href="css/styles.css" type="text/css" />


</head>
<body onload="createCaptcha()">
  <nav>
    <div class="logo">
      <p>MARSS</p>
    </div>

    <ul>
      <li><a href="index.jsp">HOME</a></li>
      <li><a href="login.jsp">Log In</a></li>
      <li><a href="register.jsp">Register</a></li>


    </ul>
  </nav>

  <div class="background">
    <div class="blur"></div>
  </div>


<form class="btn" action="Register" method="post">
    <table>
      <h8 style="color: red;">Fields marked with (*) are mandatory</h8>
      <br>
      <tr>
        <td><label for="fname">First Name<span
            style="color: red;">*</span></label><br> <input type="text"
          id="fname" name="fname" value="" placeholder="First Name" required><br>
        </td>
        <td><label for="lname">Last Name:</label><br> <input
          type="text" id="lname" name="lname" value=""
          placeholder="Last Name"><br></td>
      </tr>
      <tr>
        <td><label for="uname">User Name<span
            style="color: red;">*</span></label><br> <input type="text"
          id="uname" name="uname" value="" placeholder="User Name" required><br>
        </td>
        <td><label for="password">Password<span
            style="color: red;">*</span></label><br> <input type="password"
          name="password" id="password" placeholder="" required> <br></td>
      </tr>
      <tr>
        <td><label for="DOB">Date of Birth <br> <input type="date" id="DOB"
          name="dob" placeholder="Date Of Birth" > <br></td>
        <td><label for="Gender">Gender</label><br>
          <select name="gender">
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Others">Others</option>
        </select> <br></td>
      </tr>
      <tr>
        <td><label for="Phone">Phone Number<span
            style="color: red;">*</span></label><br> <input type="text"
          id="number" name="phoneno" placeholder="Phone Number"required> <br>
        </td>
        <td><label for="email">Email<span style="color: red;">*</span></label><br>
          <input type="email" name="email" id="email" placeholder="Email" required>
          <br></td>
      </tr>
    </table><br>
    <table>
      <tr>
        <div id="captcha" style="background-color: aliceblue; width:40%;height:40px; margin:0 auto 8px auto"></div>
        <input type="text" placeholder="Captcha" id="cpatchaTextBox" required />
         <button type="submit" onclick="validateCaptcha()">Verify</button> 
      </tr>
        <h6 id="captchaVerify"></h6>
      </tr>

    </table>
    <a href="login.jsp" style="text-decoration: underline;">Already have Account</a>
    <br> <br> <input id="button" type="submit" value="Submit" onclick="window.location.href='adminhome.html'" disabled="true"/>

  </form>
  
  <div id="bottom-container">


    <p class="ftext">Copyright @ MARSS</p>



  </div>
  <script>
    var code;
    function createCaptcha() {
      //clear the contents of captcha div first 
      document.getElementById('captcha').innerHTML = "";
      var charsArray = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ@!#$%^&*";
      var lengthOtp = 6;
      var captcha = [];
      for (var i = 0; i < lengthOtp; i++) {
        //below code will not allow Repetition of Characters
        var index = Math.floor(Math.random() * charsArray.length + 1); //get the next character from the array
        if (captcha.indexOf(charsArray[index]) == -1)
          captcha.push(charsArray[index]);
        else
          i--;
      }
      var canv = document.createElement("canvas");
      canv.id = "captcha";
      canv.width = 100;
      canv.height = 50;
      var ctx = canv.getContext("2d");
      ctx.font = "25px Georgia";
      ctx.strokeText(captcha.join(""), 0, 30);
      //storing captcha so that can validate you can save it somewhere else according to your specific requirements
      code = captcha.join("");
      document.getElementById("captcha").appendChild(canv); // adds the canvas to the body element
    }
    function validateCaptcha() {
      event.preventDefault();
      debugger
      if (document.getElementById("cpatchaTextBox").value == code) {
        const button = document.getElementById('button');
        button.disabled = false ;
        
        document.getElementById("captchaVerify").innerHTML = "Valid Captcha";

        
      
        
      } else {
        const button = document.getElementById('button');
        button.disabled = true ;
        document.getElementById("captchaVerify").innerHTML = "Invalid Captcha Try again";
        
        createCaptcha();
      }
    }
    // function CaptchaValidation() {
    //   event.preventDefault();
    //   debugger
    //   if (document.getElementById("cpatchaTextBox").value != code) {
    //     document.getElementById("captchaVerify").innerHTML = "Check your captcha and submit";
    //     createCaptcha();
    //   } 
    //   else{
    //     window.location.href = "adminhome.html";
    //   } 
  
    // }
    // function redirectTo() {
    //   window.location.href = "home.html";
    // }
  </script>

</body>
</html>