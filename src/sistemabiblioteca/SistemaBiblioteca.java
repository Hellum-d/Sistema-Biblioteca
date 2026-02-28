/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemabiblioteca;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class SistemaBiblioteca {
    private String isbn;
    private String titulo;
    private String autor;
    private String genero;
    private int anioPublicacion;
    private boolean disponible;
    
    static ArrayList <SistemaBiblioteca> libros = new ArrayList<>();

    public static void main(String[] args) {
       int opcion;
        do {            
            opcion=Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion: "
                    + "1. Agregar Libro"+"Mostrar Libros"+ "Buscar libros"+"Eliminar libros"+"Salir"));
            
            switch (opcion) {
                case 1:
                    crearLibro();
                    break;
                case 2:
                    
                default:
                    throw new AssertionError();
            }
        } while (opcion !=5);
    }

    public SistemaBiblioteca(String isbn, String titulo, String autor, String genero, int anioPublicacion, boolean disponible) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anioPublicacion = anioPublicacion;
        this.disponible = disponible;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    public static void crearLibro() {
        String isbn    = JOptionPane.showInputDialog("ISBN:");
        String titulo  = JOptionPane.showInputDialog("Título:");
        String autor   = JOptionPane.showInputDialog("Autor:");
        String genero  = JOptionPane.showInputDialog("Género:");
        int anio       = Integer.parseInt(JOptionPane.showInputDialog("Año de publicación:"));
        boolean disp   = JOptionPane.showInputDialog("¿Disponible? (si/no)").equalsIgnoreCase("si");

        SistemaBiblioteca libro = new SistemaBiblioteca(isbn, titulo, autor, genero, anio, disp);
        libros.add(libro);
        JOptionPane.showMessageDialog(null, "¡Libro agregado correctamente!");
    }
    
    
    public static void eliminarLibro(){
        boolean eliminado=false;
        String ISBN=JOptionPane.showInputDialog(null, "Ingrese el ISBN que desea eliminar");
        for (SistemaBiblioteca l : libros) {
            if(l.getIsbn().equals(ISBN)){
                libros.remove(l);
                eliminado=true;
                break;
            }
            
  
        }
        
        if(eliminado==true){
            JOptionPane.showMessageDialog(null, "Libro eliminado");
        } else{
            JOptionPane.showMessageDialog(null, "ISBN no encontrada");
        }
    }

    public static void modificarLibro(){
        boolean encontrado = false;
        String isbn=JOptionPane.showInputDialog("Ingrese el ISBN que desea modificar");
        for (SistemaBiblioteca l : libros) {
            if(l.getIsbn().equals(isbn)){
                l.setTitulo(JOptionPane.showInputDialog("Ingrese el nuevo titulo: "));
                l.setAutor(JOptionPane.showInputDialog("Ingrese el nombre del autor"));
                l.setAnioPublicacion(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de publicacion: ")));
                l.setGenero(JOptionPane.showInputDialog(null, "Ingrese el nuevo genero del libro: "));
                l.setDisponible(JOptionPane.showInputDialog("Encontrado (si/no)").equalsIgnoreCase("Si"));
                
                encontrado=true;
                break;
                        
            }
            
        }
        
        if(encontrado==true){
            JOptionPane.showMessageDialog(null, "Libro modificado");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el ISBN");
        }
    }
    
    public static void buscarLibro(){
        String isbn1 = JOptionPane.showInputDialog("Ingrese el ISBN que desea eliminar: ");
            for (SistemaBiblioteca l: libros) {
            if(l.getIsbn().equals(isbn1)){
            JOptionPane.showMessageDialog(null, "Encontrado: "+l.getTitulo()+l.getAutor()+l.getGenero());
            } else{
            JOptionPane.showMessageDialog(null, "Libro no wncontrado");
            }
        }
    }
            
            public static void mostrarLibros(){
                
                if(libros.isEmpty()){
                JOptionPane.showMessageDialog(null, "No hay libros registrados");
                }
                StringBuilder sb = new StringBuilder();
                for (SistemaBiblioteca l : libros) {
                    sb.append("TITULO:").append(l.getTitulo());
                    sb.append("Nombre del autor").append(l.getAutor());
                    sb.append("ISBN").append(l.isbn);
                    sb.append("Año de publicación: ").append(l.getAnioPublicacion());
                    sb.append("Genero").append(l.getGenero());
                }
                
                JOptionPane.showMessageDialog(null, sb.toString());
            }
                    
    }


    
    

