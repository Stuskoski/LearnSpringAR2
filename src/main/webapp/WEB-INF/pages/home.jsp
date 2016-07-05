<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<!-- Begin Body -->
<div class="container" id="dashboard-container">
    <div class="row">
        <div class="col-md-2">

            <div class="list-group" id="sidebar">
                <h2>Customer Portal</h2>
                <ul class="nav nav-pills nav-stacked">

                    <li class="" id="side-nav-bar-stats">
                        <a onclick="pullStatsPage(); setLinkActive('side-nav-bar-stats');" class="non-link">Stats
                            &#x203A;</a>
                    </li>

                    <li class="">
                        <a id="side-nav-bar-database" onclick="showDatabaseOptions();
                        setLinkActive('side-nav-bar-database');" class="non-link">Database &#xbb;</a>
                        <ul class="hideMe" id="databaseLinks">
                            <li><a onclick="pullModifyDatabasePage(); setLinkActive('side-nav-bar-database');"
                                   class="non-link">Modify Database</a></li>
                            <li><a onclick="pullViewCustomersPage(); setLinkActive('side-nav-bar-database');"
                                   class="non-link">View Customers</a></li>
                        </ul>
                    </li>

                    <li class="">
                        <a onclick="showCustomerOptions(); setLinkActive('side-nav-bar-upload-customers');"
                           id="side-nav-bar-upload-customers" class="non-link">Upload Customers &#xbb;</a>
                        <ul class="hideMe" id="customerLinks">
                            <li><a onclick="pullUploadTextFilePage(); setLinkActive('side-nav-bar-upload-customers');"
                                   class="non-link">Text File</a></li>
                            <li><a onclick="pullUploadWebFormPage(); setLinkActive('side-nav-bar-upload-customers');"
                                   class="non-link">Web Form</a></li>
                        </ul>
                    </li>

                    <li id="side-nav-bar-logging">
                        <a onclick="pullLoggingPage(); setLinkActive('side-nav-bar-logging');" class="non-link">
                            Logging &#x203A;</a>
                    </li>

                    <li id="side-nav-bar-email">
                        <a onclick="pullEmailPage(); setLinkActive('side-nav-bar-email');" class="non-link">
                            Email &#x203A;</a>
                    </li>


                    <li class="" id="side-nav-bar-settings">
                        <a onclick="pullSettingsPage(); setLinkActive('side-nav-bar-settings');"
                           class="non-link">Settings &#x203A;</a>
                    </li>
                </ul>
                <br>
            </div>

        </div>

        <div id="homeScreenLoader" class=" col-lg-10 col-md-10 col-sm-10 col-xs-10">
            <%-- Content to be loaded with ajax --%>
        </div>


    </div>
</div>

<%-- Add all the scripts at the end of the page to help with loading --%>
<script src="<c:url value="/resources/js/dashboard.js"/>"></script>
<script src="<c:url value="/resources/js/ShowAndHideInfoWindow.js"/>"></script>
<script src="<c:url value="/resources/js/ModifyDatabase.js"/>"></script>
<script src="<c:url value="/resources/js/UploadCustomers.js"/>"></script>
<script src="<c:url value="/resources/js/SendEmail.js"/>"></script>
<script src="<c:url value="/resources/js/EditSettings.js"/>"></script>
<script src="<c:url value="/resources/js/LoggingActions.js"/>"></script>
<script src="<c:url value="/resources/js/getListOfUsers.js"/>"></script>
<script src="<c:url value="/resources/js/EditUserJS.js"/>"></script>
<script src="<c:url value="/resources/js/jquery-1.12.3.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.dataTables.min.js"/>"></script>
<link href="<c:url value="/resources/css/jquery.dataTables.min.css"/>" rel="stylesheet">


<%-- Tags were opened in header.  Closed here --%>
</body>
</html>




