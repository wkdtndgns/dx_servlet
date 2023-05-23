<%--
  Created by IntelliJ IDEA.
  User: wkdtn
  Date: 2023-05-23
  Time: 오후 2:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="Dao.Book.*" %>
<%@ page import="java.util.HashMap" %>
<% HashMap<String, Integer> map = (HashMap<String, Integer>) request.getAttribute("map"); %>

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
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="/bookList">도서 검색</a></li>
                    <li><a href="#contact">도서 대출</a></li>
                    <li><a href="#contact">도서 리뷰</a></li>
                    <li><a href="#contact">도서 판매</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </nav>
</div>
<div class="container" style="margin-top: 83px;">

    <div class="bs-example col-sm-4" style="margin-top: 10px;" data-example-id="simple-table">
        <table class="table">
            <thead>
            <tr>
                <th>#</th>
                <th>책이름</th>
                <th>평점</th>
            </tr>
            </thead>
            <!-- Inside the table's <tbody> tag -->
            <tbody>
            <% int index = 1;
                for (String name : map.keySet()) { %>
            <tr>
                <th scope="row"><%= index++ %></th>
                <td><%= name %></td>
                <td><%= map.get(name) %></td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
    <div><a href='index.html'> 돌아가기 </a></div>
</div>
</body>
</html>