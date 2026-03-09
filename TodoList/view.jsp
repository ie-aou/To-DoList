<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List,java.util.ArrayList" %>
<%@ page import="model.Task" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>view</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="main">
        <h1>✨ タスク一覧 ✨</h1>
            <div class="list">
                <c:if test="${list.size() != 0}">
                    <form method="post" action="deleteServlet">
                        <% int i = 0; %>
                        <c:forEach var="li" items="${list}">
                            <div class="li">
                                <input type="checkbox" name="delete" value="<%= i++ %>">
                                <c:choose>
                                    <c:when test='${li.priority == "高"}'>
                                        <span  style="color: blue;">[<c:out value="${li.priority}"/>]</span>
                                    </c:when>
                                    <c:when test='${li.priority == "中"}'>
                                        <span  style="color: darkblue;">[<c:out value="${li.priority}"/>]</span>
                                    </c:when>
                                        <c:otherwise>[<c:out value="${li.priority}"/>]</c:otherwise>
                                </c:choose>
                                <span class="title">${li.title}<br></span>  
                                <span class="detail">${li.detail}<br><br><br></span>
                            </div>   
                        </c:forEach>
                        <button type="submit">けす</button>
                    </form>                     
                </c:if>
                <c:if test="${list.size() != 0}">
                    <form method="post" action="deleteServlet">                        
                        <button type="submit" name="delete" value="all">ぜんぶけす</button><br>
                    </form>
                </c:if>   
            </div>   
    <div style="text-align: center;">
        <c:if test="${list.size() == 0}">タスクはありません</c:if><br><br></div>
    </div>
    <div class="main">
        <a href="create.html">タスクをつくる</a>
        <a href="index.html">トップに戻る</a>
    </div>    
</body>
</html>