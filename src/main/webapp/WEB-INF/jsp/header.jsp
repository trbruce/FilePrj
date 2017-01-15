<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <spring:message code="menu.logo" var="lblLogo" />
            <a class="navbar-brand" href="${pageContext.request.contextPath}/welcome.do">${lblLogo}</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}/welcome.do"> <spring:message code="menu.home"/></a></li>
                <li ><a href="${pageContext.request.contextPath}/videoformats.do"><spring:message code="menu.videoformats"/></a></li>
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