package com.example.toonun_ma.models;

public class ComicInput {

    private String nombre;
    private String autor;
    private String fecha;
    private String[] etiquetas ;
    private String archivo;
    private String imagen;
    private String descripcion;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String[] getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(String[] etiquetas) {
        this.etiquetas = etiquetas;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
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


    public ComicInput(String nombre, String autor, String fecha, String[] etiquetas, String archivo, String imagen, String descripcion) {
        this.nombre = nombre;
        this.autor = autor;
        this.fecha = fecha;
        this.etiquetas = etiquetas;
        this.archivo = archivo;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

    public ComicInput() {

    }
}
