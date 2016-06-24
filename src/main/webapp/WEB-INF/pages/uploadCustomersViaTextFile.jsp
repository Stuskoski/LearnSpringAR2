<jsp:include page="header.jsp"></jsp:include>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<form method="POST" action="/uploadCustomerViaFile" enctype="multipart/form-data">
    File to upload: <input type="file" name="file">


    <input type="submit" value="Upload"> Press here to upload the file!
</form>
