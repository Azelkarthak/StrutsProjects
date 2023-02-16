<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.84.0">
        <title>Employee Management</title>

        <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">



        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet" >

        <!-- Favicons -->
        <link rel="apple-touch-icon" href="/docs/5.0/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
        <link rel="icon" href="/docs/5.0/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
        <link rel="icon" href="/docs/5.0/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
        <link rel="manifest" href="/docs/5.0/assets/img/favicons/manifest.json">
        <link rel="mask-icon" href="/docs/5.0/assets/img/favicons/safari-pinned-tab.svg" color="#7952b3">
        <link rel="icon" href="/docs/5.0/assets/img/favicons/favicon.ico">
        <meta name="theme-color" content="#7952b3">

<script>
function val() {
signupForm.submit();
}
</script>

    

        <!-- Custom styles for this template -->
        <link href="css/signin.css" rel="stylesheet">
    </head>
    <body class="text-center">

       <main class="form-signin">
            <form action="Location" id="signupForm" method="Post">
                <img class="mb-4" src="images/india.jpg" alt="" width="300" height="180">
                <!--<h1 class="h3 mb-3 fw-normal">Please Add Employee</h1>-->
                <div class="form-floating">
                    <select name="countryId" class="form-select" id="countryId" onchange="val()">
                        <option value="0">Select a country</option>
                        <c:forEach var="country" items="${CountryList}">
                            <option value= ${country.getCountryId()}<c:if test="${country.getCountryId()==User.getCountryId()}"> selected </c:if>>  ${country.getCountryName()}  </option>
                      </c:forEach>
                    </select>                         
                </div>

                <div class="form-floating">
                    <select name="stateId" class="form-select" id="stateId" onchange="val()">
                        <option value="0">Select a state</option>
                      <c:forEach var="state" items="${StateList}">
                         
                            <option value= ${state.getStateId()}  <c:if test="${state.getStateId()==User.getStateId()}"> selected </c:if>>  ${state.getStateName()}  </option>
                            
                      </c:forEach>
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
                <br><br>

            <button class="w-100 btn btn-lg btn-primary" style="background-color: blue; border: none" type="submit">Save</button>

            </form>
        </main>



    </body>
</html>