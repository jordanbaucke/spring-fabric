<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h1>Hello <security:authentication property="principal.username" />!</h1>

<p>
	Enter new method name: <input type="text" placeholder="Enter a new method name..."/>
</p>