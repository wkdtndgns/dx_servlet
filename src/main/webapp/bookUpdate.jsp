<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Dao.Book.*" %>
<%@ page import="java.math.BigDecimal" %>
<%
    String bookName = (String) request.getAttribute("book_name");
    String summary = (String) request.getAttribute("summary");
    String author = (String) request.getAttribute("author");
    String publisher = (String) request.getAttribute("publisher");
    BigDecimal purchasePrice = (BigDecimal) request.getAttribute("purchase_price");
    BigDecimal sellingPrice = (BigDecimal) request.getAttribute("selling_price");
    int qty = (int) request.getAttribute("qty");
    int pages = (int) request.getAttribute("page");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="/js/main.js"></script>
    <meta charset="utf-8">
    <style>
        #frmRegister div {
            margin: 10px;
        }
    </style>
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

    <h1>도서 수정</h1>
    <form id="frmRegister" action="/bookUpdate" method="post">
        <div>
            <label class="control-label" >카테고리 1:</label>

            <select id="category1Select"  class="form-control" name="category1" required>
                <option value="">카테고리 선택</option>
                <option value="10">소설</option>
                <option value="20">역사</option>
                <option value="30">자기개발</option>
                <option value="40">종교</option>
            </select>

        </div>
        <div>
            <label class="control-label" >카테고리 2:</label>

            <select id="categorySelect"  class="form-control" name="category2" required>
                <option value="">카테고리 선택</option>
                <option value="11">한국소설</option>
                <option value="12">서양소설</option>
                <option value="21">한국역사</option>
                <option value="22">세계역사</option>
                <option value="31">개발</option>
                <option value="32">자신감개발</option>
                <option value="41">한국종교</option>
                <option value="42">서양종교</option>
            </select>
        </div>
        <div>
            <label class="control-label" for="bookName">도서명:</label>
            <input type="text" class="form-control" id="bookName" name="book_name" value="<%= bookName %>" required>
        </div>

        <div>
            <label class="control-label" for="summary">요약:</label>
            <textarea id="summary" class="form-control" name="summary" required><%= summary %></textarea>
        </div>
        <div>
            <label class="control-label" for="author">작가:</label>
            <input type="text" class="form-control" id="author" name="author" value="<%= author %>" required>
        </div>
        <div>
            <label class="control-label" for="publisher">출판사:</label>
            <input type="text" class="form-control"  id="publisher" name="publisher" value="<%= publisher %>" required>
        </div>
        <div>
            <label class="control-label" for="purchasePrice">구매 가격:</label>
            <input type="number" class="form-control" id="purchasePrice" name="purchasePrice" value="<%= purchasePrice %>" step="0.01" required>
        </div>
        <div>
            <label class="control-label" for="sellingPrice">판매 가격:</label>
            <input type="number" class="form-control" id="sellingPrice" name="sellingPrice" value="<%= sellingPrice %>" step="0.01" required>
        </div>
        <div>
            <label class="control-label" for="qty">수량:</label>
            <input type="number"  class="form-control" id="qty" name="qty" value="<%= qty %>" required>
        </div>

        <div>
            <label class="control-label" for="page">페이지:</label>
            <input type="number" class="form-control" id="page" name="page" value="<%= pages %>" >
        </div>

        <div>
            <input type="submit" class="btn btn-primary" value="수정" />
        </div>
    </form>
</div>
</body>
</html>

