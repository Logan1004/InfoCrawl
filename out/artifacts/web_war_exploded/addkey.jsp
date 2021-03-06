<%@ page import="com.util.Constant" %><%--
  Created by IntelliJ IDEA.
  User: logan
  Date: 2018/9/29
  Time: 5:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]><html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
    <!--
    Kool Store Template
    #/preview/templatemo_428_kool_store
    -->
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



<%
    Constant.ContentFlag=1;
    Constant.NewsFlag=1;
    Constant.EssayFlag=1;
    String info = (String)request.getAttribute("info");
    String deleteinfo = (String)request.getAttribute("deleteinfo");
    String webinfo = (String)request.getAttribute("webinfo");
    if (info==null);
    else
    {
        %>
<script type="text/javascript" language="javascript">
    alert("<%=info%>")
    window.location='addkey.jsp';
</script>
<%
    info = null;
    }
    if (info==null);
    else
    {
%>
<script type="text/javascript" language="javascript">
    alert("<%=info%>")
    window.location='addkey.jsp';
</script>
<%
        info = null;
    }
%>


<%if (deleteinfo==null);
else
{
%>
<script type="text/javascript" language="javascript">
    alert("<%=deleteinfo%>")
    window.location='addkey.jsp';
</script>
<%
        info = null;
    }
    if (deleteinfo==null);
    else
    {
%>
<script type="text/javascript" language="javascript">
    alert("<%=deleteinfo%>")
    window.location='addkey.jsp';
</script>
<%
        deleteinfo = null;
    }
%>


<%if (webinfo==null);
else
{
%>
<script type="text/javascript" language="javascript">
    alert("<%=webinfo%>")
    window.location='addkey.jsp';
</script>
<%
        info = null;
    }
    if (webinfo==null);
    else
    {
%>
<script type="text/javascript" language="javascript">
    alert("<%=webinfo%>")
    window.location='addkey.jsp';
</script>
<%
        deleteinfo = null;
    }
%>




<div class="content-section">
    <div class="container">
        <div class="row">
            <div class="col-md-5 col-sm-6">
                <h3 class="widget-title">添加关键词</h3>
                <div class="contact-form">
                    <form name="contactform" id="contactform" action="KeywordServlet" method="post">
                        <p>
                            <input name="name" type="text" id="name" placeholder="关键词">
                        </p>
                        <input type="submit" class="mainBtn" id="submit" value="提交">
                    </form>
                </div> <!-- /.contact-form -->
            </div>
        </div>
        <div class="row">
            <div class="col-md-5 col-sm-6">
                <h3 class="widget-title">删除关键词</h3>
                <div class="contact-form">
                    <form name="contactform" id="contactform" action="DeleteServlet" method="post">
                        <p>
                            <input name="delename" type="text" id="delename" placeholder="关键词">
                        </p>
                        <input type="submit" class="mainBtn" id="delesubmit" value="提交">
                    </form>
                </div> <!-- /.contact-form -->
            </div>
        </div>
        <div class="row">
            <div class="col-md-5 col-sm-6">
                <h3 class="widget-title">添加新闻源</h3>
                <div class="contact-form">
                    <form name="contactform" id="contactform" action="WebServlet" method="post">
                        <p>
                            <input name="company" type="text" id="company" placeholder="网址描述">
                        </p>
                        <p>
                            <input name="url" type="text" id="url" placeholder="网址url">
                        </p>
                        <p>
                            <input name="category" type="text" id="category" placeholder="请输入完整关键词">
                        </p>
                        <input type="submit" class="mainBtn" id="infosubmit" value="提交">
                 </form>
                </div> <!-- /.contact-form -->
            </div>
        </div>
    </div>
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


<!-- Google Map -->
<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
<script src="js/vendor/jquery.gmap3.min.js"></script>

<!-- Google Map Init-->
<script type="text/javascript">
    jQuery(function ($) {
        $('.first-map, .map-holder').gmap3({
            marker: {
                address: '40.7828839,-73.9652425'
            },
            map: {
                options: {
                    zoom: 15,
                    scrollwheel: false,
                    streetViewControl: true
                }
            }
        });
    });
</script>


</body>
</html>
