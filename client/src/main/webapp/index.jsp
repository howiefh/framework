<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<body>
<shiro:guest>
    欢迎游客访问，<a href="${pageContext.request.contextPath}/login">点击登录</a><br/>
</shiro:guest>
<shiro:user>
    欢迎[<shiro:principal/>]登录 <br/> <a href="${pageContext.request.contextPath}/logout">点击登出</a><br/>
</shiro:user>
<shiro:hasRole name="admin">
    您有角色admin
</shiro:hasRole>
</body>
</html>
