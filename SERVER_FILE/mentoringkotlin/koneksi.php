<?php
$hostname = "localhost";
$username = "root";
$password = "";
$database = "db_kampus";



$connect = mysqli_connect($hostname, $username,$password, $database);

// if(mysqli_connect_errno()){
//     // echo "Failder connect to Mysql : ".msqli_connect_error();die();
    
// }else{
//     // echo "Success connect to Mysql";
// }
