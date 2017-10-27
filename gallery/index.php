<?php
require_once("../db.php");
// Create connection
$conn = new mysqli($dbserver, $dbuser, $dbpass, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
//$code = "CTcT7W";
$code = (isset($_POST['code']) ? $_POST['code'] : "undefined");
$sql = "SELECT * FROM sessie INNER JOIN foto ON sessie.id=foto.sessieID WHERE sessie.code = '$code'";
$result = mysqli_query($conn, $sql);
if($_POST['code'] == "") {
  echo "No code was submitted.";
}


echo "</div>";
?>

</script>



<!DOCTYPE html>
<html>
<head>
  <title>Gallery | Dreambox foto's!</title>
  <link rel="stylesheet" href="photoswipe.css">
  <link rel="stylesheet" href="default-skin/default-skin.css">
    <link rel="stylesheet" href="default-skin/flexbin.css">
  <script src="photoswipe.min.js"></script>
  <script src="js/api.js"></script>
  <script src="js/api2.js"></script>
  <script src="photoswipe-ui-default.min.js"></script>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Corendon - vakantie foto viewer</title>

    <!-- Bootstrap core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="fonts/font.ttf"   rel="stylesheet" type="text/css">
    <link href="fonts/font2.ttf"   rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="../css/business-casual.css" rel="stylesheet">
</head>



<script type="text/javascript">

    var featherEditor = new Aviary.Feather({
        apiKey: '1234567',
        onSave: function(imageID, newURL) {

			var downloads = document.getElementsByClassName(imageID);
			downloads.href = newURL;
			downloads.download = newURL;

		window.open("download.php?name=" + newURL + "&id=" + imageID,'_blank' );
            var img = document.getElementById(imageID);
            img.src = newURL;
			img.href = newURL;
			img.downloads = newURL;
        }
    });

    function launchEditor(id, src) {
        featherEditor.launch({
            image: id,
            href: src
        });
        return false;
    }



</script>


<body>

<div class="tagline-upper text-center text-heading text-shadow text-white mt-5 d-none d-lg-block">Corendon</div>
    <div class="tagline-lower text-center text-expanded text-shadow text-uppercase text-white mb-5 d-none d-lg-block">vakantie foto viewer</div>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light bg-faded py-lg-4">
      <div class="container">
        <a class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none" href="#">Corendon Vakantie foto viewer</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav mx-auto">
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="../index.php">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item active px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="../about.php">About</a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="../contact.php">Contact</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
	
	<div class="container">

      <div class="bg-faded p-4 my-4">
        <h2 class="text-center text-lg text-uppercase my-0">
          <strong>Gallery</strong>
        </h2>
        <div class="row">
          <?php

			if (mysqli_num_rows($result) > 0) {
				// output data of each row
			echo "<div class='gallery cf ' data-pswp-uid='1'>";
				while($row = mysqli_fetch_assoc($result)) {
					// echo "id: " . $row["id"]. " - path: " . $row["path"]. " " . $row["locatie"]. "<br>";
					//echo "<a href='#'>";
					//echo "<img src='$row[path]' />";
					//echo "</a>";
					$editableImage = "'editableimage".$row['id']."'";
					$path = " '".$row['path']."'";
					$downloadLink = "images/editableimage" . $row['id'].".jpg";


				// START NEW gallery

				  echo "<div>";
					// echo("<a href=\"#\" onclick=\"return launchEditor('.$editableImage.','.$path.');\"><img id='editableimage$row[id]' src='$row[path]' width='200'/></a>");
					echo "<img id='editableimage$row[id]' src='$row[path]' />";
					echo '<a href="#" onclick="return launchEditor('.$editableImage.','.$path.');" class="button twitter">Edit!</a>';
					// echo '<a id="editableimage'.$row["id"].'" class="button twitter" href="'.$row["path"].'" download>Download</a>';
					echo '<a class="button twitter editableimage'.$row["id"].'" href="../'.$row['path'].'" download>Download Original Foto</a>';
						echo '<a class="button twitter editableimage'.$row["id"].'" href="'.$downloadLink.'" download>Download Edited Foto</a>';
				  echo "</div>";


				// END NEW GALLERY
				}
			} else {
				echo "0 results";
			}
			echo "</div>";
			?>
        </div>
      </div>
    </div>
    <!-- /.container -->

    <footer class="bg-faded text-center py-5">
      <div class="container">
        <p class="m-0">Copyright &copy; Made by Resort5</p>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

 </body>
 </html>
