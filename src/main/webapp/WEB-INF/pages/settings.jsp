<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="col-lg-2 col-md-2 col-sm-3 col-xs-2"></div>
<div class="col-lg-8 col-md-8 col-sm-6 col-xs-8">
    <div id="add-customer-web-form">
        <div class="signupContent">
            <form:form method="post" modelAttribute="settingsTemplate"
                       onsubmit="event.preventDefault(); editSettings()" id="allFieldsFullForm">
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
                    <label for="databaseUser">Database Username</label>
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
                <fieldset class="form-group">
                    <label for="mailFrom">From Email</label>
                    <form:input path="mailFrom" id="mailFrom" cssClass="form-control" placeholder="enter from email"
                                required="true"/>
                </fieldset>
                <div id="saveAlert" class="center-text">** All changes are saved until server restart **</div><br>
                <div id="submit-customer-btn-div">
                    <button type="submit" id="submit-settings-btn" class="customHEBButtonSmall btn btn-danger">
                        Submit
                    </button>
                </div>
            </form:form>

        </div>
    </div>
</div>
<div class="col-lg-2 col-md-2 col-sm-3 col-xs-2"></div>