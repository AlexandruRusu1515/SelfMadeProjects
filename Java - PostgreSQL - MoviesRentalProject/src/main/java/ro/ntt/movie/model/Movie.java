package ro.ntt.movie.model;

import java.util.Objects;

public class Movie extends BaseEntity<Long>{
    private String name;
    private String genre;
    private int year;
    private int rating;

    //aici am pus toti parametrii, asa trebuie in constructor
    public Movie(Long id, String name, String genre, int year,int rating){
        super(id);
        this.name=name;
        this.genre=genre;
        this.year=year;
        this.rating=rating;
    }

    public String getName(){
        return name;
    }
    public String getGenre(){
        return genre;
    }
    public int getYear (){
        return year;
    }
    public int getRating(){
        return rating;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setGenre(String genre){
        this.genre=genre;
    }
    public void setYear(int year){
        this.year=year;
    }
    public void setRating(int rating){
        this.rating=rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return year == movie.year && rating == movie.rating && Objects.equals(name, movie.name) && Objects.equals(genre, movie.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, genre, year, rating);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }
}
