<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<option value="0">Select a city</option>
                        <c:forEach var="district" items="${DistrictList}">
                            <option value= ${district.getDistrictId()} <c:if test="${district.getDistrictId()==User.getDistrictId()}"> selected </c:if>>  ${district.getDistrictName()}  </option>
                        </c:forEach>