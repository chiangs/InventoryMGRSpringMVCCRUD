<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Required meta tags always come first -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>View Inventory</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Raleway:500,900|Quicksand" rel="stylesheet">
    <link rel="stylesheet" href="styles/main.css">

    <!-- jQuery -->
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.0.min.js"></script>

    <script>
        // A $( document ).ready() block.
        $(document).ready(function() {
            console.log("ready!");
        });
    </script>
<title>View Inventory</title>
</head>
<body>
<form action="EditProductData.do" method="POST">
<input type="hidden" name="id" />
<input type="text" name="name" />
<input type="text" name="name" />
<input type="text" name="name" />
<input type="text" name="name" />
<input type="submit" value="submit" />

</form>

</body>
</html>
