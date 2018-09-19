<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>权限错误</title>
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/statics/css/bootstrap.css" rel="stylesheet">
    <!-- FONT AWESOME CSS -->
    <link href="${pageContext.request.contextPath}/statics/css/font-awesome.min.css" rel="stylesheet" />
    <!--GOOGLE FONT -->
 <link href='http://fonts.googleapis.com/css?family=Nova+Flat' rel='stylesheet' type='text/css'>
    <!-- custom CSS here -->
    <link href="${pageContext.request.contextPath}/statics/css/error.css" rel="stylesheet" />
</head>
<body>
    
   
    <div class="container">
      
          <div class="row pad-top text-center">
                 <div class="col-md-6 col-md-offset-3 text-center">
              <span id="error-link"></span>
                     <h2>对不起，您没有权限！请点击下方进行登录！ </h2>
</div>
        </div>

            <div class="row text-center">
                 <div class="col-md-8 col-md-offset-2">
                     
                     <h3> <i  class="fa fa-lightbulb-o fa-5x"></i> </h3>
               <a href="${pageContext.request.contextPath}/" class="btn btn-primary">点我进行登录</a> 
             <br/>
			<br/>
</div>
        </div>

    </div>
    <!-- /.container -->
  
  
    <!--Core JavaScript file  -->
    <script src="${pageContext.request.contextPath}/statics/js/jquery-1.8.3.min.js"></script>
    <!--bootstrap JavaScript file  -->
    <script src="${pageContext.request.contextPath}/statics/js/bootstrap.js"></script>
     <!--Count Number JavaScript file  -->
    <script src="${pageContext.request.contextPath}/statics/js/countUp.js"></script>
       <!--Custom JavaScript file  -->
    <script src="${pageContext.request.contextPath}/statics/js/custom.js"></script>
</body>
</html>
