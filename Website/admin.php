<?php
// in dit document kunnen wij en uiteindelijk corendon wat e gebeurt met de photobooth, hoeveel foto's er zijn genomen hoeveel per dag etc...
	require_once("db.php");
	session_start();
	$conn = new mysqli($dbserver,$dbuser,$dbpass,$dbname);
	// controleer de connectie 
	if ($conn->connect_error){
		die("connection failed: " . $conn->connect_error);
	}
	
	   if($_SERVER["REQUEST_METHOD"] == "POST") {
      // gebruikersnaam en wachtwoord verzonden vanuit formulier 
        
      $myusername = mysqli_real_escape_string($conn,$_POST['username']);
      $mypassword = mysqli_real_escape_string($conn,$_POST['password']); 
      $sql = "SELECT id FROM admin WHERE username = '$myusername' and password= '$mypassword'";
      $result = mysqli_query($conn,$sql);
      $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
      $active = $row['active'];
      
      $count = mysqli_num_rows($result);
	  // als $myusername en $mypassword overeenkomen, dan moet het rij 1 in de tabel zijn.
	  
      if($count == 1) {
        $_SESSION['login_user'] = $myusername;
        header('Location: analyse.php');
      }else {
         $error = "Your Login Name or Password is invalid";
		 echo "$error";
		 // dit krijg je te zien wanneer je het verkeerde wachtwoord en/of gebruikersnaam invoert.
      }
   }
?>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Corendon - Admin</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Aangepaste lettertypen voor dit template-->
    <link href="fonts/font.ttf"   rel="stylesheet" type="text/css">
    <link href="fonts/font2.ttf"   rel="stylesheet" type="text/css">
    <link href="css/business-casual.css" rel="stylesheet">

  </head>

  <body>

    <div class="tagline-upper text-center text-heading text-shadow text-white mt-5 d-none d-lg-block">Corendon</div>
    <div class="tagline-lower text-center text-expanded text-shadow text-uppercase text-white mb-5 d-none d-lg-block">Admin</div>

    <div class="container">

      <div class="bg-faded p-4 my-4">
        <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0">
          <strong>Admin</strong>
        </h2>
        <hr class="divider">
        <div class="row">
		<!-- login form -->
			<div class="col-md-offset-5 col-md-3 login">
			<form action="admin.php" method="POST">
				<div class="form-login">
					<h4>Login</h4>
					<input type="text" name="username"id="username" class="form-control input-sm chat-input" placeholder="username" />
					</br>
					<input type="password" name="password" id="password" class="form-control input-sm chat-input" placeholder="password" />
					</br>
				<div class="wrapper">
					<span class="group-btn">     
						<input type = "submit" value = " Submit "/><br />
					</span>
				</div>
            </div>
			</form>
        </div>
        </div>
      </div>
    </div>


    <!-- Bootstrap kern JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

  </body>

</html>
