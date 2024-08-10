<%@ page import="mx.edu.utez.imagenes.model.Imagen" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="java.util.Base64" %>
<%@ page import="mx.edu.utez.imagenes.dao.ImagenDao" %><%--
  Created by IntelliJ IDEA.
  User: dan-a
  Date: 07/08/2024
  Time: 08:56 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mostrar Imágenes</title>
    <style>
        .image-container {
            display: flex;
            flex-wrap: wrap;
        }
        .image-box {
            margin: 10px;
        }
        .image-box img {
            max-width: 200px;
            max-height: 200px;
        }
    </style>
</head>
<body>
<h2>Lista de Imágenes</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nombre de la Imagen</th>
        <th>Imagen</th>
    </tr>
    <%
        ImagenDao imagenDAO = new ImagenDao();
        List<Imagen> listaImagenes = null;
        try {
            listaImagenes = imagenDAO.seleccionarImagenes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (listaImagenes != null) {
            for (Imagen imagen : listaImagenes) {
    %>
    <tr>
        <td><%= imagen.getId_img() %></td>
        <td><img src="mostrarImagen?id=<%= imagen.getId_img() %>" width="400" height="400"></td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
