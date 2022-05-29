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
    <title>List topic</title>
    
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
table {
  border-collapse: collapse;
  border: 1px solid #020202;
  width: 100%;
}
.subject{
    text-align: center;
    background-color: #b6b3b9;
}
td, th {
  text-align: left;
  padding: 8px;
}
.n-reply{
    text-align: center;
}
tr:nth-child(even) {
    background-color: #98dcdf;
  }
  </style>
</head>
<body>
    <div class="container">
       <div class="message">
            Chao chuot con|<a href="#">Thoat</a>
       </div>
       <br>
       <h3>Dien dan: chuyen hoc phi va cac chinh sach ho tro hoc tap</h3>
       <button onclick="window.location='newTopic'">Gui bai moi</button>
    <br><br>
     
    <table>
        <tr>
        <th class="subject">Chu de</th>
        <th class="subject">Hoi am</th>
        </tr>
        <c:forEach items="${listTopic}" var="topic">
        <tr>
        <td>
            <a href="detailTopic?top_id=${topic.id}">${topic.title}</a>
            <br>
            Bai viet moi nhat by <a href="#">${topic.getUser().getUserName()}</a>, <fmt:formatDate value="${topic.createdTime.time}" type="date" pattern="dd/MM/yyyy HH:mm:ss" />
        </td>
        <td class="n-reply">${topic.getMessagestopic().size()}</td>
        </tr>
        </c:forEach>
    </table>
    
   </div>
</body>
</html>