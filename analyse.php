<?php
	require_once("db.php");
	$conn = new mysqli($dbserver,$dbuser,$dbpass,$dbname);
	// check conection
	if ($conn->connect_error){
		 die("connection failed: " . $conn->connect_error);
	} 
	session_start();
   
   $user_check = $_SESSION['login_user'];
   
   $ses_sql = mysqli_query($conn,"select username from admin where username = '$user_check' ");
   
   $row = mysqli_fetch_array($ses_sql,MYSQLI_ASSOC);
   
   $login_session = $row['username'];
   
   if(!isset($_SESSION['login_user'])){
      header("location:admin.php");
   }
	$sql = "SELECT FROM sessie";
	$result = mysqli_query($conn, $sql);
	$iets= mysqli_fetch_assoc($result);
	$sessies = $iets['value_sum'];
	$sql = "SELECT SUM(aantal) FROM sessie";
	$fotos = mysqli_query($conn, $sql);
	$gemfotos = fotos/sessies;
	$sql = "SELECT SUM(tempratuur) FROM sessie";
	$temp = mysqli_query($conn, $sql);
	$temp = $temp / $sessies;
	$sql = "select AVG(cast(tijd as time)) from sessie";
	$tijd = mysqli_query($conn, $sql);
	$tijd1 = substr($tijd,0,1);	
	$tijd2 = substr($tijd,2,3);	
	echo var_dump($sessies);
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

    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="css/business-casual.css" rel="stylesheet">

  </head>

  <body>

    <div class="tagline-upper text-center text-heading text-shadow text-white mt-5 d-none d-lg-block">Corendon</div>
    <div class="tagline-lower text-center text-expanded text-shadow text-uppercase text-white mb-5 d-none d-lg-block">Admin</div>

    <div class="container">

      <div class="bg-faded p-4 my-4">
        <div class="row">
		<!-- tabel -->
			<table class="tabel">
			  <tr>
				<th>Aantal Foto's</th>
				<th>Aatnal Sessie's</th> 
				<th>Gemmidelde tijdstip</th>
				<th>Gemmidelde tempratuur</th>
				<th>Gemmidelde aantal foto's per sessie</th>
			  </tr>
			  <tr>
			    <td><?php echo $sessies;?></td>
			    <td></td>
			    <td></td>
			    <td></td>
			    <td></td>
			  </tr>
			</table>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

  </body>

</html>
