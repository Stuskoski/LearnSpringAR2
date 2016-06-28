<jsp:include page="header.jsp"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>



<form method="POST" action="${pageContext.request.contextPath}/uploadCustomerViaFile" enctype="multipart/form-data">
    File to upload: <input type="file" name="file">
    <input type="submit" value="Upload" onclick="enableAnimation()"> Press here to upload the file!
</form>
