<%-- 
    Document   : index
    Created on : Dec 11, 2020, 2:19:52 PM
    Author     : anna
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Intro JSP Page for customer</title>       
    </head>
    <body>
        <h1>Registration Page</h1> 
        <c:if test="${violations != null}">
            <c:forEach items="${violations}" var="violation">
                <p>${violation}.</p>
            </c:forEach>
        </c:if>
        <form action="${pageContext.request.contextPath}/processAttendee" method="post">
            <ol type="1">
                <li><label for="name"> First Name : </label>
                    <input type="text" name="name" id="name" value="${name}"></li>
                <li><label for="surname"> Second Name : </label>
                    <input type="text" name="surname" id="surname" value="${surname}"></li>
                <li><label for="phone">Phone: </label>
                    <input type="text" name="phone" id="phone" value="${phone}"></li>

                <input type="submit" value="Sign Up" name="Submit" />
            </ol> 
        </form>          
    </body>
</html>

