<?php

	if (isset($_GET['email'])) {
	
	$senderName = $_POST['name'];
	$senderMail = $_GET['email'];
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
    echo "Mail is sent. You'll receive your code soon as possible.";
	//header( "refresh:15;url=index.html" );
}else{  
    echo "Oops... something went wrong.";
}

?>