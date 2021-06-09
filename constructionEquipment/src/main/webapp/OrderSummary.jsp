<%@page import="com.construction.pojo.Order"%>
<%@page import="com.construction.pojo.Cart"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Order Summary</title>

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
      <!-- fontawesome -->
      <script src="https://kit.fontawesome.com/c6361b72de.js" crossorigin="anonymous"></script>
    <!-- CSS FILE -->
    <link rel="stylesheet" href="css/ordersummary.css" type="text/css" />

</head>
<%
	List<Cart> cart = (List<Cart>)session.getAttribute("cart");

%>

<body>



    <body>


        <nav id="main">
            <div class="logo" style="width: 100%; margin-left:auto; margin-right: auto;">
                <span style="font-size:30px;cursor:pointer">MARSS</span>

                <ul>
                    <li><a href="#" data-bs-toggle="modal" data-bs-target="#OrderModal">Back To Home</a></li>

                </ul>
            </div>
        </nav>
        <div id="Order-head">

            
            <h2 style="  font-size: 45px;">Thank You for Ordering <i class="far fa-smile-wink"></i></h2>
			<h5 style="  font-size: 20px;">Your Order Summary</h5>

        </div>

        <div>




            <div class="container">
                <div class="card">
                        
                            <div class="horizontal-list">
                                <ul id="list-sec">
                                    <li class="col col-1">Order Date</li>
                                    <li class="col col-2">Product Name</li>
                                    <li class="col col-3">Quantity</li>
                                    <li class="col col-4">Time</li>
                                    <li class="col col-5">Price</li>
                                </ul>
<%
int amount=0;
for(Cart c:cart)
{
	LocalDate date=LocalDate.now();
	String orderdate = String.valueOf(date);
	
%>
                                <ul id="list-pro">
                                    <li class="col col-1"><%=orderdate %></li>
                                    <li class="col col-2"><%=c.getP_name() %></li>
                                    <li class="col col-3"><%=c.getQuantity() %></li>
                                    <li class="col col-4"><%=c.getTime() %> hrs</li>
                                    <li class="col col-5">Rs. <%=c.getTotal_cost() %></li>
                                </ul>
<% 
amount += c.getTotal_cost();

} %>                 
                               
                            </div>
                            <div id="footer" style="margin-top: 30px;">
                            <h5 style="padding-left:56%;">Total Amount Is : Rs.<%=amount %><span id="result"></span> </label></h5>
                            <h6 style="margin-top: 30px;"> Your order has been successfully placed. Its waiting for approval.Please check your account frequently</h6>
                        </div>
                </div>
            </div>
            <div>

               
            </div>


        </div>





        </div>



    </body>

</html>