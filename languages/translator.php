<?php
	// include language configuration file based on selected language
	session_start();
	// $_SESSION["lang"] = "en";
	// $lang = "en";
	if(isset($_GET['lang'])){
		$_SESSION["lang"] = $_GET['lang'];
	}else{
		$_SESSION["lang"] = "en";
	}
	require_once("languages/lang.".$_SESSION["lang"].".php");
?>
