<%-- 
    Document   : principal
    Created on : 21/04/2017, 08:36:00 AM
    Author     : Gerardo Emmanuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%

HttpSession sessionAlgo = request.getSession();
String idUsr = "0";

if(sessionAlgo.getAttribute("idUsr") != null){

idUsr = (String) sessionAlgo.getAttribute("idUsr").toString();

}

controlador.cUsuario xPer = new controlador.cUsuario(Integer.parseInt(idUsr));
if(!xPer.validaUsr()){
    response.sendRedirect(".");
}


%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
