<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html lang="vn">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
    
    <style>
.container{
    width: 500px;
    height: 200px;
    background-color: rgb(210, 216, 216);
    margin: auto;
    border: 1px solid #020202;
}
.header{
    text-align: center;
    font-size: 20px;
    width: 100%;
    height: 27px;
    background-color: rgb(93, 235, 235);
}
table {
    border-collapse: collapse;
    width: 100%;
  }
  .title{
      text-align: right;
    width: 30%;
  }
  td, th {
    text-align: left;
    padding: 8px;
  }
  </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <b>Login</b>
        </div>
         <form:form action="saveuser" method="post" modelAttribute="user">
        <table>
                <tr>
                <td class="title">
                   <form:label path="userName">*User name:</form:label>
                </td>
                <td> <form:input path="userName"/></td>
                </tr>
                <tr>
                <tr>
                    <td class="title">
                        <form:label path="password">*password:</form:label>
                    </td>
                    <td> <form:input path="password"/></td>
                    </tr>
                    <tr>
                <tr>
                    <td>
                       
                    </td>
                    <td><td><form:button>Login</form:button></td></td>
                    </tr>
                    <tr>
		</table>
		</form:form>
   </div>
</body>
</html>