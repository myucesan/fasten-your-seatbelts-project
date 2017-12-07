
<?php
/*
Gemaakt door Alfred Espinosa Encarnación
Deze code laad alle foto's uit de map images. Vervolgens wordt er voor elke foto met de database gecontroleerd,
als de foto als opgeslagen is. Bestaat de foto nog niet in de database, dan zal het opgeslagen worden.

Voordat de foto opgeslagen wordt, wordt er eerst een code gegenereed en worden de bijhorende gegevens vastgelegd.

*/
require_once("db.php");

$conn = new mysqli($dbserver, $dbuser, $dbpass, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$directory = 'images/';
$scanned_directory = array_diff(scandir($directory), array('..', '.'));
$files1 = $scanned_directory;

$createCode = true;
$aantal = 1;
foreach($files1 as $file){

    $sql = "SELECT path FROM foto WHERE path = 'images/$file'";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        while($row = $result->fetch_assoc()) {
            //echo $row['path'] . "<br>";
        }
    }else{

        if($createCode){
            $code = randomString();
            $createCode = false;
        }
        echo $code;
        $sql = "SELECT id FROM sessie WHERE code = '$code'";
        $result = $conn->query($sql);

        if ($result->num_rows <= 0) {
            $currentDT = date("Y-m-d H:i:s");

            $sql = "INSERT INTO sessie (code, locatie, temperatuur, aantal, tijd) VALUES ('$code','Amsterdam',15,$aantal,'$currentDT')";
            $result = $conn->query($sql);

            $last_id = $conn->insert_id;

            insertFoto($last_id, $file, $conn);

        }else{
            $aantal++;
            insertFoto($last_id, $file, $conn);

            $sql = "UPDATE sessie SET aantal = $aantal WHERE id = $last_id";
            $result = $conn->query($sql);

            echo "new record added";
        }

    }


}

function insertFoto($last_id, $file, $conn){
    $sql = "INSERT INTO foto (sessieID, path) VALUES ('$last_id','images/$file')";
    $result = $conn->query($sql);
    echo "new record added sessie";
}

function randomString($length = 6) {
    $str = "";
    $characters = array_merge(range('A','Z'), range('a','z'), range('0','9'));
    $max = count($characters) - 1;
    for ($i = 0; $i < $length; $i++) {
        $rand = mt_rand(0, $max);
        $str .= $characters[$rand];
    }
    return $str;
}


?>
