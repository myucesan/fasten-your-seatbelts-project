<!DOCTYPE html>
<?php
	// include language configuration file based on selected language
	require_once("languages/translator.php");
	require_once("languages/lang.".$_SESSION["lang"].".php");
?>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><?= $language["SITE_TITLE"]; ?></title>
 <!-- Custom styles for this template -->
    <link href="css/business-casual.css" rel="stylesheet">
	<link href="css/lang.css" rel="stylesheet">
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="fonts/font.ttf"   rel="stylesheet" type="text/css">
    <link href="fonts/font2.ttf"   rel="stylesheet" type="text/css">



  </head>

  <body>
<!-- START LANGUAGE PICKER -->

<!-- END LANGUAGE PICKER -->
    <div class="tagline-upper text-center text-heading text-shadow text-white mt-5 d-none d-lg-block">Corendon</div>
    <div class="tagline-lower text-center text-expanded text-shadow text-uppercase text-white mb-5 d-none d-lg-block"><?= $language["HOLIDAY_PHOTO_VIEWER"]; ?></div>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light bg-faded py-lg-4">
	<ul class="languagepicker roundborders large">
	<a href="?lang=nl" <?php if($_SESSION["lang"] == 'nl'){?> style="color:#ff9900;" <?php } ?>><li><img src="http://i65.tinypic.com/2d0kyno.png"/>Nederlands</li></a>
	<a href="?lang=frys" <?php if($_SESSION["lang"] == 'frys'){?> style="color:#ff9900;" <?php } ?>><li><img src="http://i65.tinypic.com/2d0kyno.png"/>Frysk</li></a>
	<a href="?lang=en" <?php if($_SESSION["lang"] == 'en'){?> style="color:#ff9900;" <?php } ?>><li><img src="http://i64.tinypic.com/fd60km.png"/>English</li></a>
	<a href="?lang=de" <?php if($_SESSION["lang"] == 'de'){?> style="color:#ff9900;" <?php } ?>><li><img src="http://i63.tinypic.com/10zmzyb.png"/>Deutsch</li></a>
	<a href="?lang=es" <?php if($_SESSION["lang"] == 'es'){?> style="color:#ff9900;" <?php } ?>><li><img src="http://i68.tinypic.com/avo5ky.png"/>Español</li></a>
	</ul>
      <div class="container">
        <a class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none" href="#"><?= $language["HOLIDAY_PHOTO_VIEWER"]; ?></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav mx-auto">
		  <?php
		  if($_SESSION["lang"]){
			  ?>
			  <li class="nav-item active px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="index.php?lang=<?php echo $_SESSION['lang'];?>"><?= $language["HOME"]; ?>
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="about.php?lang=<?php echo $_SESSION['lang'];?>"><?= $language["ABOUT"]; ?></a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="contact.php?lang=<?php echo $_SESSION['lang'];?>"><?= $language["CONTACT"]; ?></a>
            </li>
			  <?php
		  }else{
			  ?>
			  <li class="nav-item active px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="index.php"><?= $language["HOME"]; ?>
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="about.php"><?= $language["ABOUT"]; ?></a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="contact.php"><?= $language["CONTACT"]; ?></a>
            </li>
			  <?php
		  }
		  ?>
            
          </ul>
        </div>
      </div>

    </nav>

    <div class="container">

      <div class="bg-faded p-4 my-4">
        <!-- Image Carousel -->
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
              <img class="d-block img-fluid w-100" src="img/slide-1.jpg" alt="">
              <div class="carousel-caption d-none d-md-block">
                <h3 class="text-shadow"><?= $language["SLIDE1"]; ?></h3>
                <p class="text-shadow"><?= $language["SLIDE1_CAPTION"]; ?></p>
              </div>
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid w-100" src="img/slide-2.jpg" alt="">
              <div class="carousel-caption d-none d-md-block">
                <h3 class="text-shadow"><?= $language["SLIDE2"]; ?></h3>
                <p class="text-shadow"><?= $language["SLIDE2_CAPTION"]; ?></p>
              </div>
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid w-100" src="img/slide-3.jpg" alt="">
              <div class="carousel-caption d-none d-md-block">
                <h3 class="text-shadow"><?= $language["SLIDE3"]; ?></h3>
                <p class="text-shadow"><?= $language["SLIDE3_CAPTION"]; ?></p>
              </div>
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
        <!-- Welcome Message -->
        <div class="text-center mt-4">
          <div class="text-heading text-muted text-lg"><?= $language["WELCOME"]; ?></div>
          <img src="img/logo.png" style="max-width:30%;
max-height:30%;" >
        </div>
      </div>

      <div class="bg-faded p-4 my-4">
        <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0">
          <strong><?= $language["ENTER_CODE"]; ?></strong>
        </h2>
<!-- vaniut hier kun je naar de galerij en de code word opgeslagen in een post-->
        <form action="gallery/index.php" class="login" method="post" >
          <br>
          <input type="text" name="code" value=""><br>
          <br><br>
          <input type="submit" value="Submit">
        </form>
      </div>

      <div class="bg-faded p-4 my-4">
        <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0">
          <strong><?= $language["MAP_PHOTO_BOOTH"]; ?></strong>
        </h2>
        <iframe frameborder=0 style='width:100%;height:500px;' src='//www.zeemaps.com/pub?group=2728497'> </iframe>
        <hr class="divider">
      </div>

    </div>
    <!-- /.container -->

    <footer class="bg-faded text-center py-5">
      <div class="container">
        <p class="m-0"><?= $language["COPYRIGHT"]; ?></p>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

  </body>

</html>
