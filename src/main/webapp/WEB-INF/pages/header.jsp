
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>

<body>
<div id="wrapper">
    <div id="header-wrapper">
        <nav class="navbar navbar-inverse custom-header">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" id="logoDiv" href="${pageContext.request.contextPath}/assignment2">
                        <img id="hebLogo" src="<c:url value="/resources/images/hebLogo.png" />">
                    </a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="${pageContext.request.contextPath}/assignment2">Home</a></li>

                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false">Database<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class="dropdown-header">Database</li>
                                <li><a class="non-link" onclick="pullModifyDatabasePage()">Modify Database</a></li>
                                <li><a class="non-link" onclick="pullViewCustomersPage()">View Customers</a></li>

                                <li class="dropdown-header">Upload Customers</li>
                                <li><a class="non-link" onclick="pullUploadTextFilePage()">Text File</a></li>
                                <li><a class="non-link" onclick="pullUploadWebFormPage()">Web Form</a></li>
                            </ul>
                        </li>

                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false">Information<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class="dropdown-header">Information</li>
                                <li><a class="non-link" onclick="pullLoggingPage()">Logging</a></li>
                                <li><a class="non-link" onclick="pullEmailPage()">Email</a></li>
                            </ul>
                        </li>

                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false">Other<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class="dropdown-header">Other</li>
                                <li><a class="non-link" onclick="pullSettingsPage()">Settings</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <div id="header-right-btns-div">
                            <c:choose>
                                <c:when test="${empty sessionScope.userLoggedIn}">
                                    <a class="btn customHEBButtonXSmall non-block"
                                       href="${pageContext.request.contextPath}/login">Login
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a class="btn customHEBButtonXSmall non-block"
                                       href="${pageContext.request.contextPath}/logout">Logout
                                    </a>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </ul>
                </div>
            </div>
        </nav>
    </div>



    <%-- add the loading page to every page.
         not sure if I like it just yet or
         only to add on long loading pages--%>
<jsp:include page="loadingAnimation.jsp"/>
<jsp:include page="infoPopup.jsp"/>