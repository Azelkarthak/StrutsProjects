<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<option value="0">Select a state</option>
<c:forEach var="state" items="${StateList}">
 <option value= ${state.getStateId()}  <c:if test="${state.getStateId()==User.getStateId()}"> selected </c:if>>  ${state.getStateName()}  </option>
 </c:forEach>