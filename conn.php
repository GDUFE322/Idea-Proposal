<?php
 $dbhost = "172.25.198.26:8081";//"172.25.198.26:8081"; 
 $dbuser = "root"; //�ҵ��û��� 
 $dbpw = "xin322"; //�ҵ����� 
 $dbname = "studya"; //�ҵ�mysql���� 
 $cn = mysqli_connect($dbhost,$dbuser,$dbpw) or die(mysqli_error());
 @mysqli_select_db($cn,$dbname)or die(mysqli_error());
 mysqli_query($cn,"set names utf-8");
 ?>