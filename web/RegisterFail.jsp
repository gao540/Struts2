<%--
  Created by IntelliJ IDEA.
  User: X-Man
  Date: 2021/11/17
  Time: 9:14
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>注册失败</title>
    </head>
    <body>
        <center>
            <br><h2>注册失败</h2><br>
            <%
                String str=(String) request.getAttribute("RegisterState");
                out.print(str+"<br><br>");
            %>
            <table cellpadding="10">
                <tr>
                    <td><a href="index.jsp">返回主页面</a> </td>
                    <td><a href="Register.jsp">重新注册</a> </td>
                </tr>
            </table>
        </center>
    </body>
</html>
