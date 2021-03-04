<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf8" />
    <title>Instance Management</title>
    <link rel="stylesheet" href="css/main.css" />
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
            integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
            crossorigin="anonymous"
    />
    <style>
        body {
            font-family: "Oswald", sans-serif;
        }
    </style>
</head>
<body>
<h1 style="position: relative; text-align: center; padding-top: 40px">Instance Management</h1>
<div class="container" style="padding-top: 50px;">
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th scope="col">User</th>
            <th scope="col">Purpose</th>
            <th scope="col">Time</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${data}" var="data">
            <tr>
                <td>${data.user}</td>
                <td>${data.purpose}</td>
                <td>${data.time}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
