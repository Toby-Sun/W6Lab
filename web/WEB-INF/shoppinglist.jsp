<%-- 
    Document   : shoppingList
    Created on : Oct 16, 2022, 7:51:42 PM
    Author     : tobys
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello ${username}</p>
        <p><a href="ShoppingList?action=logout">Logout</a></p>

        <form action="ShoppingList" method="POST">
            <h2>ADD ITEM</h2>
            <input type="text" name="item" value="${item}"><input type="submit" value="ADD ITEM">
            <input type="hidden" name="action" value="add">
        </form>
        <form method="POST" action="ShoppingList">
            <ul>
                <c:forEach var="item" items="${items}">
                    <li><input type="radio" name="delete" value="${item}">${item}</li>
                </c:forEach>
            </ul>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>
