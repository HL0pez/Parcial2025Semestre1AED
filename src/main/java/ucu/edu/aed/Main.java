package ucu.edu.aed;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import ucu.edu.aed.modelo.Pelicula;
import ucu.edu.aed.sistema.GestionPeliculas;
import ucu.edu.aed.tda.implementaciones.ListaEnlazada;

public class Main {
    public static void main(String[] args) {
        GestionPeliculas gestionPeliculas = new GestionPeliculas();
        registrarTxt("src/main/java/ucu/edu/Pelis.txt", gestionPeliculas);
        escribirTxt("src/main/java/ucu/edu/Sci-Fi.txt", gestionPeliculas.buscar("Sci-Fi"));
        escribirTxt("src/main/java/ucu/edu/ScoreMinimo8.txt", gestionPeliculas.buscar(8.0, true));
        escribirTxt("src/main/java/ucu/edu/ScoreMaximo8.1.txt", gestionPeliculas.buscar(8.1, false));
        escribirTxt("src/main/java/ucu/edu/ScoreEntre7.2Y8.txt", gestionPeliculas.buscar(7.2,8));

       /*
        System.out.println("=============Genero Sci-Fi==============");
        ListaEnlazada<Pelicula> generoPeliculas = gestionPeliculas.buscar("Sci-Fi");
        int i = 0;
        while (i < generoPeliculas.tamaño()) {
          System.out.println(generoPeliculas.obtener(i).getTitulo());
          i++;
        }
        
        System.out.println("=============Minimo score 8==============");
        ListaEnlazada<Pelicula> scoreMinimoPeliculas = gestionPeliculas.buscar(8.0, true);
        i = 0;
        while (i < scoreMinimoPeliculas.tamaño()) {
          System.out.println(scoreMinimoPeliculas.obtener(i).getTitulo());
          i++;
        }

        System.out.println("=============Máximo score 8==============");
        ListaEnlazada<Pelicula> scoreMaximoPeliculas = gestionPeliculas.buscar(8.1, false);
        i = 0;
        while (i < scoreMaximoPeliculas.tamaño()) {
          System.out.println(scoreMaximoPeliculas.obtener(i).getTitulo());
          i++;
        }

        System.out.println("=============Score ente 7.2 y 8==============");
        ListaEnlazada<Pelicula> scoreMinMaxPeliculas = gestionPeliculas.buscar(7.2,8);
        i = 0;
        while (i < scoreMinMaxPeliculas.tamaño()) {
          System.out.println(scoreMinMaxPeliculas.obtener(i).getTitulo());
          i++;
        }
        */
    }

    public static void registrarTxt(String path, GestionPeliculas gestionPeliculas) {
        try (BufferedReader entrada = new BufferedReader(new FileReader(path))) {
            String linea;
            while ((linea = entrada.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length >= 4) {
                    int anio = Integer.parseInt(partes[0].trim());
                    String titulo = partes[1].trim();
                    String genero = partes[2].trim();
                    double score = Double.parseDouble(partes[3].trim());
                    Pelicula pelicula = new Pelicula(anio, titulo, genero, score);
                    gestionPeliculas.registrarPelicula(pelicula);
                }
            }
            entrada.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void escribirTxt(String path, ListaEnlazada<Pelicula> peliculas){
        try (BufferedWriter salida = new BufferedWriter(new FileWriter(path))){
            
            int i = 0;
            while (i < peliculas.tamaño()) {
                salida.write(peliculas.obtener(i).getTitulo());
                salida.newLine();
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
