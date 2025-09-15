<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exchange Money</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/d3ee10eebc.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </style>
</head>
<body>
<div class="container">
    <h2 >Sandwich Condiments</h2>
    <br>
    <br>
    <form action="/home/sandwich" method="post">
        <c:forEach var="spice" items="${allSpices}">
            <label>
                <input type="checkbox" name="spices" value="${spice}" />
                    ${spice}
            </label><br/>
        </c:forEach>

        <div class="mt-3 text-end">
            <button type="submit" class="btn btn-primary btn-lg px-4">save</button>
        </div>
    </form>
</div>
</body>
</html>
