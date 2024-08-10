package mx.edu.utez.imagenes.model;

import java.io.InputStream;

public class Imagen {
    private int id_img;
    private InputStream img;

    public Imagen() {}

    public Imagen(int id_img, InputStream img) {
        this.id_img = id_img;
        this.img = img;
    }

    public int getId_img() {
        return id_img;
    }
    public void setId_img(int id_img) {
        this.id_img = id_img;
    }
    public InputStream getImg() {
        return img;
    }
    public void setImg(InputStream img) {
        this.img = img;
    }
}
