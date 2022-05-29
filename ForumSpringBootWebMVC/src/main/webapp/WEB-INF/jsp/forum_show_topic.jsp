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
    <title>Detail topic</title>
    
    <style>
.message{
    float: right;
}
.time{
    width: 100%;
    background-color: rgb(196, 187, 187);
}
.container{
    width: 70%;
    height: 500px;
    background-color: rgb(213 236 236);
    margin: auto;
    padding: 5%;
}
table {
    width: 100%;
    border-bottom: 1px solid #111010;
  }
.reply{
float: right;
}
.creator{
    text-align: center;
    width: 20%;
}
.subject{
    width: 100%;
    background-color: #69e3f5;
    text-align: left;
}
.time-join{
    font-size: small;
    font-weight: 100;
}
table {

    border-collapse: collapse;
  }
/* td, th {
border: 1px solid #111010;
text-align: left;
padding: 8px;
} */
  </style>
</head>
<body>
    <div class="container">
       <div class="message">
            Chao ${author.userName}|<a href="#">Thoat</a>
       </div>
       <br>
       <h3>Chu de: ${firsttopic.title}</h3>
         <a>Bai moi nhat<fmt:formatDate value="${firsttopic.createdTime.time}" type="date" pattern="dd/MM/yyyy HH:mm:ss" />, do <b>${author.userName}</b> gui.${listReply.size()}hoi am </a>
       <br><br>
       
       <div  class="time"><fmt:formatDate value="${firsttopic.createdTime.time}" type="date" pattern="dd/MM/yyyy HH:mm:ss" /></div>
       <table>
        <tr>
            <th rowspan="2" class="creator">
                ${firsttopic.getUser().userName}
                <br>
                <a class="time-join">Tham gia <fmt:formatDate value="${firsttopic.getUser().joinDate.time}" type="date" pattern="dd/MM/yyyy" /></a>
            </th>
            <th class="subject">${firsttopic.title}
                <a class="reply" href="newReply?top_id= ${firsttopic.id}">Tra loi</a>
            </th>
        </tr>
        <tr>
            <td>${firsttopic.content}
            </td>
        
        </tr>
        </table>
        <br><br>
       
       
        <c:forEach items="${listReply}" var="replymessage">
       <div  class="time"><fmt:formatDate value="${replymessage.createdTime.time}" type="date" pattern="dd/MM/yyyy HH:mm:ss" /></div>
       <table>
        <tr>
            <th rowspan="2" class="creator">
                ${replymessage.getUser().userName}
                <br>
                <a class="time-join">Tham gia <fmt:formatDate value="${replymessage.getUser().joinDate.time}" type="date" pattern="dd/MM/yyyy" /></a>
            </th>
            <th class="subject">${replymessage.title}
                <a class="reply" href="newReply?top_id= ${firsttopic.id}">Tra loi</a>
            </th>
        </tr>
        <tr>
            <td>${replymessage.content}
            </td>
        
        </tr>
        </table>
        <br><br>
         </c:forEach>
       
        
        <div class="message">
            <a href="topicList">Danh sach chu de</a>
        </div>
   </div>
</body>
</html>