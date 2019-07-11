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
   // 创建EventSource对象，指定事件源为see/default请求
   var es = new EventSource("sse/default");
   // 当接受到服务端发送来的事件时触发该方法执行
   es.onmessage = function (evt) {
       // 参数一：日志名称，随意
       // 参数二：事件中携带的数据
       // 参数三：事件本身
       console.log("see-msg",evt.data,evt);
       if(evt.data == 9) {
           es.close();
       }
   }

</script>
</body>
</html>
