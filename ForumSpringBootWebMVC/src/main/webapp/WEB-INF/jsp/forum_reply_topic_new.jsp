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
    <title>New topic</title>
    
    <style>
    .message{
    float: right;
}
.container{
    width: 70%;
    height: 500px;
    background-color: rgb(213 236 236);
    margin: auto;
    padding: 5%;
}
.input-title{
    width: 70%;
}
.input-content{
    width: 70%;
}
  </style>
</head>
<body>
    <div class="container">
       <div class="message">
            Chao chuot con|<a href="#">Thoat</a>
       </div>
       <br>
        <form:form action="saveReplyMessage?top_id=${topic.id}" method="post" modelAttribute="replytopic">
        
       <h4><form:label path="title">*Tieu de:</form:label></h4>
       <form:input value="Re:" class="input-title" path="title"/>
       
       
       <h4><form:label path="content">*Noi dung:</form:label></h4>
       <form:textarea path = "content" rows = "5" cols = "72" />
       <br><br>
       <div class="group-button">
            <form:button>Gui</form:button>
            <button>Huy bo</button>
       </div>
       </form:form>
   </div>
</body>
</html>