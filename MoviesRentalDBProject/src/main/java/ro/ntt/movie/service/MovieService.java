package ro.ntt.movie.service;

import ro.ntt.movie.model.Movie;
import ro.ntt.movie.repository.RepositoryInterface;
import java.util.List;
import java.util.stream.Collectors;


public class MovieService implements ServiceInterface <Movie, Long> {

    private final RepositoryInterface<Movie, Long> movieRepository;

    public MovieService(RepositoryInterface<Movie, Long> movieRepositoryDB) {
        this.movieRepository = movieRepositoryDB;
    }

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id);

    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();

    }

    @Override
    public Movie delete(Long id) {
        return movieRepository.delete(id);
    }
//    public void loadMovie(){
//        movieRepository.save(new Movie(1L,"Frozen2", "Animation",2017, 5));
//        movieRepository.save(new Movie(2L,"The Substance", "Horror",2025, 3));
//        movieRepository.save(new Movie(3L,"Harry Potter", "Fiction",2013, 4));
//        movieRepository.save(new Movie(4L,"Pets", "Animation",2016, 5));
//    }
//
//    public List<Movie> findByGenre(String genre){
//        return movieRepository.findAll()
//                .stream()
//                .filter(movie -> movie.getGenre().contains("Animation"))
//                .collect(Collectors.toList());
//    }
}
