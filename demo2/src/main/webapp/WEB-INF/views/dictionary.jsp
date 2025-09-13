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
    <title>Simple Dictionary</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/d3ee10eebc.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
    <h2 >Tra cứu từ điển Anh - Việt</h2>

    <form action="/home/dictionary" id="dictionaryForm" method="post">
        <div class="d-flex gap-2">
            <div class="col-md-6">
                <label class="form-label">From</label>
                <textarea name="word" class="form-control form-control-lg w-100" rows="4"
                          placeholder="Nhập từ tiếng Anh...">${word}</textarea>
            </div>
            <div class="col-md-6">
                <label class="form-label">To</label>
                <textarea name="meaning"
                          class="form-control form-control-lg w-100"
                          rows="4" readonly>${not empty meaning ? meaning : error}
                </textarea>
            </div>
        </div>
        <div class="mt-3 text-end">
            <button type="submit" class="btn btn-primary btn-lg px-4">Dịch</button>
        </div>
    </form>
</div>


</body>
</html>
