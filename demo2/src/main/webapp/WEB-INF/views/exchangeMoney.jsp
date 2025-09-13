<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/13/2025
  Time: 5:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exchange Money</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/d3ee10eebc.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        .input{
            width: 30rem;
            opacity: 1;
            padding: 5px 10px;
            border: 1px solid #ccc;
            background-color: white;
            border-radius: 30px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2 >Chuyển tiền USD - VND</h2>
    <br>
    <br>
    <form action="/home/exchangeMoney" method="post">
        <div class="d-flex gap-2 align-items-center">
            <label for="usd" class="form-label">Số tiền</label>
            <input id="usd"
                   name="usd"
                   type="number"
                   min="1"
                   class="input"
                   placeholder="Nhập số tiền..."
                   value="${usd}" />

            <label for="vnd" class="form-label">USD tương đương với</label>
            <input id="vnd"
                   name="vnd"
                   class="input"
                   value="${vnd}"
                   readonly />
            <span>VND</span>
        </div>

        <c:if test="${not empty error}">
            <div class="text-danger mt-2">${error}</div>
        </c:if>

        <br>
        <div class="mt-3 text-end">
            <button type="submit" class="btn btn-primary btn-lg px-4">Đổi</button>
        </div>    </form>
</div>
</body>
</html>
