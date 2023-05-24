
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String book_name = request.getParameter("book_name");%>
<%String idParam = request.getParameter("id");%>

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
    <form  method="post" action="postReview" >
        <input type="hidden" name="id" value="<%= idParam%>">
        <div class="form-group">
            <label for="user_name">사용자 명: </label>
            <input type="text" class="form-control" id="user_name" name="user_name" placeholder="사용자명을 입력하세요" required>
        </div>
        <div class="form-group">
            <label for="rate">Rate:</label>
            <input type="number"  class="form-control" id="rate" name="rate" min="1" max="5" required>

        </div>
        <button type="submit" class="btn btn-default" id="btnRent">등록</button>
    </form>
</div><!-- /.container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>