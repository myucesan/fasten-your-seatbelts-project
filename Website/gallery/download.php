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
		

		echo getcwd();
		$path = getcwd() . "/images/".$fileName."";

		
		$file = $path;
		if (!unlink($file))
		  {
		  echo ("<br>Error deleting $file");
		  }
		else
		  {
		  echo ("<br>Deleted $file");
		  }
		
		if(!file_exists($path)){
			
			$fp = fopen($path, "w");
			
			if($fp){
				echo "<br>file pointer is ok";
				
				$data = $content;
				
				fwrite($fp, $data);
				
				fclose($fp);
				
				echo "<br> the file has been written.";
			}
			
		}
		
		
		echo "<img id='editableimage' src='../gallery/images/".$fileName."' />";
		
		//echo "<script>window.close();</script>";

		?>
