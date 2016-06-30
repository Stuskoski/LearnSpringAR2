<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<div class="col-lg-2 col-md-2 col-sm-3 col-xs-2"></div>
<div class="col-lg-8 col-md-8 col-sm-6 col-xs-8">
    <form id="customerFileForm" method="POST" action="${pageContext.request.contextPath}/uploadCustomerViaFile"
           enctype="multipart/form-data">

    File to upload: <input class="" type="file" name="file" id="customerFile">

    <input type="button" value="Upload" onclick="enableAnimation(); uploadCustomerFile();" class="customHEBButtonSmall btn">
    Press here to upload the file!

    <div id="loginErrorMsg"></div>
</form></div>
<div class="col-lg-2 col-md-2 col-sm-3 col-xs-2"></div>

