<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Selected Spices</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://kit.fontawesome.com/d3ee10eebc.js" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
<div class="container">
  <h2>Gia vị đã chọn</h2>
  <br>
  <c:choose>
    <c:when test="${not empty chosenSpices}">
      <ul>
        <c:forEach var="s" items="${chosenSpices}">
          <li><c:out value="${s}" /></li>
        </c:forEach>
      </ul>
    </c:when>
    <c:otherwise>
      <p>Không có gia vị nào được chọn.</p>
    </c:otherwise>
  </c:choose>
  <p><a class="btn btn-warning" href="/home/sandwich">Quay lại</a></p>
</div>
</body>
</html>
