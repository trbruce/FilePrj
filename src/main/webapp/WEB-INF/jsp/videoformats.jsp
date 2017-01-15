<%--
  Created by IntelliJ IDEA.
  User: Yusuf
  Date: 03/01/2017
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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

    <title>Video File Transformer</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content=" File converter,  downloader,  to mp4,  video downloader,  video converter, download  videos, download YouTube"/>
    <meta name="description" content="Convert File  videos to MP3, MP4 in HD with our  Converter and Downloader. No software download needed. Easy, fast and free!"/>
    <meta name="robots" content="index, follow">

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
                <li class="active"><a href="#"><spring:message code="menu.videoformats"/></a></li>
                <li><a href="${pageContext.request.contextPath}/faq.do"><spring:message code="menu.FAQ"/></a></li>
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

            <h1><spring:message code="videoformat.videoformats"/></h1>
            <p><spring:message code="videoformat.list"/></p>
            <hr>
            <h3><spring:message code="videoformat.header"/></h3>
            <div class="container">


                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th><spring:message code="videoformat.fileFormat"/></th>
                        <th><spring:message code="videoformat.description"/></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>3gp</td>
                        <td><spring:message code="videoformat.3gp"/></td>
                    </tr>
                    <tr>
                        <td>avi</td>
                        <td><spring:message code="videoformat.avi"/></td>
                    </tr>
                    <tr>
                        <td>divx</td>
                        <td><spring:message code="videoformat.divx"/></td>
                    </tr>
                    <tr>
                        <td>flv</td>
                        <td><spring:message code="videoformat.flv"/></td>
                    </tr>
                    <tr>
                        <td>mkv</td>
                        <td><spring:message code="videoformat.mkv"/></td>
                    </tr>
                    <tr>
                        <td>mp4</td>
                        <td><spring:message code="videoformat.mp4"/></td>
                    </tr>
                    <tr>
                        <td>mpeg</td>
                        <td><spring:message code="videoformat.mpeg"/></td>
                    </tr>
                    </tbody>
                </table>
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
