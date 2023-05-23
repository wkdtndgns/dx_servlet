<%--
  Created by IntelliJ IDEA.
  User: wkdtn
  Date: 2023-05-21
  Time: 오후 10:33
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="com.example.servlet.User" %>
<%-- userList 변수 선언 --%>
<% LinkedList<User> userList = (LinkedList<User>) request.getAttribute("userList"); %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <meta charset="utf-8">
    <title> 리스트 </title>
</head>
<body>

<div class="bs-example col-sm-4" style="margin-top: 10px;" data-example-id="simple-table">
    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>id</th>
            <th>삭제</th>
        </tr>
        </thead>
        <tbody>
        <%
            int index = 1;
            for (User user : userList) {
        %>
        <tr>
            <th scope="row"><%= index++ %>
            </th>
            <td><%= user.getName() %></td>
            <td><a href='deletes?id=<%=user.getName()%>'>삭제</a></td>

        </tr>
        <% }%>
        </tbody>
    </table>
</div>
<div><a href='index.html'> 돌아가기 </a></div>
</body>
</html>