<%-- 
    Document   : customerinfo
    Created on : Dec 11, 2020, 4:27:30 PM
    Author     : anna
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success!</title>
    </head>
    <body>
        <h1>Successfully signed up</h1>
        <h2>Your personal data:</h2>
        <p><strong>Name: </strong> ${name}</p>
        <p><strong>Surname: </strong> ${surname}</p>
        <p><strong>Phone: </strong> ${phone}</p>

    </body>
</html>
