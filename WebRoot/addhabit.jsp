<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 

 <%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>

 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 <html>
   <head>
     <base href="<%=basePath%>">
     <title>添加习惯</title>
 	<meta http-equiv="pragma" content="no-cache">
 	<meta http-equiv="cache-control" content="no-cache">
 	<meta http-equiv="expires" content="0">    
 	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
 	<meta http-equiv="description" content="This is my page">

 	<link rel="stylesheet" type="text/css" href="css/login.css">
 	<link rel="shortcut icon" href="<%=basePath%>images/dd.png">
 	
   </head>

   <body>
     <header>
        <div class="account">
          <c:choose>
 	       <c:when test="${user.uname ==null}">
 	         <a href="reg.jsp">注册</a>
 	         <a href="login.jsp">登录</a>
 	       </c:when>
 	       <c:otherwise>
 	         <c:out value="${user.uname}"></c:out>, 欢迎您!
 	        	您的积分：<c:out value="${user.uvalue}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;
 	         	<a href="login.jsp">退出登录</a>
 	       </c:otherwise>
 	     </c:choose>

        </div>
        <div class="logo"></div>		    
     </header>
     <main>
   <s:form action="dd/dd_addHabit" method="post" enctype="multipart/form-data">
   <table>
   <tr><td>习惯图标：</td><td><input type="file" name="habitPhoto"/></td></tr>
   	<tr><td class="left">习惯名称：</td><td><input type="text" name="habit.hname" ></td></tr>
   	<tr><td class="left">目标打卡次数：</td><td><input type="text" name="habit.totalNum" ></td></tr>
   	<tr><td>积分值 ：</td><td><input type="text" name="habit.hvalue" ></td></tr>
   	<tr><td>激励语 ：</td><td><input type="text" name="habit.htext" ></td></tr>
   	<tr><td><input type="hidden" name="user.uname" value="${user.uname }"></td></tr>

      <tr><td></<td><td><button type="submit" class="login-go">保存 </button></td><td> 
      <a href="dd/dd_showHabit?user.uname=${user.uname }&user.uvalue=${user.uvalue}">返回</a></td><tr>

      </table>
     </s:form>
     </main>
   </body>
 </html>