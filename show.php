<?php
  include 'conn.php';
 $phone=str_replace(" ","",$_POST['phone']);  $sql="select * from users where phone='$phone'";
    $query=mysqli_query($cn, $sql);
    $result=mysqli_fetch_array($query);
    print(json_encode($result));
    mysqli_close($cn);
?>