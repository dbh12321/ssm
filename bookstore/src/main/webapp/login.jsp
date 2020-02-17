<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


    <title>bookStore列表</title>
    <%--导入css --%>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" type="text/css"/>
    <!--导入jquery-->
    <script src="js/jquery-3.3.1.js"></script>
    <script>
      $(function () {
        //绑定用户名、密码离焦事件
          $("#username").blur(checkname);
          $("#password").blur(checkPassword);
          //绑定提交验证
          $("#login").submit(checkPassword&&checkname);
      })

        function checkname() {
            //获取用户名

            var name = $("#username").val();
            if (name == null || name == ""){
                //用户名为空
                //边框变红
                $("#username").css("border" , "1px solid red");
                return false;
            } else {
                $("#username").css("border" , "1px solid ");
                return true;
            }
        }

      function checkPassword() {
          //获取用户名
          var pwd = $("#password").val();
          if (pwd == null || pwd == ""){
              //用户名为空
              //边框变红
              $("#password").css("border" , "1px  solid  red");
              return false;
          } else {
              $("#password").css("border" , "1px solid");
              return true;
          }
      }

        
        
    </script>

</head>

<body class="main">

<jsp:include page="head.jsp"/>
<jsp:include page="menu_search.jsp"/>

<div id="divpagecontent">
    <div width="100%" border="0" cellspacing="0">
        <div>

            <div>
                <div style="text-align:right; margin:5px 10px 5px 0px">
                    <a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;计算机&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;图书列表
                </div>

            </div>
        </div>
        <div >
        <table border="1px"  width="50%">

            <form action="${pageContext.request.contextPath}/loginServlet" id="login" method="post" >
                <tr align="center" style="background-color: #5CA5D6" >
                    <td style="border-color: #5CA5D6"><label style="font-weight:bold;" >用户名:</label></td>
                    <td><input type="text" name="username" id="username"><br></td>
                </tr>
                <tr align="center"style="background-color: #5CA5D6">
                    <td style="border-color: #5CA5D6"><label style="font-weight:bold;" >密码:</label></td>
                    <td> <input type="password" name="password" id = "password"></td>
                </tr>
               <tr style="background-color: #5CA5D6">
                   <td colspan="2" ><div align="center"><input type="submit" value="提交查询"><span style="font-size: 22px  " >${requestScope.msg.error_msg}</span></div></td>
               </tr>

            </form>
        </table>
    </div>
    </div>

</div>


</body>
</html>
