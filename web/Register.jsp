<%--
  Created by IntelliJ IDEA.
  User: X-Man
  Date: 2021/11/17
  Time: 9:14
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>注册界面</title>
    </head>
    <body>
        <center>
            <br><h2>注册账号</h2><br>
            <br><h4>请输入注册信息</h4>
            <form action="Register.action" method="post">
                <table cellpadding="10">
                    <tr>
                        <td>注册账号:</td>
                        <td><input type="text" name="account"></td>
                    </tr>
                    <tr>
                        <td>注册密码:</td>
                        <td><input type="password" name="password"></td>
                    </tr>
                    <tr>
                        <td>确认密码:</td>
                        <td><input type="password" name="confirm"></td>
                    </tr>
                    <tr>
                        <td>注册姓名:</td>
                        <td><input type="text" name="username"></td>
                    </tr>
                </table>
                <br><input type="submit" value="注册">
            </form>
        </center>
    </body>
</html>
