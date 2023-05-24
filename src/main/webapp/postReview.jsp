
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String book_name = request.getParameter("book_name");%>
<%String idParam = request.getParameter("id");%>

<!DOCTYPE html>
<html>

<body>
<form action="postReview?id=<%= idParam%>" method="post">
    <input type="hidden" name="id" value="<%= idParam%>">
    <label for="user_name">User Name:</label>
    <input type="text" id="user_name" name="user_name" required>
    <br>
<%--    <label for="book_name">Book Name:</label>--%>
<%--    <input type="text" id="book_name" name="book_name" value="<%= book_name%>"required>--%>
<%--    <br>--%>
    <label for="rate">Rate:</label>
    <input type="number" id="rate" name="rate" min="1" max="5" required>
    <br>
    <input type="submit" value="Submit">
</form>

</div>
<div><a href='bookList.jsp'> 돌아가기 </a></div>
</body>
</html>