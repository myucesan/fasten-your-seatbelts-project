<?php
	require_once("db.php");
	$conn = new mysqli($dbserver,$dbuser,$dbpass,$dbname);
	// controleer de connectie
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
	$sql = "SELECT * FROM sessie";
	$result= mysqli_query($conn,$sql); 
	$sessies = mysqli_num_rows($result);
	$sql = "SELECT SUM(aantal) FROM sessie";
	$result= mysqli_query($conn,$sql); 
	$row = mysqli_fetch_row($result);
	$fotos = (int)$row[0];
	$gemfotos = $fotos/$sessies;
	$sql = "SELECT SUM(temperatuur) FROM sessie";
	$result = mysqli_query($conn, $sql);
	$row= mysqli_fetch_row($result);
	$temp = (int)$row[0] / $sessies;
	$sql = "select AVG(cast(tijd as time)) from sessie";
	$result = mysqli_query($conn, $sql);
	$row = mysqli_fetch_row($result);
	$tijd = $row[0];
	$tijd1 = substr($tijd,0,2);	
	$tijd2 = substr($tijd,2,2);	
?>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Corendon - Admin</title>

    <!-- Bootstrap kern CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Aangepaste lettertypen voor dit template -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

    <!-- Aangepaste stijlen voor dit template -->
    <link href="css/business-casual.css" rel="stylesheet">

  </head>

  <body>

    <div class="tagline-upper text-center text-heading text-shadow text-white mt-5 d-none d-lg-block">Corendon</div>
    <div class="tagline-lower text-center text-expanded text-shadow text-uppercase text-white mb-5 d-none d-lg-block">Admin</div>

    <div class="container">
	
	  <div class="bg-faded p-4 my-4">
        <div class="row">
			<h4>Opdeze pagina kan je de gemidelde gegevens en verzamel data van photobooth bekijken</h4>
        </div>
      </div>

      <div class="bg-faded p-4 my-4">
        <div class="row">
		<!-- hier is de informatie voor de admin pagina -->
		
		
        <html>
        <head>
	        <style>
	        table, th, td {
		        border: 1px solid black;
		        text-align: center;
	            }
	        th{
	        	text-align: center;
	            }
        	</style>
        </head>
        <body>
		
			<table style="width:100%">
			  <tr>
				<th>Aatnal Sessie's</th> 
				<th>Aantal Foto's</th>
				<th>Gemmideld aantal<br> foto's per sessie</th>
				<th>Gemmidelde tempratuur</th>
				<th>Gemmideld tijdstip <br>voor genomen foto's </th>
			  </tr>
			  <tr>
			    <td><?php echo $sessies;?></td>
			    <td><?php echo $fotos;?></td>
			    <td><?php echo $gemfotos;?></td>
			    <td><?php echo (int)$temp;?></td>
			    <td><?php echo $tijd1;?>:<?php echo $tijd2;?></td>
			  </tr>
			</table>
        </div>
      </div>
	  <a href="logout.php" class="logout" >
			logout
	  </a>
	  
	  
    </div>

    <!-- Bootstrap kern JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

  </body>

</html>
