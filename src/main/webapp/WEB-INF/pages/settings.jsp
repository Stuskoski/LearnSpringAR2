<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="web-form-wrapper">
    <div id="add-customer-web-form">
        <div class="signupContent">
            <form:form method="post" modelAttribute="settingsTemplate" action="">
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
                    <button type="button" id="submit-settings-btn" class="btn btn-primary" onclick="editSettings()">
                        Submit
                    </button>
                </div>
            </form:form>

        </div>
    </div>
</div>