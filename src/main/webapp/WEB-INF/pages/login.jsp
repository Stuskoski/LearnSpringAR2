<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"/>

<div class="signupContent">
    <form:form method="post" modelAttribute="userEntity" action="/login/getUser">
        <div id="upload-customer-title">Login</div>
        <fieldset class="form-group">
            <label for="userName">Username</label>
            <form:input path="userName" id="userName" cssClass="form-control"
                        placeholder="Enter username" required="true"/>
        </fieldset>
        <fieldset class="form-group">
            <label for="password">Password</label>
            <form:input path="password" id="password" cssClass="form-control"
                        placeholder="Enter password" required="true"/>
        </fieldset>
        <div id="submit-customer-btn-div">
            <button type="submit" id="login-user-btn" class="customHEBButtonSmall btn">Login</button>
            <button type="reset" id="clear-user-btn" class="customHEBButtonSmall btn">Clear</button>
        </div>

    </form:form>
</div>