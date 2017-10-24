<?php

if (isset($_POST["email"])) {
	
	$senderName = $_POST['name'];
	$senderMail = $_POST['email'];
	$senderPhone = $_POST['phone'];
	$senderMessage = $_POST['message'];
	date_default_timezone_set("Europe/Amsterdam");
	$currentDateTime = date("d/m/Y h:i");
	
	$to = "alfredez008@gmail.com";
	$subject = "HTML email";

	$message = "
	<html>
	<head>
	<title>Contact - Corendon Fotoviewer</title>
	<meta charset='utf-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>
    <meta name='description' content=''>
    <meta name='author' content=''>

    <!-- Bootstrap core CSS -->
    <link href='vendor/bootstrap/css/bootstrap.min.css' rel='stylesheet'>

    <!-- Custom fonts for this template -->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href='css/business-casual.css' rel='stylesheet'>
	</head>
	<body>
	
	<div class='bg-faded p-4 my-4'>
        <div class='card card-inverse'>
          <img class='card-img img-fluid w-10' style='width:30%;' src='http://mustafayucesan.nl/img/logo.png' >
          <div class='card-img-overlay bg-overlay'>
            <h2 class='card-title text-shadow text-black text-uppercase mb-0'>".$senderName."</h2>
            <h4 class='text-shadow text-black'>".$currentDateTime."</h4>
            <p class='lead card-text text-shadow text-black w-50 d-none d-lg-block'>".$senderMessage."</p>
          </div>
        </div>
      </div>
	</body>
	</html>
	";

	//Bij headers wordt de type mail aangegeven en naar wie het allemaal door verstuurd moet worden.     
	$headers = "From: ".$senderMail."\r\n";
	$headers .= "Reply-To: ".$senderMail."\r\n";
	$headers .= "Return-Path: ".$senderMail."\r\n";
	//$headers .= "CC: sombodyelse@example.com\r\n";
	//$headers .= "BCC: hidden@example.com\r\n";
	$headers  .= "Content-type: text/html;";


	mail($to,$subject,$message,$headers);
    //echo "Mail is sent. We'll contact you soon as possible";
	//header( "refresh:15;url=index.html" );
}else{  
    echo "Oops... something went wrong.";
}


?> 
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Contact</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="css/business-casual.css" rel="stylesheet">

  </head>

  <body>

    <div class="tagline-upper text-center text-heading text-shadow text-white mt-5 d-none d-lg-block">Corendon</div>
    <div class="tagline-lower text-center text-expanded text-shadow text-uppercase text-white mb-5 d-none d-lg-block">Vakantie Foto viewer</div>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light bg-faded py-lg-4">
      <div class="container">
        <a class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none" href="#">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav mx-auto">
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="index.html">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="about.html">About</a>
            </li>
            <li class="nav-item active px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="contact.html">Contact</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

  

      <div class="bg-faded p-4 my-4">
        <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0">
          <strong>Mail has been sent<br> We'll contact you soon as possible</strong>
        </h2>
        <hr class="divider">
		
      </div>
      </div>

    </div>


    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Zoom when clicked function for Google Map -->


  </body>

</html>
