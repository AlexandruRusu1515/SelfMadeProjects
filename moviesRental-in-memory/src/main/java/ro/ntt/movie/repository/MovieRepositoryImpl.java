package ro.ntt.movie.repository;

import ro.ntt.movie.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepositoryImpl implements RepositoryInterface<Movie, Long> {

    private final List<Movie> movieList = new ArrayList<>();



    @Override
    public void save(Movie movie) {
//        if (movie == null) {
//            throw new IllegalArgumentException("Filmul nu poate fi nul!")
//        }
        movieList.add(movie);
    }

    @Override
    public Movie findById(Long id) {
        return movieList.stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Movie> findAll() {
        return new ArrayList<>(movieList);
    }

    @Override
    public Movie delete(Long id) {
        Movie movie = findById(id);
        if (movie != null) {
            movieList.remove(movie);
        }
        return movie;
    }
}
