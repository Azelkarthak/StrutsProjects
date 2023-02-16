<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <jsp:include page="menu.jsp"></jsp:include>  
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.104.2">
        <title>Sign in - Employee Management</title>

        <link href="css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

        <meta name="theme-color" content="#712cf9">


        <!-- Custom styles for this template -->
        <link href="css/signin.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.6.3.js" 
                            integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" 
                    crossorigin="anonymous"></script>
        <script>

            function fetchContent(selectedId, targetId)
                    {
           //  alert("'#"+selectedId.name+"'");
                           
                                    $.ajax({
                                            url: 'preSignUp',
                                            data: {
                                                    [selectedId]: $("#" + selectedId).val()
                                            },
                                            success: function (responseText) {
             //            alert(responseText);
                                                    $("#" + targetId).html(responseText);
                                            }
                                    });
                            
                    }


        </script> 


    </head>

    <body class="text-center">


        <main class="form-signin w-100 m-auto">
            <form action="" id="signupForm" method="Post">
                <img class="mb-4" src="images/flower-logo.jpg" alt="" width="200" height="200">
                <h1 class="h3 mb-3 fw-normal">Please provide below information</h1>

                <div class="form-floating">
                    <input name = "email" type="email" class="form-control" id="floatingInput" placeholder="name@example.com" value='${User.email}'>
                    <label for="floatingInput">Email address</label>
                </div>
                <div class="form-floating">
                    <input name="password" type="password" class="form-control" id="floatingPassword" placeholder="Password" value='${User.password}'>
                    <label for="floatingPassword">Password</label>
                </div>
                <div class="form-floating">
                    <input name="firstName" type="text" class="form-control" id="firstName" placeholder="first name" value='${User.firstName}'>
                    <label for="firstName">First Name</label>
                </div>
                <div class="form-floating">
                    <input name="lastName" type="text" class="form-control" id="lastName" placeholder="last name" value='${User.lastName}'>
                    <label for="firstName">Last Name</label>
                </div>
                
                <div class="form-floating">
                    <select name="countryId" class="form-select" id="countryId" onchange="fetchContent('countryId', 'stateId')">
                        <option value="0">Select a country</option>
                        <c:forEach var="country" items="${CountryList}">
                            <option value= ${country.getCountryId()} <c:if test="${country.getCountryId()==User.getCountryId()}"> selected </c:if>>  ${country.getCountryName()}  </option>
                      </c:forEach>
                    </select>                         
                </div>

                <div class="form-floating">
                    <select name="stateId" class="form-select" id="stateId" onchange="fetchContent('stateId','districtId')">
                        <option value="0">Select a state</option>
                      
                    </select>
                </div>
                <div class="form-floating">
                    <select name="districtId" class="form-select" id="districtId" >
                        <option value="0">Select a city</option>
                        <c:forEach var="district" items="${DistrictList}">
                            <option value= ${district.getDistrictId()} >  ${district.getDistrictName()}  </option>
                        </c:forEach>

                    </select>
                </div>



                <!--                <div class="checkbox mb-3">
                                    <label>
                                        <input type="checkbox" value="remember-me"> Remember me
                                    </label>
                                </div>-->
                <button class="w-100 btn btn-lg btn-primary" type="submit">Sign Up</button>
                <a href="landingPage.jsp">
                    <button type="button" class="w-100 btn btn-lg btn-warning">Cancel</button>
                </a>
                <p class="mt-5 mb-3 text-muted">&copy; 2017?2022</p>
            </form>
        </main>



    </body>
</html>