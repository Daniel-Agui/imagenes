<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Subir Imágenes</title>
    <script>
        function mostrarNombresArchivos() {
            var input = document.getElementById('imagenes');
            var listaArchivos = document.getElementById('listaArchivos');
            listaArchivos.innerHTML = '';

            for (var i = 0; i < input.files.length; i++) {
                var li = document.createElement('li');
                li.textContent = input.files[i].name;
                listaArchivos.appendChild(li);
            }
        }
    </script>
</head>
<body>
<h2>Subir Imágenes</h2>
<form method="post" action="addImagen" enctype="multipart/form-data">

    <label for="imagenes">Seleccione las Imágenes:</label>
    <input type="file" name="imagenes[]" id="imagenes" accept="image/*" multiple required onchange="mostrarNombresArchivos()"><br><br>
    <ul id="listaArchivos">
    </ul>

    <input type="submit" value="Subir Imágenes">
</form>
<br>

<a href="imagenes.jsp">Ver imágenes</a>
</body>
</html>
