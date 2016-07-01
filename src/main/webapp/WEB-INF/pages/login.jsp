<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"/>

<div class="col-lg-4 col-md-4 col-sm-3 col-xs-2"></div>
<div class="col-lg-4 col-md-4 col-sm-6 col-xs-8">
    <div class="loginContent">
        <form:form method="post" modelAttribute="userEntity" action="/login/getUser">
            <div id="upload-customer-title">Login</div> <%-- todo fix id--%>
            <fieldset class="form-group" id="login-user-username-field">
                <label for="userName">Username</label>
                <form:input path="userName" id="userName" cssClass="form-control"
                            placeholder="Enter username" required="true"/>
            </fieldset>
            <fieldset class="form-group" id="login-user-password-field">
                <label for="password">Password</label>
                <form:password path="password" id="password" cssClass="form-control"
                            placeholder="Enter password" required="true"/>
            </fieldset>
            <div id="submit-customer-btn-div">
                <button type="submit" id="login-user-btn" class="customHEBButtonSmall btn">Login</button>
                <button type="reset" id="clear-user-btn pull-right" class="customHEBButtonSmall btn">Clear</button>
            </div>

        </form:form>

        <div id="loginErrorMsg">
            ${userLoginError}
        </div>
    </div>
</div>
<div class="col-lg-4 col-md-4 col-sm-3 col-xs-2"></div>
