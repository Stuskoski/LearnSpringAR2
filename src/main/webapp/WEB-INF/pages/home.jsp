<jsp:include page="header.jsp"/>

<div class="container-fluid">
    <div class="row content">
        <div class="col-sm-3 sidenav hidden-xs">
            <h2>Customer Portal</h2>
            <ul class="nav nav-pills nav-stacked">
                <li class="active"><a href="#section1">Dashboard</a></li>
                <li><a href="#section2">Database</a></li>
                <li><a href="${pageContext.request.contextPath}/uploadCustomers/textFileUpload">Gender</a></li>
                <li><a href="#section3">Geo</a></li>
            </ul>
            <br>
        </div>
        <br>

        <div id="homeScreenLoader">
            <jsp:include page="modify.jsp"/>
        </div>
    </div>
</div>


<jsp:include page="footer.jsp"/>



