<?php
 $dbhost = "172.25.198.26:8081";//"172.25.198.26:8081"; 
 $dbuser = "root"; //我的用户名 
 $dbpw = "xin322"; //我的密码 
 $dbname = "studya"; //我的mysql库名 
 $cn = mysqli_connect($dbhost,$dbuser,$dbpw) or die(mysqli_error());
 @mysqli_select_db($cn,$dbname)or die(mysqli_error());
 mysqli_query($cn,"set names utf-8");
 ?>