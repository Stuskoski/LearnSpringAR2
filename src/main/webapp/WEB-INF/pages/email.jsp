<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="col-lg-2 col-md-2 col-sm-3 col-xs-2"></div>
<div class="col-lg-8 col-md-8 col-sm-6 col-xs-8">
    <div id="add-customer-web-form">
        <div class="signupContent">
            <form:form method="post" modelAttribute="emailMessageTemplate" id="allFieldsFullForm"
                       onsubmit="event.preventDefault(); sendEmail()">
                <div id="send-email-title">Send Email</div>
                <fieldset class="form-group">
                    <label for="toEmail">To: </label>
                    <form:input path="toEmail" id="toEmail" cssClass="form-control"
                                placeholder="email@address.com" required="true"
                                pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
                                title="Enter a valid email address up to 50 characters"
                                maxlength="50"/>
                </fieldset>
                <fieldset class="form-group">
                    <label for="fromEmail">From: </label>
                    <form:input path="fromEmail" id="fromEmail" cssClass="form-control"
                                placeholder="email@address.com" required="true"
                                pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
                                title="Enter a valid email address up to 50 characters"
                                maxlength="50"/>
                </fieldset>
                <fieldset class="form-group">
                    <label for="subject">Subject: </label>
                    <form:input path="subject" id="subject" cssClass="form-control"
                                placeholder="Email Subject" required="true"
                                pattern="[A-Za-z!?.]{1,60}"
                                maxlength="60"
                                title="Please enter a subject using only numbers and characters as well as {!?.} and with a max length of 60"/>
                </fieldset>
                <fieldset class="form-group">
                    <label for="message">Message: </label>
                    <form:textarea path="message" id="message" cssClass="form-control" placeholder="Email Message"
                                   required="true"/>
                </fieldset>
                <div id="populateEmailButtonsDiv">
                    <button type="button" class="customHEBButtonSmall btn" onclick="getSortedCustomers()">
                        Sort Customers
                    </button>
                    <button type="button" class="customHEBButtonSmall btn" onclick="getUnsortedCustomers()">
                        Unsort Customers
                    </button>
                </div>
                <div id="send-email-btn-div">
                    <button type="submit" id="send-email-btn" class="customBlueButtonSmall btn">
                        Send Email
                    </button>
                </div>
            </form:form>
        </div>
    </div>
</div>
<div class="col-lg-2 col-md-2 col-sm-3 col-xs-2"></div>




