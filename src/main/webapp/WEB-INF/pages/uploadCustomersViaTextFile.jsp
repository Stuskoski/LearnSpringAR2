<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<div class="col-lg-2 col-md-2 col-sm-3 col-xs-2"></div>
<div class="col-lg-8 col-md-8 col-sm-6 col-xs-8">
    <form id="customerFileForm" method="POST" enctype="multipart/form-data"
          onsubmit="event.preventDefault(); uploadCustomerFile(); enableAnimation();">

        <span>
            <span>File to upload:</span>
            <input class="" type="file" name="file" id="customerFile" required>
        </span>

        <input type="submit" value="Upload" class="customHEBButtonSmall btn">
        Press here to upload the file!

        <div id="loginErrorMsg"></div>
    </form>
</div>
<div class="col-lg-2 col-md-2 col-sm-3 col-xs-2"></div>

