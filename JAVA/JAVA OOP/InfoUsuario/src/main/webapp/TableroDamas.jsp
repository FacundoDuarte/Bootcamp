<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Tablero damas</h1>

	<%
	String ancho = request.getParameter("width") != null ? request.getParameter("width"):"2" ;
	String altura = request.getParameter("height") != null ? request.getParameter("height"):"2" ;
%>

	<%!
	public String obtenColor(int color1, int color2){
	if(color1%2 == 0){
		return color2%2 == 0 ? "black":"red";
			}
		return color2%2 == 0 ? "red":"black";
		}
	%>

</body>
</html>