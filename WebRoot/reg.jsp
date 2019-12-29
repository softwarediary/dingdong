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

     <title>注册页面</title>
     <meta charset="utf-8">
 	<meta http-equiv="pragma" content="no-cache">
 	<meta http-equiv="cache-control" content="no-cache">
 	<meta http-equiv="expires" content="0">    
 	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
 	<meta http-equiv="description" content="This is my page">
 	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/login.css">
 	<link rel="shortcut icon" href="<%=basePath%>images/dd.png">

   </head>

   <body>

     <header>
        <div class="account">
       <a href="login.jsp">登录</a>
       </div>
        <div class="logo"></div>

     </header>
     <main> 
 	    <s:form action="dd/user_reg" method="post">
 	    <table>

 	        <tr><td>用户名：<input type="text" name="user.uname" placeholder="请输入用户名"></td></tr>
      		<tr><td>密 &nbsp;&nbsp;码：<input type="text" name="user.passwd" placeholder="请输入密码"></td></tr>
      		<tr><td>手机号：<input type="text" name="user.tele" placeholder="请输入手机号"></td></tr>
      		<tr><td><button type="submit" class="login-go">注册 </button></td></tr>

      		</table>
 	    </s:form>
 	  </main>  
   </body>
 </html>