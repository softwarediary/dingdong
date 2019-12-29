<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ taglib uri="/struts-tags" prefix="s"%>
 <%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>

 <!DOCTYPE html>
 <html>
   <head>
     <base href="<%=basePath%>">

     <title>登录页面</title>
     <meta charset="utf-8">
 	<meta http-equiv="pragma" content="no-cache">
 	<meta http-equiv="cache-control" content="no-cache">
 	<meta http-equiv="expires" content="0">    
 	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
 	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="<%=basePath%>images/dd.png">
 	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/login.css">

   </head>

   <body>
   <header>
        <div class="account">
       <a href="reg.jsp">注册</a>
       </div>
        <div class="logo"></div>

     </header>
     <main>
     <s:form action="dd/user_login" method="post">
     <table>
     <tr></tr>
     <tr></tr>
     <tr></tr>
     <tr></tr>
     <tr>
          <td>用户名：<input type="text" name="user.uname" placeholder="请输入用户名"> </td>       
     </tr>
     <tr>
         <td>密 &nbsp;&nbsp;码：<input type="password" name="user.passwd" placeholder="请输入密码"></td>
       </tr>
       <tr>
 	     <td><button type="submit" class="login-go">登 录 </button></td>
 	      </tr>
 	      </table>
 	    </s:form>

    </main>
   </body>
 </html>