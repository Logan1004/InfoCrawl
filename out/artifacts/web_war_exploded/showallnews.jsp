<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.util.Constant" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
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
                            <li><a href="addkey.jsp">添加关键词</a></li>
                            <li><a href="addnews.jsp">添加新闻源</a></li>
                        </ul>
                    </div> <!-- /.list-menu -->
                </div> <!-- /.col-md-6 -->
                <!-- /.col-md-6 -->
            </div> <!-- /.row -->
        </div> <!-- /.container -->
    </div> <!-- /.main-nav -->
</header> <!-- /.site-header -->

<%
    Constant.Initial();
    String name = "";
    if (request.getParameter("Category")!=null) name = request.getParameter("Category");
%>


<div class="content-section">
    <div class="container">
        <div class="row">
            <div class="col-md-12 section-title">
                <h2>新闻</h2>
            </div> <!-- /.section -->
        </div> <!-- /.row -->
        <div class="row">
            <%
                for (int i=0;i<Constant.keywords.size();i++){
            %>
            <div class="col-md-1 col-sm-6">
                <div class="product-item">
                    <h5><a href="SearchNewsByCategory?Category=<%=Constant.keywords.get(i).getKeyword()%>"><%=Constant.keywords.get(i).getKeyword()%></a></h5>
                </div> <!-- /.product-item -->
            </div> <!-- /.col-md-3 -->

            <%

                }
                Constant.keywords.clear();
            %>

        </div> <!-- /.row -->
    </div> <!-- /.container -->
</div> <!-- /.content-section -->
<%
    int index = 0;
%>
<div class="content-section">
    <div class="container">
        <div class="col-md-12">
            <c:forEach var="U" items="${userAll}">
                <%
                    index++;
                %>

                <p>
                    <a href="${U.url}" target="_blank"><%=index%>.${U.content}</a>
                    <em><small>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${U.curtime}</small></em>
                </p>

            </c:forEach>

            <%
                String url = "";
                if (name.equals("")) url = "Searchallnews?page=";
                else url = "SearchNewsByCategory?Category="+name+"&page=";
            %>
            <div >
                <%
                    if (request.getParameter("page")!=null) Constant.NewsCurrentPage = Integer.parseInt(request.getParameter("page"));
                %>
                <p>
                    <a <%if (Constant.NewsCurrentPage>1){%> href=<%=url+"1"%><%}%>>首页</a>
                    <!-- 上页按钮，跳转到上一页 -->
                    <a <%if (Constant.NewsCurrentPage>1){%> href=<%=url+(Constant.NewsCurrentPage-1)%><%}%>>上页</a>

                    <!-- 下页按钮，跳转到下一页 -->
                    <a <%if (Constant.NewsCurrentPage<Constant.NewsTotalpage){%> href=<%=url+(Constant.NewsCurrentPage+1)%><%}%>>下页</a>

                    <!-- 末页按钮，跳转到最后一页 -->
                    <a <%if (Constant.NewsCurrentPage<Constant.NewsTotalpage){%> href=<%=url+Constant.NewsTotalpage%><%}%>>末页</a>

                </p>
                共 <i class="blue">${Constant.TotalNews}</i>
                条记录，当前显示第 <i class="blue">${Constant.NewsCurrentPage}
            </i> 页 / 共 <i class="blue">${Constant.NewsTotalpage}</i> 页
                <!-- 首页按钮，跳转到首页 -->

            </div>


            <!--文章列表放置位置-->
        </div> <!-- /.col-md-2 -->
    </div> <!-- /.container -->
</div>
<div class="main-footer">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <div class="footer-widget">
                    <h3 class="widget-title">About Us</h3>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eligendi, debitis recusandae.
                    <ul class="follow-us">
                        <li><a href="#"><i class="fa fa-facebook"></i>Facebook</a></li>
                        <li><a href="#"><i class="fa fa-twitter"></i>Twitter</a></li>
                    </ul> <!-- /.follow-us -->
                </div> <!-- /.footer-widget -->
            </div> <!-- /.col-md-3 -->
            <div class="col-md-3">
                <div class="footer-widget">
                    <h3 class="widget-title">Why Choose Us?</h3>
                    Kool Store is free responsive eCommerce template provided by templatemo website. You can use this layout for any website.
                    <br><br>Tempore cum mollitia eveniet laboriosam corporis voluptas earum voluptate. Lorem ipsum dolor sit amet.
                    <br><br>Credit goes to <a rel="nofollow" href="#">Unsplash</a> for all images.
                </div> <!-- /.footer-widget -->
            </div> <!-- /.col-md-3 -->
            <div class="col-md-2">
                <div class="footer-widget">
                    <h3 class="widget-title">Useful Links</h3>
                    <ul>
                        <li><a href="#">Our Shop</a></li>
                        <li><a href="#">Partners</a></li>
                        <li><a href="#">Gift Cards</a></li>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Help</a></li>
                    </ul>
                </div> <!-- /.footer-widget -->
            </div> <!-- /.col-md-2 -->
            <div class="col-md-4">
                <div class="footer-widget">
                    <h3 class="widget-title">Our Newsletter</h3>
                    <div class="newsletter">
                        <form action="#" method="get">
                            <p>Sign up for our regular updates to know when new products are released.</p>
                            <input type="text" title="Email" name="email" placeholder="Your Email Here">
                            <input type="submit" class="s-button" value="Submit" name="Submit">
                        </form>
                    </div> <!-- /.newsletter -->
                </div> <!-- /.footer-widget -->
            </div> <!-- /.col-md-4 -->
        </div> <!-- /.row -->
    </div> <!-- /.container -->
</div> <!-- /.main-footer -->
<div class="bottom-footer">
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center">
                <span>Copyright &copy; 2084 More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></span>

            </div> <!-- /.col-md-12 -->
        </div> <!-- /.row -->
    </div> <!-- /.container -->
</div> <!-- /.bottom-footer -->


<script src="js/vendor/jquery-1.10.1.min.js"></script>
<script>window.jQuery || document.write('<script src="js/vendor/jquery-1.10.1.min.js"><\/script>')</script>
<script src="js/jquery.easing-1.3.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/plugins.js"></script>
<script src="js/main.js"></script>


</body>
</html>