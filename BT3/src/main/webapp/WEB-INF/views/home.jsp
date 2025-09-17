<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Settings</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
  <h2 class="mb-4">Settings</h2>
  <p>${mess}</p>
  <!-- action: URL mapping tới controller, modelAttribute: tên object trong Model -->
  <form:form method="post" modelAttribute="mail" action="/home">

    <!-- Language -->
    <div class="mb-3">
      <label for="language" class="form-label fw-bold">Languages</label>
      <form:select id="language" class="form-select" path="language">
        <form:option value="English" label="English"/>
        <form:option value="Vietnamese" label="Vietnamese"/>
        <form:option value="Japanese" label="Japanese"/>
        <form:option value="Chinese" label="Chinese"/>
      </form:select>
    </div>

    <!-- Page Size -->
    <div class="mb-3">
      <label for="pageSize" class="form-label fw-bold">Page Size</label>
      <form:select id="pageSize" class="form-select" path="pageSize">
        <form:option value="5" label="5 emails per page"/>
        <form:option value="10" label="10 emails per page"/>
        <form:option value="15" label="15 emails per page"/>
        <form:option value="25" label="25 emails per page"/>
        <form:option value="50" label="50 emails per page"/>
        <form:option value="100" label="100 emails per page"/>
      </form:select>
    </div>

    <!-- Spam Filter -->
    <div class="form-check mb-3">
      <form:checkbox path="spamFilter" cssClass="form-check-input" id="spamFilter"/>
      <label for="spamFilter" class="form-check-label fw-bold">Enable spams filter</label>
    </div>

    <!-- Signature -->
    <div class="mb-3">
      <label for="signature" class="form-label fw-bold">Signature</label>
      <form:textarea id="signature" class="form-control" rows="4" path="signature"/>
    </div>

    <!-- Buttons -->
    <div class="d-flex gap-2">
      <button type="submit" class="btn btn-primary">Update</button>
      <a href="/settings" class="btn btn-secondary">Cancel</a>
    </div>
  </form:form>
</div>
</body>
</html>
