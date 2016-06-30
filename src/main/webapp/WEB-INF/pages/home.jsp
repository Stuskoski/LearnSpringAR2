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
                        setLinkActive('side-nav-bar-database');" class="non-link">Database&#xbb;</a>
                        <ul class="hideMe" id="databaseLinks">
                            <li><a onclick="pullModifyDatabasePage();" class="non-link">Modify Database</a></li>
                            <li><a onclick="pullViewCustomersPage();" class="non-link">View Customers</a></li>
                        </ul>
                    </li>

                    <li class="">
                        <a onclick="showCustomerOptions(); setLinkActive('side-nav-bar-upload-customers');"
                           id="side-nav-bar-upload-customers" class="non-link">Upload Customers &#xbb;</a>
                        <ul class="hideMe" id="customerLinks">
                            <li><a onclick="pullUploadTextFilePage();" class="non-link">Text File</a></li>
                            <li><a onclick="pullUploadWebFormPage();" class="non-link">Web Form</a></li>
                        </ul>
                    </li>

                    <li class="">
                        <a onclick="showInformationOptions(); setLinkActive('side-nav-bar-information');"
                           id="side-nav-bar-information" class="non-link">Information &#xbb;</a>
                        <ul class="hideMe" id="informationLinks">
                            <li><a onclick="pullLoggingPage();" class="non-link">Logging</a></li>
                            <li><a onclick="pullEmailPage();" class="non-link">Email</a></li>
                        </ul>
                    </li>

                    <li class="" id="side-nav-bar-settings">
                        <a onclick="pullSettingsPage(); setLinkActive('side-nav-bar-settings');" id=""
                           class="non-link">Settings&#x203A;</a>
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


<script src="<c:url value="/resources/js/dashboard.js"/>"></script>
<script src="<c:url value="/resources/js/ShowAndHideInfoWindow.js"/>"></script>
<script src="<c:url value="/resources/js/ModifyDatabase.js"/>"></script>
<script src="<c:url value="/resources/js/UploadCustomers.js"/>"></script>
<script src="<c:url value="/resources/js/SendEmail.js"/>"></script>
<script src="<c:url value="/resources/js/EditSettings.js"/>"></script>
<script src="<c:url value="/resources/js/LoggingActions.js"/>"></script>
<script src="<c:url value="/resources/js/GetListOfUsers.js"/>"></script>
<script src="<c:url value="/resources/js/EditUserJS.js"/>"></script>
<script src="<c:url value="/resources/js/jquery-1.12.3.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.dataTables.min.js"/>"></script>
<link href="<c:url value="/resources/css/jquery.dataTables.min.css"/>" rel="stylesheet">




