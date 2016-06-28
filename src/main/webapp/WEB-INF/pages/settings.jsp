<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"/>



<div id="web-form-wrapper">
    <div id="add-customer-web-form">
        <div class="col-lg-4 col-md-4 col-sm-2 col-xs-0"></div>
        <div class="col-lg-4 col-md-4 col-sm-8 col-xs-12 signupContent">
            <form:form method="post" modelAttribute="settingsTemplate" action="/settings/changeSettings">
                <div id="upload-customer-title">Settings</div>
                <fieldset class="form-group">
                    <label for="databaseURL">Database URL</label>
                    <form:input path="databaseURL" id="databaseURL" cssClass="form-control"
                                placeholder="enter database connection string" required="true"/>
                </fieldset>
                <fieldset class="form-group">
                    <label for="rootDatabaseURL">Root Database URL</label>
                    <form:input path="rootDatabaseURL" id="rootDatabaseURL" cssClass="form-control"
                                placeholder="enter root database connection string" required="true"/>
                </fieldset>
                <fieldset class="form-group">
                    <label for="databaseUser">Datbase Username</label>
                    <form:input path="databaseUser" id="databaseUser" cssClass="form-control"
                                placeholder="enter database name" required="true"/>
                </fieldset>
                <fieldset class="form-group">
                    <label for="databasePass">Database Password</label>
                    <form:password path="databasePass" id="databasePass" cssClass="form-control"
                                placeholder="enter database password" required="true"/>
                </fieldset>
                <fieldset class="form-group">
                    <label for="mailHost">Mail Host</label>
                    <form:input path="mailHost" id="mailHost" cssClass="form-control" placeholder="enter mail host"
                                required="true"/>
                </fieldset>
                <div id="saveAlert" class="center-text">** All changes are saved until server restart **</div><br>
                <div id="submit-customer-btn-div">
                    <button type="submit" id="submit-customer-btn" class="btn btn-primary">Submit</button>
                </div>
            </form:form>
        </div>
        <div class="col-lg-4 col-md-4 col-sm-2 col-xs-0"></div>
    </div>
</div>