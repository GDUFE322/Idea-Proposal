<?php
  include 'conn.php';
 $phone=str_replace(" ","",$_POST['phone']);//接收客户端发来的phone；
$passWord=str_replace(" ","",$_POST['passWord']);//接收客户端发来的passWord；
//$username=str_replace(" ","",$_POST['username']);//接收客户端发来的username；
//$email=str_replace(" ","",$_POST['email']);//接收客户端发来的email；
 $sql="select * from users where phone='$phone'";
 $query=mysqli_query($cn,$sql);
 $result=mysqli_fetch_array($query);
 if(is_array($result)){ echo "用户存在"; }
  else {
	$sql1="insert into users (phone,passWord，username,email) values ('$phone','$passWord','$username','$email')";
	$query1=mysqli_query($cn,$sql1);
 if (!$query1) echo "注册失败"; else echo "成功"; }
 mysqli_close($cn);

?>
