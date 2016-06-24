<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"></jsp:include>

<div id="web-form-wrapper">
    <div id="add-customer-web-form">
        <div class="col-lg-4 col-md-4 col-sm-2 col-xs-0"></div>
        <div class="col-lg-4 col-md-4 col-sm-8 col-xs-12 signupContent">
            <form:form method="post" modelAttribute="customer" action="/customer/add">
                <div id="upload-customer-title">Upload Customer</div>
                <fieldset class="form-group">
                    <label for="lastName">First Name</label>
                    <form:input path="firstName" id="firstName" cssClass="form-control"
                                placeholder="Enter Customer First Name" required="true"/>
                </fieldset>
                <fieldset class="form-group">
                    <label for="lastName">Last Name</label>
                    <form:input path="lastName" id="lastName" cssClass="form-control"
                                placeholder="Enter Customer Last Name" required="true"/>
                </fieldset>
                <fieldset class="form-group">
                    <label for="emailAddress">Email address</label>
                    <form:input path="emailAddress" id="emailAddress" cssClass="form-control"
                                placeholder="Enter Customer Email Address" required="true"/>
                </fieldset>
                <fieldset class="form-group">
                    <label for="homeAddress">Home Address</label>
                    <form:input path="homeAddress" id="homeAddress" cssClass="form-control"
                                placeholder="Enter Customer Home Address" required="true"/>
                </fieldset>
                <fieldset class="form-group">
                    <label for="city">City</label>
                    <form:input path="city" id="city" cssClass="form-control" placeholder="Enter Customer City"
                                required="true"/>
                </fieldset>
                <fieldset class="form-group">
                    <label for="state">State</label>
                    <form:input path="state" id="state" cssClass="form-control" placeholder="Enter Customer State"
                                required="true"/>
                </fieldset>
                <fieldset class="form-group">
                    <label for="zipCode">Zip Code</label>
                    <form:input path="zipCode" id="zipCode" cssClass="form-control"
                                placeholder="Enter Customer Zip Code" required="true"/>
                </fieldset>
                <div id="submit-customer-btn-div">
                    <button type="submit" id="submit-customer-btn" class="btn btn-primary">Submit</button>
                </div>

            </form:form>
        </div>
        <div class="col-lg-4 col-md-4 col-sm-2 col-xs-0"></div>
    </div>
</div>
