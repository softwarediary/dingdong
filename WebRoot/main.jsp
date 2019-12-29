<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <%@ taglib uri="/struts-tags" prefix="s" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
   request.setCharacterEncoding("UTF-8");
   response.setCharacterEncoding("UTF-8");

 %>

 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 <html> 
 	<head>
     	<base href="<%=basePath%>">

     	<title>叮咚</title>

 		<meta http-equiv="pragma" content="no-cache">
 		<meta http-equiv="cache-control" content="no-cache">
 		<meta http-equiv="expires" content="0">    
 		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
 		<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/login.css">
	<link rel="shortcut icon" href="<%=basePath%>images/dd.png">
  	</head>
 <body>
 <header>
        <div class="account">
          <c:choose>
 	       <c:when test="${user.uname ==null}">
 	         <a href="reg.jsp" >注册</a>
 	         <a href="login.jsp" class="accounta">登录</a>
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
   		<s:form action="dd/dd_selectHabit" method="post" >
 	      
 	      		<tr><td><a href="dd/reward_showReward?user.uname=${user.uname }&user.uvalue=${user.uvalue}">解锁生活奥秘</a></td>
 			    <td><a href="dd/dd_showAdd?user.uname=${user.uname}&user.uvalue=${user.uvalue}">添加习惯</a></td>
 			    <td><a href="dd/dd_showHabit?user.uname=${user.uname }&user.uvalue=${user.uvalue}">显示全部习惯 </a></td></tr>
 			    <tr><td><input type="hidden" name="user.uname" value="${user.uname }"></td></tr>
 			    <tr><td><input type="hidden" name="user.uvalue" value="${user.uvalue }"></td></tr>
 	      		<button type="submit" class="search-go" value="查询">查询</button>
 	      		<input class="search" type="text" name="hname" placeholder="请输入关键词">
 	      

   			<table>
 				<tr>
 				<th>序号</th>
   				<th >习惯名称</th>
   				<th >激励语</th>
   				<th >打卡次数</th>
    				<th>打卡可得积分</th>
    				<th></th>
    				<!-- <th><s:a href="index.jsp">添加习惯</s:a></th> -->
   				</tr>

   				<c:forEach var="habit" items="${habitList}" varStatus="status">
   					<tr>
   					<td><c:out value="${status.index + 1}"></c:out></td>
   					<td><a href="dd/dd_showDetail?habit.hid=${habit.hid}&user.uname=${user.uname}&user.uvalue=${user.uvalue}"><c:out value="${habit.hname} "></c:out></a></td>
   					<td><c:out value="${habit.htext}"></c:out></td>
   					<td><c:out value="${habit.finishedNum}" ></c:out></td>
   					<td><c:out value="${habit.hvalue}" ></c:out></td>

 					<td><a href="dd/dd_daka?habit.hid=${habit.hid}&user.uname=${user.uname}" title="打卡"><i class="fa fa-calendar"></i></a></td>
 					<td> &nbsp;&nbsp;<a href="dd/dd_showEdit?habit.hid=${habit.hid}&user.uname=${user.uname}&user.uvalue=${user.uvalue}" title="编辑"><i class="fa fa-pencil"></i></a></td>

   					<td> &nbsp;&nbsp;<a href="dd/dd_deleteHabit?habit.hid=${habit.hid}" title="删除"><i class="fa fa-trash"></i></a></td>


   					</tr>

   				</c:forEach>

   			</table>
   		</s:form>

 	</main>
  </body>
 </html>