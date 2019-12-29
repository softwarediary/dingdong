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

     <title>解锁奖励</title>

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
    <tr><td><c:out value="${reward.rcontent}"></c:out></td></tr>
     <tr><td><div class="textarea"><textarea cols="90" rows="13" readonly="readonly" ><c:out value="${reward.rpic}" ></c:out></textarea></div></td></tr>
     <tr><td colspan="3"><a href="dd/reward_showReward?user.uname=${user.uname}&user.uvalue=${user.uvalue}">返回</a></td></tr>
     </table>
     </main>
   </body>
 </html>