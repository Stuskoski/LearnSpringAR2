<div>
  <div class="well">
    <h4>Web Application Statistics</h4>
  </div>
  <div class="row">
    <div class="col-sm-3">
      <div class="well">
        <h4>DB Entries</h4>

        <p>${stats.dbEntries}</p>
      </div>
    </div>
    <div class="col-sm-3">
      <div class="well">
        <h4>Texas Customers</h4>

        <p>${stats.numberOfTexans}</p>
      </div>
    </div>
    <div class="col-sm-3">
      <div class="well">
        <h5>Non Texas Customers</h5>

        <p>${stats.numberOfNonTexans}</p>
      </div>
    </div>
    <div class="col-sm-3">
      <div class="well">
        <h4>Registered Users</h4>

        <p>${stats.numberOfUsers}</p>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-sm-4">
      <div class="well">
        <p>Last Email Sent </p>

        <p>${stats.lastEmail}</p>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="well">
        <p>Last Customer Upload</p>

        <p>${stats.lastCustomerUpdate}</p>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="well">
        <p>Current Logs</p>
        <p>${stats.numberOfLogs}</p>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-sm-8">
      <div class="well">
        <p>Database Size In MB</p>
        <p>${stats.dbSizeInMB}</p>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="well">
        <p>Current ${sessionScope.userLoggedIn}</p>
      </div>
    </div>
  </div>
</div>
