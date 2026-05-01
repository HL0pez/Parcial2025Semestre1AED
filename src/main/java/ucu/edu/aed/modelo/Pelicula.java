package ucu.edu.aed.modelo;

public class Pelicula implements Comparable<Pelicula> {
    
    public int anioLanzamiento;
    public String titulo;
    public String genero;
    public double score;

    public Pelicula(int anioLanzamiento, String titulo, String genero, double score){
        this.anioLanzamiento = anioLanzamiento;
        this.titulo = titulo;
        this.genero = genero;
        this.score = score;
    }

    @Override
    public int compareTo(Pelicula otra) {
        return this.titulo.compareTo(otra.titulo);
    }

    public String toString(){
        return this.titulo;
    }

    public String getGenero(){
        return this.genero;
    }

    public double getScore() {
        return this.score;
    }

    public String getTitulo() {
        return this.titulo;
    }


}
