<%--
  Created by IntelliJ IDEA.
  User: Issac
  Date: 2019/7/10
  Time: 上午8:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript">
   // 创建EventSource对象，指定事件源为see/custom请求
   var es = new EventSource("sse/custom");
   // 当接受到服务端发送来的事件时触发该方法执行
   es.addEventListener("issac",function (evt) {
       console.log("issac-msg",evt.data);
       if(evt.data == 9) {
           es.close();
       }
   })

</script>
</body>
</html>
