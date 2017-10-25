<?php
   include('db.php');
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
      header("location:login.php");
   }
?>