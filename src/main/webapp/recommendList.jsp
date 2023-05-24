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
<%@ page import="Controller.Recommned.BookRecommend" %>
<%-- userList 변수 선언 --%>
<% LinkedList<BookRecommend> recommendList = (LinkedList<BookRecommend>) request.getAttribute("list"); %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
    <meta charset="utf-8">
    <title> 리스트 </title>
</head>


<body>

<div id="divNav">
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">도서관리</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav" id="menu">

                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </nav>
</div>

<div class="container" style="margin-top: 83px;">
    <div class="table-responsive">
        <table class="table">
            <thead>
            <tr>
                <th>#</th>
                <th>책이름</th>
                <th>키워드</th>
            </tr>
            </thead>
            <!-- Inside the table's <tbody> tag -->
            <tbody>
            <%
                int index = 1;
                for (BookRecommend bookRecommend : recommendList) {
            %>
            <tr>
                <th scope="row"><%= index++ %>
                </th>
                <td><%= bookRecommend.getBookName() %>
                </td>
                <td><%= bookRecommend.getKeyMap() %>
                </td>
            </tr>
            <% }%>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>