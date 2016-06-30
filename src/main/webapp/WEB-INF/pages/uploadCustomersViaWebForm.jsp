<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="col-lg-2 col-md-2 col-sm-3 col-xs-2"></div>
<div class="col-lg-8 col-md-8 col-sm-6 col-xs-8">
    <div id="add-customer-web-form">
        <div class="signupContent">
            <form:form method="post" modelAttribute="customer" action="/customer/add" id="allFieldsFullForm">
                <div id="upload-customer-title">Upload Customer</div>
                <fieldset class="form-group">
                    <label for="firstName">First Name</label>
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
                    <button type="button" id="submit-customer-btn" onclick="uploadCustomerViaWebForm()"
                            class="customHEBButtonSmall btn">Submit</button>
                </div>

            </form:form>
        </div>
        <div id="webFormMsg"></div>
    </div>
</div>

<div class="col-lg-2 col-md-2 col-sm-3 col-xs-2"></div>
