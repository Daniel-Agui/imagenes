package mx.edu.utez.imagenes.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import mx.edu.utez.imagenes.dao.ImagenDao;
import mx.edu.utez.imagenes.model.Imagen;

import java.io.IOException;
import java.io.InputStream;

@WebServlet(name="GuardarImagenServlet", value = "/addImagen")
@MultipartConfig(maxFileSize = 16177215) // 16MB
public class GuardarImagenServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        InputStream inputStream = null; // Input stream de la imagen

        // Obtiene la imagen desde el formulario
        Part filePart = request.getPart("imagen");
        if (filePart != null) {
            // Debugging para mostrar info de la imagen
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            inputStream = filePart.getInputStream();
        }

        ImagenDao imagenDao = new ImagenDao();
        // Crea objeto Imagen
        Imagen imagen = new Imagen();
        imagen.setImg(inputStream);

        // Inserta la imagen en la base de datos
        try {
            imagenDao.insertarImagen(imagen);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("imagenes.jsp");
    }



}
