<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
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
                    <a class="navbar-brand" id="logoDiv" href="#"><img id="hebLogo"
                                                                       src="<c:url value="/resources/images/hebLogo.pn" />"></a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>

                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false">Database<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class="dropdown-header">Database</li>
                                <li><a href="${pageContext.request.contextPath}/modifyDB">Modify Database</a></li>
                                <li><a href="${pageContext.request.contextPath}/customers">View Customers</a></li>

                                <li class="dropdown-header">Upload Customers</li>
                                <li><a href="${pageContext.request.contextPath}/uploadCustomers/textFileUpload">Text
                                    File</a></li>
                                <li><a href="${pageContext.request.contextPath}/uploadCustomers/webFormUpload">Web
                                    Form</a></li>
                            </ul>
                        </li>

                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false">Information<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class="dropdown-header">Information</li>
                                <li><a href="${pageContext.request.contextPath}/logging">Logging</a></li>
                                <li><a href="${pageContext.request.contextPath}/email">Email</a></li>
                            </ul>
                        </li>

                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false">Other<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class="dropdown-header">Other</li>
                                <li><a href="${pageContext.request.contextPath}/settings">Settings</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <div id="header-right-btns-div">
                            <div class="non-block">
                                <a class="btn btn-danger btn-xs non-block"
                                   href="${pageContext.request.contextPath}/signup">Sign Up</a>
                            </div>
                            <div class="non-block">
                                <a class="btn btn-danger btn-xs non-block"
                                   href="${pageContext.request.contextPath}/login">Login</a>
                            </div>
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