<!DOCTYPE html>
<?php
	// inclusief taalconfiguratiebestand op basis van geselecteerde taal
	require_once("languages/translator.php");
	require_once("languages/lang.".$_SESSION["lang"].".php");
?>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Corendon - Vakantie foto viewer </title>

    <!-- Bootstrap kern CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Aangepaste lettertypen voor dit template -->
    <link href="fonts/font.ttf"   rel="stylesheet" type="text/css">
    <link href="fonts/font2.ttf"   rel="stylesheet" type="text/css">

    <!-- aangepaste stijlen voor dit template -->
    <link href="css/business-casual.css" rel="stylesheet">
	<link href="css/lang.css" rel="stylesheet">

  </head>

  <body>
		<!-- Start van de taalkiezer-->


    <div class="tagline-upper text-center text-heading text-shadow text-white mt-5 d-none d-lg-block"><?=$language["SITE_TITLE"]?></div>
    <div class="tagline-lower text-center text-expanded text-shadow text-uppercase text-white mb-5 d-none d-lg-block"><?=$language["HOLIDAY_PHOTO_VIEWER"]?></div>

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
        <a class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none" href="#"><?=$language["HOLIDAY_PHOTO_VIEWER"]?></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav mx-auto">
              
        <!-- einde van de taalkiezer -->      
              
           <?php
		  if($_SESSION["lang"]){
			  ?>
			  <li class="nav-item active px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="index.php?lang=<?php echo $_SESSION['lang'];?>"><?= $language["HOME"]; ?>
                
              </a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="about.php?lang=<?php echo $_SESSION['lang'];?>"><?= $language["ABOUT"]; ?></a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="contact.php?lang=<?php echo $_SESSION['lang'];?>"><?= $language["CONTACT"]; ?></a>
              <span class="sr-only">(current)</span>
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
        <h2 class="text-center text-lg text-uppercase my-0"><?=$language["CONTACT_TITLE"]?>
          <!-- hier staat alles voor het contact formulier -->
        </h2>
        <hr class="divider">
        <div class="row">
          <div class="col-lg-8">
            <div class="embed-responsive embed-responsive-16by9 map-container mb-4 mb-lg-0">
              <iframe frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://maps.google.com/maps?hl=en&amp;ie=UTF8&amp;ll=37.0625,-95.677068&amp;spn=56.506174,79.013672&amp;t=m&amp;z=4&amp;output=embed"></iframe>
            </div>
          </div>
          <div class="col-lg-4">
            <h5 class="mb-0"><?= $language["CONTACT_PHONE"] ?></h5>
            <div class="mb-4">+31 237510606</div>
            <h5 class="mb-0"><?= $language["CONTACT_EMAIL"] ?></h5>
            <div class="mb-4">
              <a href="mailto:name@example.com">administratie@corendon.nl</a>
            </div>
            <h5 class="mb-0"><?= $language["CONTACT_ADDRESS"] ?></h5>
            <div class="mb-4">
              Corendon
              <br>
              1170AH
			  <br>
			  Badhoevendorp
            </div>
          </div>
        </div>
      </div>

      <div class="bg-faded p-4 my-4">
        <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0"><?=$language["CONTACT_FORM_TITLE"]?>
        </h2>
        <hr class="divider">
        <form action="mail.php" method="POST">
          <div class="row">
            <div class="form-group col-lg-4">
              <label class="text-heading"><?=$language["CONTACT_FORM_NAME"]?></label>
              <input type="text" name="name" class="form-control">
            </div>
            <div class="form-group col-lg-4">
              <label class="text-heading"><?=$language["CONTACT_FORM_EMAIL"]?></label>
              <input type="email" name="email" class="form-control">
            </div>
            <div class="form-group col-lg-4">
              <label class="text-heading"><?=$language["CONTACT_FORM_PHONE"]?></label>
              <input type="tel" name="phone" class="form-control">
            </div>
            <div class="clearfix"></div>
            <div class="form-group col-lg-12">
              <label class="text-heading"><?=$language["CONTACT_FORM_MESSAGE"]?></label>
              <textarea class="form-control" name="message" rows="6"></textarea>
            </div>
            <div class="form-group col-lg-12">
              <button type="submit" class="btn btn-secondary">Submit</button>
            </div>
          </div>
        </form>
      </div>

    </div>
 

    <footer class="bg-faded text-center py-5">
      <div class="container">
        <p class="m-0"><?=$language["COPYRIGHT"]?></p>
      </div>
    </footer>

    <!-- Bootstrap kern JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Zoom in bij klikken op de functie voor Google Map -->
    <script>
      $('.map-container').click(function () {
        $(this).find('iframe').addClass('clicked')
      }).mouseleave(function () {
        $(this).find('iframe').removeClass('clicked')
      });
    </script>

  </body>

</html>
