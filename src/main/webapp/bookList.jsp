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
<% LinkedList<Book> bookList = (LinkedList<Book>) request.getAttribute("bookList"); %>
<% int totalCount = (int) request.getAttribute("totalCount"); %>
<% int bookPage = (int) request.getAttribute("bookPage"); %>

<% int limit = (int) request.getAttribute("limit"); %>
<% int totalPage =  (int) Math.ceil((double) totalCount / limit); %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
    <script src="${pageContext.request.contextPath}/js/bookList.js"></script>
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
    <input type="hidden" id="hidPage" value="<%= bookPage %>"/>
    <input type="hidden" id="hidTotalPage" value="<%= totalPage %>"/>

    <form class="form-inline" action="/bookList">
        <input type="hidden" name="limit" value="<%= limit %>"/>

        <div class="search" style="margin-top: 10px; margin-bottom: 10px;">
            <div>
                <div class="form-group">
                    <div class="input-group">
                        <input type="text" name="search" class="form-control" id="exampleInputAmount" placeholder="검색">
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">검색</button>
            </div>
            <div>
            </div>
        </div>
    </form>
    <div class="table-responsive">
        <span>총 :  <%= totalCount %> </span>
        <% if (bookList.size() > 0) {%>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>#</th>
                <th>카테고리1</th>
                <th>카테고리2</th>
                <th>책이름</th>
                <th>저자</th>
                <th>수량</th>
            </tr>
            </thead>
            <tbody>
            <%
                int index = totalCount - (bookPage - 1) * limit;
                for (Book book : bookList) {
            %>
            <tr>
                <th scope="row"><%= index %>
                </th>
                <td><%= book.getCategory1Name() %>
                </td>
                <td><%= book.getCategory2Name() %>
                </td>
                <td><%= book.getBookName() %>
                </td>
                <td><%= book.getAuthor() %>
                </td>
                <td><%= book.getQty() %>
                </td>
            </tr>
            <% index--;
            }%>
            </tbody>
        </table>
        <nav>
            <ul class="pagination">

            </ul>
        </nav>
        <% } else { %>
        <div>
            <span>검색 결과가 없습니다.</span>
        </div>
        <% } %>
    </div>
</div>
</body>
</html>