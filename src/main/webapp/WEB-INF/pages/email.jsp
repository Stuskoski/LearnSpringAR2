<jsp:include page="header.jsp"></jsp:include>

<div id="container-fluid text-center">
  <div>
    <a class="btn btn-danger btn-xs non-block" href="${pageContext.request.contextPath}/email/sendSortedEmail">Send TX Sorted List</a>
  </div>
  <div>
    <a class="btn btn-danger btn-xs non-block" href="${pageContext.request.contextPath}/email/sendUnsortedEmail">Send Unsorted List</a>
  </div>
</div>

<c:if test="${!empty listCustomers}">
  <c:forEach items="${listCustomers}" var="DbCustomerEntity">
    <tr id="customerRow${DbCustomerEntity.id}">
      <td id="customerEntityIds${DbCustomerEntity.id}"><div contenteditable="false">${DbCustomerEntity.id}</div></td>
      <td id="customerEntityFirstName${DbCustomerEntity.id}" oninput="enableLink(${DbCustomerEntity.id})"><div contenteditable="true"><c:out value="${DbCustomerEntity.firstName}"/></div></td>
      <td id="customerEntityLastName${DbCustomerEntity.id}" oninput="enableLink(${DbCustomerEntity.id})"><div contenteditable="true"><c:out value="${DbCustomerEntity.lastName}"/></div></td>
      <td id="customerEntityEmailAddress${DbCustomerEntity.id}" oninput="enableLink(${DbCustomerEntity.id})"><div contenteditable="true"><c:out value="${DbCustomerEntity.emailAddress}"/></div></td>
      <td id="customerEntityHomeAddress${DbCustomerEntity.id}" oninput="enableLink(${DbCustomerEntity.id})"><div contenteditable="true"><c:out value="${DbCustomerEntity.homeAddress}"/></div></td>
      <td id="customerEntityCity${DbCustomerEntity.id}" oninput="enableLink(${DbCustomerEntity.id})"><div contenteditable="true"><c:out value="${DbCustomerEntity.city}"/></div></td>
      <td id="customerEntityState${DbCustomerEntity.id}" oninput="enableLink(${DbCustomerEntity.id})"><div contenteditable="true"><c:out value="${DbCustomerEntity.state}"/></div></td>
      <td id="customerEntityZipCode${DbCustomerEntity.id}" oninput="enableLink(${DbCustomerEntity.id})"><div contenteditable="true"><c:out value="${DbCustomerEntity.zipCode}"/></div></td>
      <td id="customerEntityTimeStamp${DbCustomerEntity.id}"><div contenteditable="false"><c:out value="${DbCustomerEntity.timeStamp}"/></div></td>
      <td><a onclick="editCustomer(${DbCustomerEntity.id})" id="commitLink${DbCustomerEntity.id}" class="disabledAnchor" style="cursor: pointer;">Commit Edit</a></td>
      <td><a onclick="deleteCustomer(${DbCustomerEntity.id})" id="deleteLink${DbCustomerEntity.id}" style="cursor: pointer;">Delete</a></td>
    </tr>
  </c:forEach>
</c:if>

