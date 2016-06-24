<jsp:include page="header.jsp"></jsp:include>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<c:url var="addAction" value="/customer/add"></c:url>


<script src="<c:url value="/resources/js/editUserJS.js"/>"></script>

<br>


<c:if test="${!empty listCustomers}">
    <div class="container">
    <h2>Customers</h2>
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
                <td id="customerEntityIds${DbCustomerEntity.id}" oninput="enableLink(${DbCustomerEntity.id})"><div contenteditable="false">${DbCustomerEntity.id}</div></td>
                <%--<td id="customerEntityId">${DbCustomerEntity.id}</td>--%>
                <td id="customerEntityFirstName${DbCustomerEntity.id}" oninput="enableLink(${DbCustomerEntity.id})"><div contenteditable="true">${DbCustomerEntity.firstName}</div></td>
                <td id="customerEntityLastName${DbCustomerEntity.id}" oninput="enableLink(${DbCustomerEntity.id})"><div contenteditable="true">${DbCustomerEntity.lastName}</div></td>
                <td id="customerEntityEmailAddress${DbCustomerEntity.id}" oninput="enableLink(${DbCustomerEntity.id})"><div contenteditable="true">${DbCustomerEntity.emailAddress}</div></td>
                <td id="customerEntityHomeAddress${DbCustomerEntity.id}" oninput="enableLink(${DbCustomerEntity.id})"><div contenteditable="true">${DbCustomerEntity.homeAddress}</div></td>
                <td id="customerEntityCity${DbCustomerEntity.id}" oninput="enableLink(${DbCustomerEntity.id})"><div contenteditable="true">${DbCustomerEntity.city}</div></td>
                <td id="customerEntityState${DbCustomerEntity.id}" oninput="enableLink(${DbCustomerEntity.id})"><div contenteditable="true">${DbCustomerEntity.state}</div></td>
                <td id="customerEntityZipCode${DbCustomerEntity.id}" oninput="enableLink(${DbCustomerEntity.id})"><div contenteditable="true">${DbCustomerEntity.zipCode}</div></td>
                <td id="customerEntityTimeStamp${DbCustomerEntity.id}" oninput="enableLink(${DbCustomerEntity.id})"><div contenteditable="true">${DbCustomerEntity.timeStamp}</div></td>
                <td><a onclick="editCustomer(${DbCustomerEntity.id})" id="commitLink${DbCustomerEntity.id}" class="disabledAnchor" href="#">Commit Edit</a></td>
                <td><a href="<c:url value='/remove/${DbCustomerEntity.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
</c:if>


