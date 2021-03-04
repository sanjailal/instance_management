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
    <script>
        function yourFunction(){
            var action_src = "/search/" + document.getElementsByName("search")[0].value;
            var your_form = document.getElementById('search_form');
            your_form.action = action_src ;
        }
    </script>
</head>
<body>
<h1 style="position: relative; text-align: center; padding-top: 40px">Instance Management</h1>
<div class="container" style="padding-top: 50px;">
    <div class="row">
        <div class="col">
            <form id="search_form" method="post" onsubmit="yourFunction()" class="row g-3">
                <div class="col-auto">
                    <input type="text" class="form-control" id="search" name="search" placeholder="Search" required>
                </div>
                <div class="col-auto">
                    <button type="submit" class="btn btn-primary mb-3">Search</button>
                </div>
            </form>
        </div>
        <div class="col">
            <form action="/post" method="POST" class="row g-3">
                <div class="col-auto">
                    <input type="number" class="form-control" id="id" name="id" placeholder="Instance ID" required>
                </div>
                <div class="col-auto">
                    <input type="text" class="form-control" id="name" name="name" placeholder="Instance Name" required>
                </div>
                <div class="col-auto">
                    <button type="submit" class="btn btn-primary mb-3">Create</button>
                </div>
            </form>
        </div>
    </div>


    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Status</th>
            <th scope="col">Options</th>
            <th scope="col">User</th>
            <th scope="col">Time</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${data}" var="data" varStatus="status">
            <tr>
                <td>${data.name}</td>
                <td>
                    <c:choose>
                        <c:when test="${data.state}">
                            <form action="/put/${data.id}" method="get">
                            <button type="submit" class="btn btn-danger" style="width: 75px">In-Use</button>
                            </form>
                        </c:when>
                        <c:otherwise>
                        <form action="/put/${data.id}" method="get">
                            <button type="submit" class="btn btn-success" style="width: 75px">Free</button>
                        </form>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <a href="/getdetails/${data.id}" style="padding-right:20px;"><img src="/view-details.png" width="25" height="35"></a>
                    <a href="/del/${data.id}" ><img src="/delete.png" width="25" height="35"></a>
                </td>
<%--        </c:forEach>--%>
<%--        <c:forEach items="${detail}" var="data">--%>
                <td>${detail[status.index].user}</td>
                <td>${detail[status.index].time}</td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
