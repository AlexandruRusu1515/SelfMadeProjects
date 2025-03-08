package ro.ntt.movie.repository;

import java.util.List;

public interface RepositoryInterface<T, ID> {

    void save(T entity);

    T findById(ID id);

    List<T> findAll();

    T delete(ID id);
    
}
