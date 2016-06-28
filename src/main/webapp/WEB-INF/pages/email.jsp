<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script src="<c:url value="/resources/js/getListOfUsers.js"/>"></script>

<div id="web-form-wrapper">
    <div id="add-customer-web-form">
        <div class="col-lg-4 col-md-4 col-sm-2 col-xs-0"></div>
        <div class="col-lg-4 col-md-4 col-sm-8 col-xs-12 signupContent">
            <form:form method="post" modelAttribute="emailMessageTemplate" action="/email/sendEmail">
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
                    <button type="button" class="btn btn-danger btn-x" onclick="getSortedCustomers()">
                        Populate Sorted Customers
                    </button>
                    <button type="button" class="btn btn-danger btn-x" onclick="getUnsortedCustomers()">
                        Populate Unsorted Customers
                    </button>
                </div>
                <div id="submit-customer-btn-div">
                    <button type="submit" id="submit-customer-btn" class="btn btn-primary">Submit</button>
                </div>
            </form:form>
        </div>
        <div class="col-lg-4 col-md-4 col-sm-2 col-xs-0"></div>
    </div>
</div>




