package mx.edu.utez.imagenes.dao;

import mx.edu.utez.imagenes.model.Imagen;
import mx.edu.utez.imagenes.utils.DatabaseConnectionManager;

import java.awt.*;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImagenDao {

    private static final String SELECT_ALL_IMAGES = "SELECT * FROM imagenes";

    public void insertarImagen(Imagen imagen) {
        String sql = "INSERT INTO imagenes (img) VALUES (?)";

        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setBlob(1, imagen.getImg());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Imagen> seleccionarImagenes() throws SQLException {
        List<Imagen> imagenes = new ArrayList<>();
        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_IMAGES)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Imagen imagen = new Imagen();
                imagen.setId_img(rs.getInt("id_img"));
                // Aquí no se recupera el InputStream porque generalmente no se necesita para mostrar lista
                imagenes.add(imagen);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imagenes;
    }
}
