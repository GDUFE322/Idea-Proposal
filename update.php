<?php
  include 'conn.php';
 $phone=str_replace(" ","",$_POST['phone']); $passWord=str_replace(" ","",$_POST['passWord']);//���տͻ��˷�����passWord��
 $username=str_replace(" ","",$_POST['username']); $email=str_replace(" ","",$_POST['email']);//���տͻ��˷�����email��
 $sql="update users set phone='$phone',passWord='$passWord',username='$username',email='$email'";
  $query=mysqli_query($cn,$sql);
  if ($query) echo "success"; else return false;
  mysqli_close($cn);

?>