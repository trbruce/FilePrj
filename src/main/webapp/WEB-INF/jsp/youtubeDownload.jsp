<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<title>File Services</title>
    <meta name="keywords" content="Media file converter, File downloader, Video to mp4,  video downloader,  video converter, download  videos, download music"/>
    <meta name="description" content="Convert  videos to MP3, MP4 in HD with our  Converter and Downloader. No software download needed. Easy, fast and free!"/>
    <meta name="robots" content="index, follow">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1 align="center">
Convert  video and Music Files
</h1>
<br>
${message}
<p></p>
<center>
<div class="container">
    <form  method="POST" action="./checkFileURL.do" id="frmRegister" name ="frmRegister"   >
<div class="form-group">


    <li>
<input  class="form-control" name="texturl" type="text"  id="texturl" placeholder="Paste link here.. e.g. https://www.youtube.com/watch?v=PT2_F-1esPk" title="" value="${texturl}" />
</li>
</div>

<li>
    <div id="select_main"  tabindex="1">
        <b>Format:</b>
        <span>.mp3</span>

    </div>

</li>
    <div class="form-group">
        <input type="submit" id="btnRegister" name="btnRegister" value="Convert" onclick="" style="cursor:pointer"/>

        


</div>

    <h2><a href="./download.do">Click here to download file</a></h2>

</form>
</div>
</center>
</body>
</html>
