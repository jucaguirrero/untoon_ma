package com.example.toonun_ma.models;

public class Comic {
    private long idcomic;
    private String Nombre;
    private String Autor;
    private String Fecha;
    private String Direccion;
    private String[] etiquetas ;

    private String pdf;
    private String imagen;
    private String descripcion;


    public long getIdcomic() {
        return idcomic;
    }

    public void setIdcomic(long idcomic) {
        this.idcomic = idcomic;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String[] getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(String[] etiquetas) {
        this.etiquetas = etiquetas;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Comic(long idcomic, String nombre, String autor, String fecha, String direccion, String[] etiquetas, String pdf, String imagen, String descripcion) {
        this.idcomic = idcomic;
        Nombre = nombre;
        Autor = autor;
        Fecha = fecha;
        Direccion = direccion;
        this.etiquetas = etiquetas;
        this.pdf = pdf;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

    public Comic() {
    }
}
