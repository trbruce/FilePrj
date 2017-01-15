<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    <link rel="stylesheet" type="text/css"
          href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css"/>

    <style>
        /* Remove the navbar's default margin-bottom and rounded borders */
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }

        /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
        .row.content {
            height: 450px
        }

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

            .row.content {
                height: auto;
            }
        }
    </style>
</head>

<body>


<div class="container-fluid text-center">
    <div class="row content">
        <%@ include file="header.jsp" %>
        <div class="col-sm-2 sidenav">
            <p><a href="https://twitter.com/">Twitter</a></p>
            <p><a href="https://www.youtube.com/">Youtube</a></p>
            <p><a href="https://www.instagram.com">Instagram</a></p>
        </div>
        <h3><spring:message code="login.information"/></h3>

        <div class="col-sm-6 login-container">
            <div class="login-card">
                <div class="login-form">
                    <c:url var="loginUrl" value="/login.do"/>
                    <form action="${loginUrl}" method="post" class="form-horizontal">
                        <c:if test="${param.error != null}">
                            <div class="alert alert-danger">
                                <p><spring:message code="login.invaliduser"/></p>
                            </div>
                        </c:if>
                        <c:if test="${param.logout != null}">
                            <div class="alert alert-success">
                                <p><spring:message code="login.logout"/></p>
                            </div>
                        </c:if>
                        <div class="input-group input-sm">
                            <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                            <spring:message code="login.usernameplaceholder" var="lblUsernamePlaceholder"/>
                            <spring:message code="login.username" var="lblUsername"/>
                            <input type="text" class="form-control" id="username" name="ssoId"
                                   placeholder="${lblUsernamePlaceholder}" required>
                        </div>
                        <div class="input-group input-sm">
                            <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label>
                            <spring:message code="login.usernameplaceholder" var="lblPasswordPlaceholder"/>
                            <spring:message code="login.password" var="lblPassword"/>
                            <input type="password" class="form-control" id="password" name="password"
                                   placeholder="${lblPasswordPlaceholder}" required>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                        <div class="form-actions">
                            <spring:message code="login.login" var="lblLogin"/>
                            <input type="submit"
                                   class="btn btn-block btn-primary btn-default" value="${lblLogin}">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-sm-4 sidenav">
            <div class="well">
                <p>
                    <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
                    <!-- filetransormerR1 -->
                    <ins class="adsbygoogle"
                         style="display:block"
                         data-ad-client="ca-pub-9243924041723557"
                         data-ad-slot="8948025821"
                         data-ad-format="auto"></ins>
                    <script>
                        (adsbygoogle = window.adsbygoogle || []).push({});
                    </script>
                </p>
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