package ro.ntt.movie.service;

import java.util.List;

public interface ServiceInterface <T, ID> {

    void save (T entity);

    T findById (ID id);

    List<T> findAll();

    T delete (ID id);

}
