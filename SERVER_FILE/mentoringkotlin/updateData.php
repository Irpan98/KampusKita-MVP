<?php
include_once('koneksi.php');

if(!empty($_POST['name']) && !empty($_POST['contact'] && !empty($_POST['address'] && !empty($_POST['id'] )))){
    $id = $_POST['id'];
    $name = $_POST['name'];
    $contact = $_POST['contact'];
    $addres = $_POST['address'];

    $query = "UPDATE  mahasiswa SET name = '$name', contact = '$contact', address = '$addres' WHERE id= '$id'";

    $update = mysqli_query($connect , $query);

 
    if($update){
        set_response(true, "Success insert Data");
    }
    else{
        set_response(true,"Failed insert Data");
    }


} else{
    set_response(false,"Nama, nomor HP, dan Alamat harus diisi");
}



function set_response($isSucces, $message){
    $result = array(
        'isSuccess' => $isSucces,
        'message' => $message,
    );
    echo json_encode($result);
}

?>