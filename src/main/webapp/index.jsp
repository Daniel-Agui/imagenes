<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form method="post" action="addImagen" enctype="multipart/form-data">

    <label for="imagen">Seleccione la Imagen:</label>
    <input type="file" name="imagen" id="imagen" accept="image/*" required><br><br>

    <input type="submit" value="Subir Imagen">
</form>
<br>
<a href="imagenes.jsp">Ver imagenes</a>
</body>
</html>