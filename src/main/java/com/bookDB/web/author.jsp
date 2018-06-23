<%@ page import="book.entity.Authors" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Authors</title>
    <style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>

<% final List<Authors> authors = (List<Authors>) request.getAttribute("authors"); %>

<h1>The List of Authors</h1>

<table class="tg">
    <% for (Authors a : authors) {%>
    <tr>
        <td><%= a.getId %>
        </td>
        <td><%= s.getFirstName() %>
        </td>
        <td><%= s.getLastName() %>
        </td>
    </tr>
    <% } %>
</table>

<h3>Add new Author</h3>
<form method="post">
    <label>
        First name:
        <input type="text" name="firstName"/>
    </label>
    <label>
        Last Name:
        <input type="text" name="lastName"/>
    </label>
    <input type="submit"/>
</form>

</body>
</html>
