<%--
  Created by IntelliJ IDEA.
  User: logan
  Date: 2018/10/6
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>跳转中</title>
</head>
<body>

<%	String errorInfo = (String)request.getAttribute("logininfo");
    if(errorInfo.equals("fail")) {%>
<script type="text/javascript" language="javascript">
    alert("用户名或密码错误");
    window.location='login.jsp' ;
</script>
<%	}else{%>
<script type="text/javascript" language="javascript">
    alert("登陆成功");
    window.location='index.jsp' ;
</script>
<%}%>
</body>
</html>
