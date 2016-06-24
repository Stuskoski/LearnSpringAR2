<jsp:include page="header.jsp"></jsp:include>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<c:url var="addAction" value="/customer/add"></c:url>

<br>

<h3>Persons List</h3>

<c:if test="${!empty listCustomers}">
    <div class="container">
    <h2>Striped Rows</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email Address</th>
            <th>Home Address</th>
            <th>City</th>
            <th>State</th>
            <th>Zip Code</th>
            <th>Time Stamp</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${listCustomers}" var="DbCustomerEntity">
            <tr>
                <td>${DbCustomerEntity.id}</td>
                <td>${DbCustomerEntity.firstName}</td>
                <td>${DbCustomerEntity.lastName}</td>
                <td>${DbCustomerEntity.emailAddress}</td>
                <td>${DbCustomerEntity.homeAddress}</td>
                <td>${DbCustomerEntity.city}</td>
                <td>${DbCustomerEntity.state}</td>
                <td>${DbCustomerEntity.zipCode}</td>
                <td>${DbCustomerEntity.timeStamp}</td>
                <td><a href="<c:url value='/edit/${DbCustomerEntity.id}' />">Edit</a></td>
                <td><a href="<c:url value='/remove/${DbCustomerEntity.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
</c:if>


