<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="web-form-wrapper">
    <div id="add-customer-web-form">
        <div class="signupContent">
            <form:form method="post" modelAttribute="emailMessageTemplate">
                <div id="upload-customer-title">Send Email</div>
                <fieldset class="form-group">
                    <label for="toEmail">To: </label>
                    <form:input path="toEmail" id="toEmail" cssClass="form-control"
                                placeholder="email@address.com" required="true"/>
                </fieldset>
                <fieldset class="form-group">
                    <label for="fromEmail">From: </label>
                    <form:input path="fromEmail" id="fromEmail" cssClass="form-control"
                                placeholder="email@address.com" required="true"/>
                </fieldset>
                <fieldset class="form-group">
                    <label for="subject">Subject: </label>
                    <form:input path="subject" id="subject" cssClass="form-control"
                                placeholder="Email Subject" required="true"/>
                </fieldset>
                <fieldset class="form-group">
                    <label for="message">Message: </label>
                    <form:textarea path="message" id="message" cssClass="form-control" placeholder="Email Message"
                                   required="true"/>
                </fieldset>
                <div class="container-fluid text-center non-block" id="populateEmailButtonsDiv">
                    <button type="button" class="customHEBButtonSmall btn" onclick="getSortedCustomers()">
                        Sort Customers
                    </button>
                    <button type="button" class="customHEBButtonSmall btn" onclick="getUnsortedCustomers()">
                        Unsort Customers
                    </button>
                </div>
                <div id="submit-customer-btn-div">
                    <button type="button" id="submit-customer-btn" class="customBlueButtonSmall btn" onclick="sendEmail()">
                        Send Email
                    </button>
                </div>
            </form:form>
        </div>
    </div>
</div>




