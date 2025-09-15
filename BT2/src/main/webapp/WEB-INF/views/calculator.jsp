<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Calculator</title></head>
<body>
<h1>Calculator</h1>

<form action="/home/calculator" method="post">
    <input type="number" name="num1" required />
    <input type="number" name="num2" required />
    <br><br>
    <button type="submit" name="operator" value="add">Addition(+)</button>
    <button type="submit" name="operator" value="sub">Subtraction(-)</button>
    <button type="submit" name="operator" value="mul">Multiplication(X)</button>
    <button type="submit" name="operator" value="div">Division(/)</button>

    <p>Result ${opName} : ${result}</p>
</form>
</body>
</html>

</body>
</html>
