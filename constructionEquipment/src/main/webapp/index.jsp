<!DOCTYPE html>
<html lang="en" onload="voice()">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MARSS</title>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&family=Ubuntu:wght@500&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
        integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <!------------- css styles ---------------------->
    <link rel="stylesheet" href="css/styles.css" type="text/css"/>
    <!--------------font awesome ---------------------->
    <script src="https://kit.fontawesome.com/c6361b72de.js" crossorigin="anonymous"></script>
 
</head>

<body >


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

    <div  id="img1">
      
      <div id="hammerImgDiv">
         <a href="#card"><img src="nail.png" id="hammer-initial" class="hammer-done"  alt="nail" width="80" height="80"></a>
         
      </div>
        
        <div  class="container">
            <div id="card" class="card">
              <h3 class="title">WHO</h3>
              <div class="bar">
                <div class="emptybar"></div>
                <div class="filledbar"></div>
                
                <p class="cardpara">Trying to rent out construction tool ? You have landed at the correct place.MARSS is ready to help you out.</p>
              </div>
            </div >
            <div class="card">
              <h3 class="title">WHY</h3>
              <div class="bar">
                <div class="emptybar"></div>
                <div class="filledbar"></div>
                <p class="cardpara"></p>
              </div>
            </div>
            <div class="card">
              <h3 class="title">WHERE</h3>
              <div class="bar">
                <div class="emptybar"></div>
                <div class="filledbar"></div>
                <p class="cardpara"></p>
              </div>
            </div>
            <div  class="card">
              <h3 class="title">HOW</h3>
              <div class="bar">
                <div class="emptybar"></div>
                <div class="filledbar"></div>
                <p class="cardpara"></p>
              </div>
            </div>
        </div> 
            

        
     </div>

    </div>

    <div id="first-bottom-container">
      <h4 class="botpar">DROP YOUR THOUGHTS HERE</h4>
      <form action="https://formcarry.com/s/pG3l-elSNEf" method="POST" accept-charset="UTF-8" >

         <div >
        <label for="email" class="botpar"> EMAIL</label>
        <input type="email" name="email" class="txtbox"> </div><!-- use this to reply visitors and prevent spam via akismet -->
        <div >
        <label for="text" class="botpar">FEEDBACK</label>
        <input type="text" name="anotherInput" class="txtbox"> </div><br>
        <input type="hidden" name="_gotcha"> <!-- use this to prevent spam -->
        <!-- <input type="submit" value="submit"class="submit"> -->
        <button type="submit" value="submit"class="btn1">SUBMIT</button>
    
    
    
    
    
        </form>
    </div>

    <div id="bottom-container">
      <p class="botpar1">Always be in touch with us</p>

      <i class=" fab fa-twitter fa-2x  Icon"></i>
      <i class="fab fa-instagram fa-2x  Icon"></i>
      <i class="fab fa-facebook-f fa-2x  Icon"></i>
     <a href="mailto: marssinc14@gmail.com" target="_blank"><i class="fas fa-envelope fa-2x  Icon"></i></a>

        <p class="ftext">Copyright @ MARSS</p>
      


    </div>

<script type="text/javascript">


document.getElementById("hammer-initial").addEventListener("click", function() {

  makeSound();
 


});

function makeSound(){
  var tom1 = new Audio("Knock.mp3");
      tom1.play();
}
function backgroundChange(){
  
}

</script>



</body>

</html>