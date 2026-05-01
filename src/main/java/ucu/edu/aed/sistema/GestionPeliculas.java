package ucu.edu.aed.sistema;

import ucu.edu.aed.modelo.Pelicula;
import ucu.edu.aed.tda.implementaciones.AVLArbol;
import ucu.edu.aed.tda.implementaciones.ListaEnlazada;

public class GestionPeliculas {

    AVLArbol<Pelicula> peliculas;

    public GestionPeliculas(){
        peliculas = new AVLArbol<>();
    }

    public boolean registrarPelicula(Pelicula pelicula){
        return peliculas.insertar(pelicula);
    }

    public ListaEnlazada<Pelicula> buscar(String genero){
        ListaEnlazada<Pelicula> resultadoPeliculas = new ListaEnlazada<>();
        
        peliculas.preOrder(pelicula -> {
            if (pelicula.getGenero().equals(genero)) {
                resultadoPeliculas.agregar(pelicula);
            }
        });

        ListaEnlazada<Pelicula> listaOrdenada = (ListaEnlazada<Pelicula>) resultadoPeliculas.ordenar((a, b) -> a.getTitulo().compareTo(b.getTitulo()));
        
        if (resultadoPeliculas.tamaño() != 0) {
            return listaOrdenada;
        }
        return null;
    }

    public ListaEnlazada<Pelicula> buscar(double score, boolean esMinimo){
        ListaEnlazada<Pelicula> resultadoPeliculas = new ListaEnlazada<>();
        
        if (esMinimo) {
            peliculas.preOrder(pelicula -> {
            if (score <= pelicula.getScore()) {
                resultadoPeliculas.agregar(pelicula);
            }
            });
        }else{
            peliculas.preOrder(pelicula -> {
            if (score >= pelicula.getScore()) {
                resultadoPeliculas.agregar(pelicula);
            }
            });
        }

        ListaEnlazada<Pelicula> listaOrdenada = (ListaEnlazada<Pelicula>) resultadoPeliculas.ordenar((a, b) -> Double.compare(a.getScore(), b.getScore()));

        if (resultadoPeliculas.tamaño() != 0) {
            return listaOrdenada;
        }

        return null;
    }

    public ListaEnlazada<Pelicula> buscar(double scoreMinimo, double scoreMaximo){
        ListaEnlazada<Pelicula> resultadoPeliculas = new ListaEnlazada<>();
        
        peliculas.preOrder(pelicula -> {
            if (pelicula.getScore() >= scoreMinimo && pelicula.getScore() <= scoreMaximo) {
                resultadoPeliculas.agregar(pelicula);
            }
        });

        ListaEnlazada<Pelicula> listaOrdenada = (ListaEnlazada<Pelicula>) resultadoPeliculas.ordenar((a, b) -> Double.compare(a.getScore(), b.getScore()));

        if (resultadoPeliculas.tamaño() != 0) {
            return listaOrdenada;
        }
        return null;
    }

    
}
