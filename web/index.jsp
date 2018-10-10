<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]><html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <title>Kool Store - Responsive eCommerce Template</title>

  <meta name="description" content="">
  <meta name="viewport" content="width=device-width">

  <link href="http://fonts.useso.com/css?family=Open+Sans:400,300,600,700,800" rel="stylesheet">

  <link rel="stylesheet" href="css/bootstrap.css">
  <link rel="stylesheet" href="css/normalize.min.css">
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <link rel="stylesheet" href="css/animate.css">
  <link rel="stylesheet" href="css/templatemo-misc.css">
  <link rel="stylesheet" href="css/templatemo-style.css">

  <script src="js/vendor/modernizr-2.6.2.min.js"></script>

</head>
<body>
<!--[if lt IE 7]>
<p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
<![endif]-->


<header class="site-header">
  <!--<div class="top-header">
      <div class="container">
          <div class="row">
              <div class="col-md-6 col-sm-6">
                  <div class="top-header-left">
                      <a href="#">Sign Up</a>
                      <a href="#">Log In</a>
                  </div>
              </div>
              <div class="col-md-6 col-sm-6">
                  <div class="social-icons">
                      <ul>
                          <li><a href="#" class="fa fa-facebook"></a></li>
                          <li><a href="#" class="fa fa-dribbble"></a></li>
                          <li><a href="#" class="fa fa-twitter"></a></li>
                          <li><a href="#" class="fa fa-linkedin"></a></li>
                      </ul>
                      <div class="clearfix"></div>
                  </div>
              </div>
          </div>
      </div>
  </div> -->
  <div class="main-header">
    <div class="container">
      <div class="row">
        <div class="col-md-4 col-sm-6 col-xs-8">
          <div class="logo">
            <h1><a href="#">资讯汇总</a></h1>
          </div> <!-- /.logo -->
        </div> <!-- /.col-md-4 -->
      </div> <!-- /.row -->
    </div> <!-- /.container -->
  </div> <!-- /.main-header -->
  <div class="main-nav">
    <div class="container">
      <div class="row">
        <div class="col-md-12 col-sm-12">
          <div class="list-menu">
            <ul>
              <li><a href="index.jsp">首页</a></li>
              <li><a href="Searchallnews">新闻</a></li>
              <li><a href="SearchAllEssays">论文</a></li>
              <li><a href="SearchAllContent">专利</a></li>
              <li><a href="addkey.jsp">添加信息</a></li>
            </ul>
          </div> <!-- /.list-menu -->
        </div> <!-- /.col-md-6 -->
        <!-- /.col-md-6 -->
      </div> <!-- /.row -->
    </div> <!-- /.container -->
  </div> <!-- /.main-nav -->
</header> <!-- /.site-header -->




<div class="content-section">
  <div class="container">
    <div class="row">
      <div class="col-md-12 section-title">
        <h2>使用须知</h2>
      </div> <!-- /.section -->
    </div> <!-- /.row -->
    <div class="row">
      <p style="font-size:15px">
        &nbsp;&nbsp;&nbsp;&nbsp;论文，专利等相关信息，通过导航栏可以跳转到相应的文章列表。添加关键词以及添加新闻网址是方便用户自己调整喜好
      </p>
      <p style="font-size:15px">
        &nbsp;&nbsp;&nbsp;&nbsp;注意：1.添加之后不会立即生效，需要等到爬虫再次爬取才会更新文章列表
        <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.删除关键词需要完整地输入关键词，否则删除不成功
      </p>
    </div> <!-- /.row -->
  </div> <!-- /.container -->
</div> <!-- /.content-section -->
<footer class="site-footer">
  <div class="main-footer">
    <div class="container">
      <div class="row">
        <div class="col-md-4">
          <div class="footer-widget">
            <h3 class="widget-title">联系我们</h3>

            地址：中国 上海曹安公路4800号同济大学软件学院
            <br>邮编：201804
            <br>联系电话：86-21-69589585,69589332(FAX)

          </div> <!-- /.footer-widget -->
        </div> <!-- /.col-md-3 -->
        <div class="col-md-3">
          <div class="footer-widget">
            <h3 class="widget-title">邮箱地址</h3>
            1585084146@qq.com
            <br>1264160868@qq.com
            <br>1228974364@qq.com

          </div> <!-- /.footer-widget -->
        </div> <!-- /.col-md-3 -->
        <div class="col-md-4">
          <div class="footer-widget">
            <img src="images/tongji.png" style="height: 150px">
          </div> <!-- /.footer-widget -->
        </div> <!-- /.col-md-3 -->
      </div> <!-- /.row -->
    </div> <!-- /.container -->
  </div> <!-- /.main-footer -->

</footer> <!-- /.site-footer -->

<script src="js/vendor/jquery-1.10.1.min.js"></script>
<script>window.jQuery || document.write('<script src="js/vendor/jquery-1.10.1.min.js"><\/script>')</script>
<script src="js/jquery.easing-1.3.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/plugins.js"></script>
<script src="js/main.js"></script>


</body>
</html>
