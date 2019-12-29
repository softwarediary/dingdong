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
    
    <title>奖励</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/login.css">
	<link rel="shortcut icon" href="<%=basePath%>images/dd.png">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <header>
        <div class="account">
          <c:choose>
 	       <c:when test="${user.uname ==null}">
 	         <a href="reg.jsp">注册</a>
 	         <a href="login.jsp">登录</a>
 	       </c:when>
 	       <c:otherwise>
 	         <c:out value="${user.uname}"></c:out>, 欢迎您!
 	          您的积分： <c:out value="${user.uvalue}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;
 	         	<a href="login.jsp">退出登录</a>
 	         
 	       </c:otherwise>
 	     </c:choose>
        </div>
        <div class="logo"></div>		    	    
  </header> 
  <body>
    <main>
     <s:form action="dd/reward_selectReward"  method="post">
     <div>
 	      		<tr><td><a href="dd/dd_showHabit?user.uname=${user.uname}&user.uvalue=${user.uvalue}">返回习惯列表 </a></td>
 			    <td><a href="dd/reward_showReward?user.uname=${user.uname }&user.uvalue=${user.uvalue}">显示全部 </a></td></tr>
 	      		<button type="submit" class="search-go" value="查询">查询</button>
 	      		<input class="search" type="text" name="rname" placeholder="请输入关键词">

 	      	</div>
   			<table >
   				<tr></tr>
      			<tr></tr>
      			<tr></tr>
      			<tr>
      				<th>序号</th>
      				<th>标题</th>
    				<th>所值积分</th>
    				<th>解锁/查看</th>
    				<th></th>
      			</tr>
      			<c:forEach var="reward" items="${rewardList}" varStatus="status">
      			<tr>
      				<th><c:out value="${status.index + 1}"></c:out></th>
  					<td><c:out value="${reward.rcontent}"></c:out></td>
  					<td><c:out value="${reward.rvalue}"></c:out></td>
  					<td><a href="dd/reward_getRe?reward.rid=${reward.rid}&user.uname=${user.uname}">解锁/查看</a></td>

  				</tr>
  				<tr></tr>
  				
  			</c:forEach>
  		</table>
  	</s:form>
  	</main>
  </body>
</html>
