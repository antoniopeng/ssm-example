<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="/ssm_example_war_exploded/static/css/login.css"/>
    <title>欢迎登录</title>
</head>

<body>
<div class="box">
    <h1>欢迎登录</h1>

    <form action="/ssm_example_war_exploded/login" method="post">
        <div ${message == null ? "style='display:none;'" : ""}>
            <button type="button">&times;</button>
            ${message}
        </div>
        <br />
        <div>
            <input name="username" placeholder="用户名" value="${username}">
        </div>
        <br />
        <div>
            <input name="password" type="password" placeholder="密码" value="${password}">
        </div>
        <br />
        <div>
            <button type="submit">登录</button>
        </div>
    </form>
</div>
</body>
</html>
