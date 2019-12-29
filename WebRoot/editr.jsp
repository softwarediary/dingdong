<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>

 <%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>

 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 <html>
   <head>
     <base href="<%=basePath%>">

     <title>编辑奖励</title>
 	<meta http-equiv="pragma" content="no-cache">
 	<meta http-equiv="cache-control" content="no-cache">
 	<meta http-equiv="expires" content="0">    
 	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
 	<meta http-equiv="description" content="This is my page">

 	<link rel="stylesheet" type="text/css" href="css/main.css">
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
 	         <c:out value="${user.uname}"></c:out>, 欢迎您!&nbsp;&nbsp;&nbsp;&nbsp;
 	         	<a href="login.jsp">退出登录</a>
 	       </c:otherwise>
 	     </c:choose>

        </div>
        <div class="logo"></div>		    
     </header>
  <main>
   <s:form action="dd/reward_editReward" method="post">
   <table>
   	<s:hidden name="reward.rid"></s:hidden> 
      <s:textfield name="reward.rcontent" label="奖励名称"></s:textfield>
      <s:textfield name="reward.rvalue" label="奖励积分"></s:textfield>  
      <tr>
      <td colspan="2"><button type="submit" class="login-go">保存 </button></td>
      <td colspan="3"><s:a href="dd/reward_showReward">返回</s:a></td>
      </tr>
      </table>
     </s:form>
  </main>
   </body>
 </html>