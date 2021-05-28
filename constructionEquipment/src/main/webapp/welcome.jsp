<%@page import="java.util.List"%>
<%@page import="com.construction.pojo.Product"%>
<%@page import="com.construction.dao.connection"%>
<%@page import="com.construction.pojo.User"%>
<%@page import="com.construction.dao.inventDataAccess"%>
<%@page import="com.construction.dao.UserDataAccess"%>
<!DOCTYPE html>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>User Home</title>

   <!-- CSS only -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
  <!-- JavaScript Bundle with Popper -->
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
    integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous">
  </script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
    integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous">
  </script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous">
  </script>
   <!-- CSS FILE -->
   <link rel="stylesheet" href="css/welcome.css" type="text/css"/>

</head>
<%
    User user=(User)session.getAttribute("active-user");
	/* UserDataAccess udao;
	udao = new UserDataAccess(connection.getConnection());
	List<User> list = udao.getAllUsers();  */
	User usr = (User)session.getAttribute("user-name");
	String uname = usr.getUname();
	UserDataAccess userdao = new UserDataAccess(connection.getConnection());
    User udetail = userdao.getSingleUserDetail(uname);
%>
<body>


    <div id="mySidenav" class="sidenav">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <a href="#"><%= udetail.getFname()%> <%= udetail.getLname()%></a>
        <a href="EditProfile.jsp?uname=<%= user.getUname()%>">Edit Profile</a>
        <a href="#">Help</a>
        <a href="login.jsp">Logout</a>
       	<div class="message" style="color: pink;text-align:center;font-weight:bold;text-decoration:underline;">${Message}</div><br>
    </div>

    <nav id="main">
        <div class="logo" style="width: 100%; margin-left:auto; margin-right: auto;">
            <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; MARSS</span>
             <span style="padding-left: 60%;">
        <a  style="color: #fff;" href="#" data-bs-toggle="modal" data-bs-target="#exampleModal"> Change Password</a>
      </span>
            <span style="color:#fff; padding-left:3%;">Hello, <%= udetail.getFname()%> <%= udetail.getLname()%></span>
        </div>
    </nav>

    <section class="Colured-section" id="testimonials">
    <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
      <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
      </div>
      <div class="carousel-inner">
        <div class="carousel-item active container-fluid">
          <h2 class="Testimonial-text">Team work divides the Task and multiplies the Success</h2>
          <img class="testimonial-image" src="img/carousel1.jfif" alt="profile">
         

        </div>
        <div class="carousel-item container-fluid">
          <h2 class="Testimonial-text">If we shape our Buildings;Thereafter they shape us</h2>
          <a href="#"><img class="testimonial-image" src="img/carousel2.jfif" alt="profile"></a>
        

        </div>
        <div class="carousel-item container-fluid">
          <h2 class="Testimonial-text">Construction is a matter of optimism; It's a matter of facing the future with confidence.</h2>
          <img class="testimonial-image" src="img/carousel3.jfif" alt="profile">
        </div>
      </div>
      <button class="carousel-control-prev previousButton" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button class="carousel-control-next nextButton" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
    </section>
    
    <!---------------------- cards ---------------------------->
    <div class="gallery">
       <%
    inventDataAccess pdao;
    pdao = new inventDataAccess(connection.getConnection());
    List<Product> list = pdao.getAllProducts(); 
    for(Product pr: list)
	{
	%>
    
      <div class="content">
		<img src="GetImage?product_id=<%=pr.getProduct_id() %>" height=100 width=150>
        <font size="5"><%= pr.getPname() %></font><br>
        <font size="3">In Stock :<%= pr.getQuantity() %></font><br>
        <font size="3">Rs.<%= pr.getPriceperhr() %> per hour</font>
        
        <button class="buy-2">RENT ME</button>
      </div>
      <% 
		}
	  %>
      
     
    </div>
    
   <!-- change password modal -->
  


  
  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header header">
          <h5 class="modal-title" id="exampleModalLabel">CHANGE PASSWORD</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <div class="modal-body">
            <!-- formstarting -->
            <form action="ChangePassword" method="post"> 
              <input type="hidden" name="action" value="changePassword">

              <div class="form">
                <div class="form-group ">
                  <label for="inputPassword4">User Name</label>
                  <input type="text" value="<%= user.getUname()%>" class="form-control" id="inputPassword4" name="username" readonly >
                </div><br>
               <!--  <div class="form-group ">
                  <label for="inputPassword4">Current Password</label>
                  <input type="password" class="form-control" id="inputPassword4" name="currentpassword"  >
                </div><br> -->
                <div class="form-group">
                  <label for="inputPassword4">New Password</label>
                  <input type="password" class="form-control" id="pass" name="newpassword" >
                </div>

              </div>

              <div class="modal-footer">

                <input type="submit" value="submit" class="btn btn-primary">
              </div>
            </form>
          </div>
        </div>

      </div>
    </div>
  </div>







    <script>
        function openNav() {
            document.getElementById("mySidenav").style.width = "250px";
            document.getElementById("main").style.marginLeft = "250px";
        }

        function closeNav() {
            document.getElementById("mySidenav").style.width = "0";
            document.getElementById("main").style.marginLeft = "0";
        }
    </script>

</body>

</html>