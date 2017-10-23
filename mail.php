<?php

if (isset($_POST["email"])) {
	
	$senderName = $_POST['name'];
	$senderMail = $_POST['email'];
	$senderPhone = $_POST['phone'];
	$senderMessage = $_POST['message'];
	
	$to = "alfredez008@gmail.com";
	$subject = "HTML email";

	$message = "
	<html>
	<head>
	<title>HTML email</title>
	</head>
	<body>
	<p>This email contains HTML Tags!</p>
	<table>
	<tr>
	<th>Name</th>
	<th>Email</th>
	<th>Phone Number</th>
	<th>Message</th>
	</tr>
	<tr>
	<td>".$senderName."</td>
	<td>".$senderMail."</td>
	<td>".$senderPhone."</td>
	<td>".$senderMessage."</td>
	</tr>
	</table>
	</body>
	</html>
	";

	//Bij headers wordt de type mail aangegeven en naar wie het allemaal door verstuurd moet worden.     
	$headers = "From: ".$senderMail."\r\n";
	$headers .= "Reply-To: info@tilky.nl\r\n";
	$headers .= "Return-Path: myplace@example.com\r\n";
	//$headers .= "CC: sombodyelse@example.com\r\n";
	//$headers .= "BCC: hidden@example.com\r\n";
	$headers  .= "Content-type: text/html;";


	//mail($to,$subject,$message,$headers);
    //echo "Mail is sent. We'll contact you soon as possible";
	//header( "refresh:15;url=index.html" );
}else{  
    echo "N0, mail is not set";
}


?> 
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Business Casual - Start Bootstrap Theme</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="css/business-casual.css" rel="stylesheet">

  </head>

  <body>

    <div class="tagline-upper text-center text-heading text-shadow text-white mt-5 d-none d-lg-block">Business Casual</div>
    <div class="tagline-lower text-center text-expanded text-shadow text-uppercase text-white mb-5 d-none d-lg-block">3481 Melrose Place | Beverly Hills, CA 90210 | 123.456.7890</div>

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
          <strong>Mail is sent. We'll contact you soon as possible</strong>
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
