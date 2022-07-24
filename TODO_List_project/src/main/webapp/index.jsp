<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ page import="java.io.*,java.util.*,java.sql.*"%>  
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>  
    
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>To-Do List</title>

<style>
  
  table{
    table-layout: fixed;
    width: 300px;
}

td {
  text-align: center;
}

</style>

</head>
<body>

 <h1>To-do list</h1>
               
           <form action="Add_Task" method="post">
              <input type="text"  name="newTask" style="width: 300px;  height : 30px;  font-size:20px;">
              <button type="submit">Add Task</button>
          </form>
          
        
			<br>
			<br>
			<h3>Tasks: </h3><br>
		  <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/todo" user="Manjeet" password="HAha1100@"/>
           
           <sql:query var="res" dataSource="${db}">Select * from tasktable</sql:query> 
           
           <c:forEach items="${res.rows}" var="data">
           
           <table>
           
           <tr> 
           
           <td> <c:out value="${data.task}"> </c:out>   </td>
           <td>   <form action="deleteTask" method="post">
                    <input value="${data.id}" name="taskId"  type="hidden" >
                    <button type="submit">Delete Task</button> 
                 </form>
           </td>
           <td>   <form action="deleteTask" method="post">
                    <input value="${data.id}" name="taskId"  type="hidden" >
                    <button type="submit">Completed</button> 
                 </form>
           </td>
           
           </tr>
           
           </table>
           
          </c:forEach>       
		    
		    
       
</body>
</html>