package mx.edu.utez.imagenes.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.imagenes.dao.ImagenDao;
import mx.edu.utez.imagenes.model.Imagen;
import mx.edu.utez.imagenes.utils.DatabaseConnectionManager;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="MostrarImagenesServlet", value = "/mostrarImagen")
public class MostrarImagenesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String query = "SELECT img FROM imagenes WHERE id_img = ?";

        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                byte[] imgBytes = resultSet.getBytes("img");
                response.setContentType("image/jpeg");
                OutputStream outputStream = response.getOutputStream();
                outputStream.write(imgBytes);
                outputStream.flush();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
