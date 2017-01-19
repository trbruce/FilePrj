<%--
  Created by IntelliJ IDEA.
  User: Yusuf
  Date: 03/01/2017
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

    <title>Video File Transformer</title>
    <meta charset="utf-8">
    <meta name="keywords" content=" File converter,  downloader,  to mp4,  video downloader,  video converter, download  videos, download YouTube"/>
    <meta name="description" content="Convert File  videos to MP3, MP4 in HD with our  Converter and Downloader. No software download needed. Easy, fast and free!"/>
    <meta name="robots" content="index, follow">

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
        .modal-content {
            color: #000;
        }
    </style>

    <!-- field control javascripts -->
    <script type="text/javascript">
        function validateFileExtension(fld) {
            if(!/(\.avi|\.flv|\.mp4|\.mpeg)$/i.test(fld.value)) {
                //alert("Invalid image file type.");
               // document.getElementsByName('myfile').
               // $('#uploadmessage').val("Please select a media file to upload!....");
               // $('#uploadlabel').text("Please select a media file to upload!....");
               // $("#my-div").show();
                var canvas = document.getElementById("my-div");
                canvas.style.display = 'block';
                fld.form.reset();
                fld.focus();
                return false;
            }
            canvas.style.display = 'none';
            return true;
        } </script>
    <!-- field control javascripts -->

</head>
<body>
<%@ include file="header.jsp" %>


<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <p><a href="https://twitter.com/">Twitter</a></p>
            <p><a href="https://www.youtube.com/">Youtube</a></p>
            <p><a href="https://www.instagram.com">Instagram</a></p>
        </div>
        <div class="col-sm-8 text-left">

            <div class="col-sm-12 text-left">

                <h3><spring:message code="main.introduction"/></h3>


                <table class="table">

                    <tr>
                        <td colspan="2" class="container"><spring:message code="main.explanation"/></td>
                    </tr>

                    <tr>
                        <td>
                            <form id="UploadForm" action="${pageContext.request.contextPath}/upload.do" method="post" enctype="multipart/form-data" >
                                <table class="table">
                                    <tr class="success">
                                        <td>
                                            <input type="file" size="60" id="myfile" name="myfile">
                                        </td>
                                    </tr>
                                    <tr class="info">
                                        <td>
                                            <spring:message code="main.uploadfile" var="lblUpload" />
                                            <input type="button" value="${lblUpload}" onclick="return validateFileExtension(document.getElementsByName('myfile'))">
                                            <div   id="my-div" class="alert alert-warning"  style="display: none;">
                                                <strong>Warning!</strong> Please select a valid media file
                                            </div>
                                        </td>
                                    </tr>
                                    <tr  class="info">
                                        <td>
                                            <div id="progressbox" class="progress">
                                                <div id="progressbar" class="progress-bar" role="progressbar" aria-valuenow="1" aria-valuemin="0" aria-valuemax="100" style="width:10%"></div>
                                                <div id="percent">0%</div>
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>

                        </td>

                        <td>
                            <form  method="POST" action="${pageContext.request.contextPath}/convert.do" id="frmConvert" name ="frmConvert">
                                <table  class="table">
                                    <tr class="success">
                                        <td>
                                            <spring:message code="main.convertto"/> <span id="fileformat">MP4</span></p>
                                            <select  name="format_choice" id="format_choice" onchange="$('#fileformat').html(this.value)">
                                                <option value="mp4">MP4(.mp4) iPod/iPhone/PSP</option>
                                                <option value="avi">AVI(.avi)</option>
                                                <option value="flv">FLV(.flv)</option>
                                                <option value="mpg">MPEG-1(.mpg)</option>
                                                <option value="swf">Flash(.swf)</option>
                                                <option value="wmv">Windows Media Video (.wmv)</option>
                                                <option value="ogv">Ogv (.ogv)</option>
                                                <option value="dv">DV video(.dv)</option>
                                                <option value="mov">MOV(.mov)</option>
                                                <option value="3gp">3GP/3G2 Video (.3gp)</option>
                                                <option value="mjpeg">(Motion JPEG) (.mjpeg)</option>
                                                <option value="gif">Animation (.gif)</option>
                                                <option value="dvd">MPEG-2 PS(DVD VOB) (.dvd)</option>
                                                <option value="mp3">MPEG audio layer 3 (.mp3)</option>
                                                <option value="wav">WAV(.wav)</option>
                                                <option value="ogg">Ogg (.ogg)</option>
                                                <option value="wma">ASF Audio (.wma)</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr  class="info">
                                        <spring:message code="main.convert" var="lblConvert" />
                                        <td><input type="submit" id="btnConvert" name="btnConvert" value="${lblConvert}" onclick="" style="cursor:pointer"/></td>
                                    </tr>

                                    <tr>
                                        <td></td>
                                    </tr>
                                </table>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                        </td>
                    </tr>
                    <tr  class="danger">
                        <form  method="POST" action="${pageContext.request.contextPath}/download.do" id="frmdownload" name ="frmdownload">
                            <td>
                                <input type="hidden" id="filename" value="${fileName}"/>

                                <input type="text"  hidden readonly value="${fileName}"/>
                            </td>
                            <td>
                                <spring:message code="main.download" var="lblDownload" />
                                <input type="submit" id="btnDownload" name="btnDownload" value="${lblDownload}" onclick="" style="cursor:pointer"/>
                            </td>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                    </tr>
                    <tr>
                        <td colspan="2"><spring:message code="main.note1"/> <strong><spring:message code="main.note2"/></strong> <spring:message code="main.note3"/></td>
                    </tr>


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
