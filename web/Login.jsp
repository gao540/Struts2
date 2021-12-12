<%--
  Created by IntelliJ IDEA.
  User: X-Man
  Date: 2021/11/17
  Time: 9:13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>登录页面</title>
    </head>
    <body>
        <center>
            <br><h2>登录账号</h2>
            <br><h4>请输入账号信息</h4>
            <form action="login.action" method="post">
                <table cellpadding="10">
                    <tr>
                        <td>账号:</td>
                        <td><input type="text" name="account"></td>
                    </tr>
                    <tr>
                        <td>密码:</td>
                        <td><input type="password" name="password"></td>
                    </tr>
                </table>
                <br><input type="submit" value="登录">
            </form>
        </center>
    </body>
</html>
