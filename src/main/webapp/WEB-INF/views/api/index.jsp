<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h1>Hello <security:authentication property="principal.username" />!</h1>

<p>
<form method="POST">
Enter new method name: <input type="text" id="title" name="title" placeholder="Enter a new method name..."/><input type="submit" value="Submit" />
</form>
</p>
<p>
<c:out value="${name}" />
<c:forEach items="${methods}" var="method">
        <c:out value="${method.id}" />. <c:out value="${method.title}" />
</c:forEach>
</p>