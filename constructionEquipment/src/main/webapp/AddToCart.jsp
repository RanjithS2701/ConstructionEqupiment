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
<body>

<%
	int productId =Integer.parseInt((String)request.getParameter("product_id"));
	inventDataAccess pdao = new inventDataAccess(connection.getConnection());
	Product pro = pdao.getSingleProduct(productId);
	
	

%>

<body>


  

    <nav id="main">
        <div class="logo" style="width: 100%; margin-left:auto; margin-right: auto;">
            <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; MARSS</span>
             <span style="padding-left: 60%;">
            
    </nav>

<!-- Popup -->

<!-- Modal -->
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header header">
        <div >
         
        <h5 class="modal-title" id="staticBackdropLabel">Rent Me</h5>
      
      </div>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body bodybg">
        <form action="/"  method="post"> 
          <input type="hidden" name="action" value="changePassword">
          <div class="form-group ">
            <div >
                  <img id="productImage" src="GetImage?product_id=<%=pro.getProduct_id() %>" >
            </div>
          </div><br>
          <div class="form">
            <div class="form-group ">
              <div id="productName">Product Name :<%=pro.getPname() %>
			  </div>
            </div><br>
          <div class="form-group ">
            <div id="<%=pro.getPriceperhr() %>">
            </div>
          </div><br>

            <div class="form-group">
              <label for="">Quantity: </label>
              <input type="text" name="quantity" id="quantity"> 
            </div><br>
            <div class="form-group">
              <label for="">Time: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
              <input type="text" name="time" id="time">
            </div><br>
 			

           <input type="button" onclick="priceCalc()" value="Calculate">
          
          </div>
			
          <div class="modal-footer">

           <input type="submit" value="Rent">
          </div>
        </form>
        <div id="result"></div>
      </div>
      
    </div>
  </div>
  
<script>
var quant;
var times;
var prodAmount;

   
function priceCalc() {
	var quant = document.getElementById("quantity").value ;
	alert(quant);

	var times = document.getElementById("time").value ;
	alert(times);
	
	var prodAmount = document.getElementById("time").value ;
	alert(prodAmount);
	
	document.getElementById("result").innerHTML = quant * times * prodAmount ;

}
</script>

</body>

</html>