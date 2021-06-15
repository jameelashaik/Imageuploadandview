<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'viewtab.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  </head>
  <body>
   <div class="Container-fluid">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="background-color:white;color:black; width:100%"><h3 style="text-align:center;">Employee Details</h3>
            <h3><a href="/imageupload/uploadform">AddImage</a></h3>
            <table class="table  table-bordered table-condensed table-hover">
        
            <thead style="background-color:skyblue">
        
                <th>No</th>
                <th>Image</th>
                </thead>
                <tbody style="background-color:babypink">
                <c:forEach var="emp" items="${viewlist}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td><img src="../imageupload/images/${emp.photo}" width="100" height="100" alt=""/></td>         
                </tr>
                </c:forEach> 
                </tbody>            
            </table>
            </div>
        </div>
  </body>
</html>
