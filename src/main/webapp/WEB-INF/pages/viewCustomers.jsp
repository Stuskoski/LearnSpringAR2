<jsp:include page="header.jsp"/>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<c:url var="addAction" value="/customer/add"/>

<div class="container">
<h2>Customers</h2>
    <table class="table table-striped table-bordered" id="customerTable">
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
            <th>Edit</th>
            <th>Removal</th>
        </tr>
        </thead>
        <tbody>
<c:if test="${!empty listCustomers}">
        <c:forEach items="${listCustomers}" var="DbCustomerEntity">
            <tr id="customerRow${DbCustomerEntity.id}">
                <td id="customerEntityIds${DbCustomerEntity.id}"><div contenteditable="false">${DbCustomerEntity.id}
                </div></td>
                <td id="customerEntityFirstName${DbCustomerEntity.id}" oninput="enableLink(${DbCustomerEntity.id})">
                    <div contenteditable="true"><c:out value="${DbCustomerEntity.firstName}"/></div></td>

                <td id="customerEntityLastName${DbCustomerEntity.id}" oninput="enableLink(${DbCustomerEntity.id})">
                    <div contenteditable="true"><c:out value="${DbCustomerEntity.lastName}"/></div></td>

                <td id="customerEntityEmailAddress${DbCustomerEntity.id}" oninput="enableLink(${DbCustomerEntity.id})">
                    <div contenteditable="true"><c:out value="${DbCustomerEntity.emailAddress}"/></div></td>

                <td id="customerEntityHomeAddress${DbCustomerEntity.id}" oninput="enableLink(${DbCustomerEntity.id})">
                    <div contenteditable="true"><c:out value="${DbCustomerEntity.homeAddress}"/></div></td>

                <td id="customerEntityCity${DbCustomerEntity.id}" oninput="enableLink(${DbCustomerEntity.id})">
                    <div contenteditable="true"><c:out value="${DbCustomerEntity.city}"/></div></td>

                <td id="customerEntityState${DbCustomerEntity.id}" oninput="enableLink(${DbCustomerEntity.id})">
                    <div contenteditable="true"><c:out value="${DbCustomerEntity.state}"/></div></td>

                <td id="customerEntityZipCode${DbCustomerEntity.id}" oninput="enableLink(${DbCustomerEntity.id})">
                    <div contenteditable="true"><c:out value="${DbCustomerEntity.zipCode}"/></div></td>

                <td id="customerEntityTimeStamp${DbCustomerEntity.id}">
                    <div contenteditable="false"><c:out value="${DbCustomerEntity.timeStamp}"/></div></td>

                <td><a onclick="editCustomer(${DbCustomerEntity.id})" id="commitLink${DbCustomerEntity.id}"
                       class="disabledAnchor" style="cursor: pointer;">Commit Edit</a></td>

                <td><a onclick="deleteCustomer(${DbCustomerEntity.id})" id="deleteLink${DbCustomerEntity.id}"
                       style="cursor: pointer;">Delete</a></td>
            </tr>
        </c:forEach>
</c:if>
        </tbody>
    </table>
</div>

<script src="<c:url value="/resources/js/editUserJS.js"/>"></script>
<script src="<c:url value="/resources/js/jquery-1.12.3.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.dataTables.min.js"/>"></script>
<link href="<c:url value="/resources/css/jquery.dataTables.min.css"/>" rel="stylesheet">

