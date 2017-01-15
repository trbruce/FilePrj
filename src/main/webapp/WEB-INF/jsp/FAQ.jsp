<%--
  Created by IntelliJ IDEA.
  User: Yusuf
  Date: 03/01/2017
  Time: 07:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%--
  Created by IntelliJ IDEA.
  User: Yusuf
  Date: 03/01/2017
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
    <script>
        (adsbygoogle = window.adsbygoogle || []).push({
            google_ad_client: "ca-pub-9243924041723557",
            enable_page_level_ads: true
        });
    </script>

    <title><spring:message code="menu.logo"/></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        /* Remove the navbar's default margin-bottom and rounded borders */
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }

        /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
        .row.content {height: 450px}

        /* Set gray background color and 100% height */
        .sidenav {
            padding-top: 20px;
            background-color: #f1f1f1;
            height: 100%;
        }

        /* Set black background color, white text and some padding */
        footer {
            background-color: #555;
            color: white;
            padding: 15px;
        }

        /* On small screens, set height to 'auto' for sidenav and grid */
        @media screen and (max-width: 767px) {
            .sidenav {
                height: auto;
                padding: 15px;
            }
            .row.content {height:auto;}
        }
    </style>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/welcome.do"><spring:message code="menu.logo"/></a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li ><a href="${pageContext.request.contextPath}/welcome.do"><spring:message code="menu.home"/></a></li>
                <li ><a href="${pageContext.request.contextPath}/videoformats.do"><spring:message code="menu.videoformats"/></a></li>
                <li class="active"><a href="#"><spring:message code="menu.FAQ"/></a></li>
                <li><a href="${pageContext.request.contextPath}/contact.do"><spring:message code="menu.contact"/></a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <spring:message code="menu.language" var="lblLanguage" /><spring:message code="menu.english" var="lblEnglish" />
                <spring:message code="menu.french" var="lblFrench" />
                <li>${lblLanguage}</li>
                <li><a href="?lang=en">${lblEnglish}</a></li>
                <li> <a href="?lang=fr">${lblFrench}</a></li>
                <!--   <li>Current Locale : ${pageContext.response.locale} / ${locale}
                </li> -->
                <li><a href="${pageContext.request.contextPath}/login.do"><span class="glyphicon glyphicon-log-in"></span><spring:message code="menu.login"/></a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <p><a href="https://twitter.com/">Twitter</a></p>
            <p><a href="https://www.youtube.com/">Youtube</a></p>
            <p><a href="https://www.instagram.com">Instagram</a></p>
        </div>
        <div class="col-sm-8 text-left">
            <h1><spring:message code="faq.title" />(FAQ)</h1>
            <spring:message code="main.introduction"/>
            <hr>

            <div class="col-sm-8 text-left ">
                <div class="list-group">
                    <a href="#" class="list-group-item active"><spring:message code="faq.question1" /></a>
                    <a href="#" class="list-group-item"><spring:message code="faq.answer1" /></a>
                    <a href="#" class="list-group-item active"><spring:message code="faq.question2" /></a>
                    <a href="#" class="list-group-item"><spring:message code="faq.answer2" /></a>
                    <a href="#" class="list-group-item active"><spring:message code="faq.question3" /></a>
                    <a href="#" class="list-group-item"><spring:message code="faq.answer3" /></a>

                </div>



            </div>

        </div>
        <div class="col-sm-2 sidenav">
            <div class="well">
                <p><script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
                    <!-- filetransormerR1 -->
                    <ins class="adsbygoogle"
                         style="display:block"
                         data-ad-client="ca-pub-9243924041723557"
                         data-ad-slot="8948025821"
                         data-ad-format="auto"></ins>
                    <script>
                        (adsbygoogle = window.adsbygoogle || []).push({});
                    </script></p>
            </div>
            <div class="well">
                <p>TBD</p>
            </div>
        </div>
    </div>
</div>

<footer class="container-fluid text-center">
    <p><spring:message code="menu.logo"/></p>
</footer>

</body>
</html>
