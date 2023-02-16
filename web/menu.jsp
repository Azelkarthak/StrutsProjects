
<!doctype html>
<html lang="en">
     
    
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script>

                        function fetchContent(targetId,target) {
                            $.ajax({
                                url: target,

                                success: function (responseText) {
                                    $("#" + targetId).html(responseText);
                                }
                            });
                        }
                        
                        


        </script>
                
    
                
    <head>
        <title>Employee Management</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <meta name="theme-color" content="#712cf9">

        <!-- Custom styles for this template -->
        <link href="css/header.css" rel="stylesheet">
        <!--<link href="css/carousel.css" rel="stylesheet">-->
    </head>
   
    <header class="p-3 text-bg-dark">
        <div class="container"> 
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                    <img src="images/flower-logo.jpg" width="75" height="75"></img>
                </a>

                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="#" onclick= "fetchContent('targetId','AddEmpPage')"class="nav-link px-2 text-white">Add Employee</a></li>
                    <li><a href="#" onclick= "fetchContent('targetId','GetAllData')" class="nav-link px-2 text-white" >Show Employee</a></li>
                    <li><a href="#" onclick= "fetchContent('targetId','AddSearchPage')" class="nav-link px-2 text-white">Search Employee</a></li>
                    <li><a href="#"  class="nav-link px-2 text-white">Update Employee</a></li>
                    <li><a href="#" class="nav-link px-2 text-white">Sign Out</a></li>
                    <li><a href="FetchUrl" class="nav-link px-2 text-white">API Fetch</a></li>
                </ul>

                <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
                    <input type="search" class="form-control form-control-dark text-bg-dark" placeholder="Search..." aria-label="Search">
                </form>

                <div class="text-end">
                    <% if (request.getSession().getAttribute("Loggedin") == null) {%>

                    <a href="login.jsp">
                        <button type="button" class="btn btn-outline-light me-2" >Login</button>
                    </a>
                    <a href="preSignUp">
                        <button type="button" class="btn btn-warning">Sign-up</button>
                    </a>
                    <%
                        }
                    else {%>

                    <a href="Logout">
                        <button type="button" class="btn btn-outline-light me-2" >Log Out</button>
                    </a>
                    <%
                        }
                    %>


                </div>
            </div>
        </div>
    </header>
       
                    
                    
                    
                    
                   
    
   <div id="targetId"></div>
 
       