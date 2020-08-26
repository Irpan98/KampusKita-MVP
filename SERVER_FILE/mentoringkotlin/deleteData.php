<?php
include_once('koneksi.php');

if( !empty($_POST['id'] )){
    $id = $_POST['id'];


    $query = "DELETE FROM  mahasiswa  WHERE id= '$id'";

    $delete = mysqli_query($connect , $query);

 
    if($delete){
        set_response(true, "Success delete Data");
    }
    else{
        set_response(true,"Failed delete Data");
    }


} else{
    set_response(false,"ID tidak bole null");
}



function set_response($isSucces, $message){
    $result = array(
        'isSuccess' => $isSucces,
        'message' => $message,
    );
    echo json_encode($result);
}

?>