<?php
  include 'conn.php';
 $phone=str_replace(" ","",$_POST['phone']);//���տͻ��˷�����phone��
$passWord=str_replace(" ","",$_POST['passWord']);//���տͻ��˷�����passWord��
//$username=str_replace(" ","",$_POST['username']);//���տͻ��˷�����username��
//$email=str_replace(" ","",$_POST['email']);//���տͻ��˷�����email��
 $sql="select * from users where phone='$phone'";
 $query=mysqli_query($cn,$sql);
 $result=mysqli_fetch_array($query);
 if(is_array($result)){ echo "�û�����"; }
  else {
	$sql1="insert into users (phone,passWord��username,email) values ('$phone','$passWord','$username','$email')";
	$query1=mysqli_query($cn,$sql1);
 if (!$query1) echo "ע��ʧ��"; else echo "�ɹ�"; }
 mysqli_close($cn);

?>
