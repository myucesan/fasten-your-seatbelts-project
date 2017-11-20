<?php
/*
Gemaakt door: Alfred Espinosa Encarnación
Vanuit de ../gallery/index.php wordt een url doorgegeven van de foto editor.
Met dat url wordt de foto opgehaald en opgeslagen in de directory images.
De foto krijgt de naam van het id waar de originele foto vandaan komt.
Als de proces is afgerond wordt deze pagina doormiddel van een script automatisch afgesloten.

*/
		echo $_GET['name'] . "<br>";
		echo $_GET['id'];
		//Get the file
		$url = $_GET['name'];
		$fileName = $_GET['id'];
		$content = file_get_contents($_GET['name']);
		//Store in the filesystem.
		$fp = fopen("images/".$fileName.".jpg", "w");
		fwrite($fp, $content);
		fclose($fp);
		$File = $fileName . ".jpg";

		echo "<script>window.close();</script>";

		?>
