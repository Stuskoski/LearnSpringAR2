<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"></jsp:include>


<div class="container-fluid">
    <h1>Logging</h1>

    <button class="btn btn-primary btn-xs" type="button" onclick="refreshLogs()">Refresh Logs</button>
    <button class="btn btn-danger btn-xs" type="button" onclick="clearLogs()">Clear Logs</button>
    <div id="logContainer">
        Refresh Logs
    </div>
    <div id="noticeContainer">

    </div>
    <button class="btn btn-primary btn-xs" type="button" onclick="refreshLogs()">Refresh Logs</button>
    <button class="btn btn-danger btn-xs" type="button" onclick="clearLogs()">Clear Logs</button>
</div>

<script src="<c:url value="/resources/js/LoggingActions.js"/>"></script>