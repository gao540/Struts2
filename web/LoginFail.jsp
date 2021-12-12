<%--
  Created by IntelliJ IDEA.
  User: X-Man
  Date: 2021/11/17
  Time: 9:13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>登录失败</title>
    </head>
    <body>
        <center>
            <br><h2>登录失败</h2><br>
            <%
                String str=(String) request.getAttribute("LoginState");
                out.print(str+"<br><br>");
            %>
            <table cellpadding="10">
                <tr>
                    <td><a href="index.jsp">返回主页面</a> </td>
                    <td><a href="Login.jsp">重新登录</a> </td>
                </tr>
            </table>
        </center>
    </body>
</html>
