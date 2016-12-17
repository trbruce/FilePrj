

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>File Services</title>
    <meta name="keywords" content="Media file converter, File downloader, Video to mp4,  video downloader,  video converter, download  videos, download music,
free conversion, free online conversion, free file conversion, free online file conversion, video converter, audio converter"/>
    <meta name="description" content="Free online video converter, audio converter, Convert  videos to MP3, MP4 in HD with our  Converter and Downloader. No software download needed. Easy, fast and free!"/>
    <meta name="robots" content="index, follow">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="http://malsup.github.com/jquery.form.js" ></script>
    <script src="js/fileUploadScript.js" ></script>
    <script type="application/javascript" src="http://jsonip.appspot.com/?callback=getip">
    </script>
</head>
<body>
<div class="container">
  <h2>Convert  Video and Music Files</h2>
    <table class="table">
    <tr>
        <td>
                     <form id="UploadForm" action="./upload.do" method="post" enctype="multipart/form-data">
                            <table class="table">
                                <tr class="success">
                                    <td>
                                       1.<input type="file" size="60" id="myfile" name="myfile">
                                    </td>
                                </tr>
                                <tr class="info">
                                    <td>
                                       2.<input type="submit" value="Upload File">
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
                        </form>

        </td>

        <td>
            <form  method="POST" action="./convert.do" id="frmConvert" name ="frmConvert">
                    <table  class="table">
                        <tr class="success">
                            <td>
                                    Convert to <span id="fileformat">MP4</span></p>
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
                            <td>3.<input type="submit" id="btnConvert" name="btnConvert" value="Convert" onclick="" style="cursor:pointer"/></td>
                        </tr>

                        <tr>
                            <td></td>
                        </tr>
                    </table>
                </form>
            </td>
    </tr>
    <tr  class="danger">
        <form  method="POST" action="./download.do" id="frmdownload" name ="frmdownload">
        <td>
            <input type="hidden" id="filename" value="${fileName}"/>

            <input type="text"  hidden readonly value="${fileName}"/>
        </td>
        <td>
           4.<input type="submit" id="btnDownload" name="btnDownload" value="Download" onclick="" style="cursor:pointer"/>
        </td>

        </form>
    </tr>
        <tr class="active">
            <td colspan="2">
                <iframe style="width:120px;height:240px;" marginwidth="0" marginheight="0" scrolling="no" frameborder="0" src="//ws-eu.amazon-adsystem.com/widgets/q?ServiceVersion=20070822&OneJS=1&Operation=GetAdHtml&MarketPlace=GB&source=ac&ref=tf_til&ad_type=product_link&tracking_id=httpwwwfiletr-21&marketplace=amazon&region=GB&placement=B00CTVTJ4Q&asins=B00CTVTJ4Q&linkId=&show_border=true&link_opens_in_new_window=true">
                </iframe>

            </td>

        </tr>


</table>
</div>

<script type="application/javascript">
    var ipaddress;
    function getip(json){
        alert(json.ip); // alerts the ip address
        ipaddress = json.ip;
    }
</script>

</body>
</html>

