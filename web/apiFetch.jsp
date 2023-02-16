<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${Loggedin==null}">
    <c:redirect url="landingPage.jsp"/>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/product.css" rel="stylesheet">
        <title>Fetch Info From API</title>
    </head>
    <body>
        
        <jsp:include page="menu.jsp"></jsp:include>
            <div class="d-flex align-items-center justify-content-center mt-3">
                <form action="FetchUrl" method="get">
                    <div class="form-outline">
                        <select name="sizeOfData"class="form-select">
                            <option value="0">--select end point---</option>
                            <option value="1">single object</option>
                            <option value="2">multiple object(Array of json data)</option>
                        </select>
                    </div>
                    <div class="form-outline mt-4">
                        <input type="text" id="url" class="form-control" placeholder="...paste your url here..." name="url"/>
                    </div>
                    <div class="d-flex align-items-center justify-content-center mt-3">
                        <button type="submit" class="btn btn-outline-success">
                            submit
                        </button>
                    </div>
                </form>
            </div>
        <c:if test="${TextArea!=null}">
            <div class="form-group">
                <label for="exampleFormControlTextarea1">JSON DATA FETCHED FROM GIVEN URL</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="11" readonly>${TextArea}</textarea>
            </div>
        </c:if>
    </body>
</html>