<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <%@ taglib uri="/struts-tags" prefix="s" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>

 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 <html>
   <head>
     <base href="<%=basePath%>">

     <title>习惯详情</title>

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
   <table>
 	<tr><td>习惯图标:</td><td><img src="<%=basePath%><s:property value='habit.pic'/>" alt="" width="200px" height="150px"/></td></tr>
    <tr><td>习惯名称:</td><td><c:out value="${habit.hname}"></c:out></td></tr>
     <tr><td>打卡次数:</td><td><c:out value="${habit.finishedNum}" ></c:out></td></tr>
     <tr><td>目标次数:</td><td><c:out value="${habit.totalNum}" ></c:out></td></tr>
     <tr><td>积分值:</td><td><c:out value="${habit.hvalue}"></c:out></td></tr>
     <tr><td>激励语:</td><td><c:out value="${habit.htext}"></c:out></td></tr>
     <tr><td></td><td></td><td colspan="3"><a href="dd/dd_showHabit?user.uname=${user.uname }&user.uvalue=${user.uvalue}">返回</a></td></tr>
     </table>
     </main>
   </body>
 </html>