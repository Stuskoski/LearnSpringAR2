<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="col-lg-2 col-md-2 col-sm-3 col-xs-2"></div>
<div class="col-lg-8 col-md-8 col-sm-6 col-xs-8">
    <div id="add-customer-web-form">
        <div class="signupContent">
            <form:form method="post" modelAttribute="customer" id="allFieldsFullForm"
                       onsubmit="event.preventDefault(); uploadCustomerViaWebForm();">
                <div id="upload-customer-title">Upload Customer</div>
                <fieldset class="form-group">
                    <label for="firstName">First Name</label>
                    <form:input path="firstName" id="firstName" cssClass="form-control"
                                placeholder="Enter Customer First Name" required="true" pattern="[A-Za-z]{1,30}"
                                title="Enter a valid first name between 2 and 30 characters"
                                maxlength="30"/>
                </fieldset>
                <fieldset class="form-group">
                    <label for="lastName">Last Name</label>
                    <form:input path="lastName" id="lastName" cssClass="form-control"
                                placeholder="Enter Customer Last Name" required="true" pattern="[A-Za-z]{2,30}"
                                title="Enter a valid last name between 2 and 30 characters"
                                maxlength="30"/>
                </fieldset>
                <fieldset class="form-group">
                    <label for="emailAddress">Email address</label>
                    <form:input path="emailAddress" id="emailAddress" cssClass="form-control"
                                placeholder="Enter Customer Email Address" required="true"
                                pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
                                title="Enter a valid email address up to 50 characters"
                                maxlength="50"/>
                </fieldset>
                <fieldset class="form-group">
                    <label for="homeAddress">Home Address</label>
                    <form:input path="homeAddress" id="homeAddress" cssClass="form-control"
                                placeholder="Enter Customer Home Address" required="true" pattern="[A-Za-z0-9]{5,60}"
                                title="Enter a valid home address between 5 and 60 characters"
                                maxlength="60"/>
                </fieldset>
                <fieldset class="form-group">
                    <label for="city">City</label>
                    <form:input path="city" id="city" cssClass="form-control" placeholder="Enter Customer City"
                                required="true" pattern="[A-Za-z]{2,40}"
                                title="Enter a valid city between 2 and 40 characters"
                                maxlength="40"/>
                </fieldset>
                <fieldset class="form-group">
                    <label for="state">State</label>
                    <form:input path="state" id="state" cssClass="form-control" placeholder="Enter Customer State"
                                required="true"
                                pattern="[A-Za-z]{2}"
                                title="Enter a 2 character shorthand value for customers state"
                                maxlength="2"/>

                </fieldset>
                <fieldset class="form-group">
                    <label for="zipCode">Zip Code</label>
                    <form:input path="zipCode" id="zipCode" cssClass="form-control"
                                placeholder="Enter Customer Zip Code" required="true"
                                pattern="[0-9]{2,15}"
                                title="Enter a valid zip code between 2 and 15 characters"
                                maxlength="15"/>
                </fieldset>
                <div id="submit-customer-btn-div">
                    <button type="submit" id="submit-customer-btn" class="customHEBButtonSmall btn">
                        Submit
                    </button>
                </div>

            </form:form>
        </div>
        <div id="webFormMsg"></div>
    </div>
</div>

<div class="col-lg-2 col-md-2 col-sm-3 col-xs-2"></div>
