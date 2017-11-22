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

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="fonts/font.ttf"   rel="stylesheet" type="text/css">
    <link href="fonts/font2.ttf"   rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="css/business-casual.css" rel="stylesheet">
	<link href="css/lang.css" rel="stylesheet">

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
              </a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="about.php?lang=<?php echo $_SESSION['lang'];?>"><?= $language["ABOUT"]; ?></a>
               <span class="sr-only">(current)</span>
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
        <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0">
          <strong><?=$language["ABOUT_TITLE"]?></strong>
        </h2>
        <hr class="divider">
        <div class="row">
          <div class="col-lg-6">
            <img class="img-fluid mb-4 mb-lg-0" src="img/slide-2.jpg" alt="">
          </div>
          <div class="col-lg-6">
            <p> <?= $language["ABOUT_TEXT"] ?></p>
          </div>
        </div>
      </div>
    </div>
    <!-- /.container -->

    <footer class="bg-faded text-center py-5">
      <div class="container">
        <p class="m-0"><?= $language["COPYRIGHT"] ?></p>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

  </body>

</html>
