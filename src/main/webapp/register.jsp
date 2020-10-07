
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <%--    2 导入js编写发送请求的代码 --%>
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>

    <script type="text/javascript">
        $(function () {
            //页面加载成功
            //获取输入框
            $("#username").on("blur",function () {
                //获取输入的账号
                //alert($("#username").val())
                // 3 发送请求
                $.ajax({
                    url:"queryUsername",
                    async:true,
                    data:"username="+$("#username").val(),
                    type:"post",
                    dataType:"json",
                    success:function (data) {
                        //{"msg":"恭喜，该邮件地址可以注册","code":0}
                      // alert(data.code)
                       //alert(data.msg)
                        //5：根据服务端返回的json数据，编写显示逻辑
                        if(data.code == 0){
                            $("#msg").text(data.msg)

                            $("#msg").css("color","green")
                        }else{
                            $("#msg").text(data.msg)

                            $("#msg").css("color","red")
                        }
                    },
                    error:function () {
                        alert("服务器发生了错误")
                    }
                });
            })
        })
    </script>
</head>
<body>
        <!-- 1 显示表单 -->
        <form method="post" action="${pageContext.request.contextPath}/register">
           username: <input id="username" name="username" type="text"><br/>
            <div  id="msg" style="color: green;"></div>

           password: <input name="passowrd" type="password"><br/>
           <input  type="submit" value="注册"><br/>
        </form>
</body>
</html>
