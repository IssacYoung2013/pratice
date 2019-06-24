<%--
  Created by IntelliJ IDEA.
  User: Issac
  Date: 2019/6/23
  Time: 上午10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>item-list</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/itemList.do" method="post">
    查询条件：
    <table width="100%" border=1>
        <tr>
            <td><input type="submit" value="查询"/></td>
        </tr>
    </table>
    商品列表：
    <table width="100%" border=1>
        <tr>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品描述</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${itemList }" var="item" varStatus="status">
            <tr>
                <td><input type="text" name="itemList[${status.index }].name" value="${item.name }"/></td>
                <td>${item.price }</td>
                <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${item.detail }</td>

                <td><a href="${pageContext.request.contextPath }/itemEdit.do?id=${item.id}">修改</a></td>

            </tr>
        </c:forEach>

    </table>
</form>
</body>
</html>
