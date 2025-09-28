package com.ifood.repository;

import java.util.List;

public interface CrudRepository<T> {
    void add(T entity);
    void remove(int id);
    void update(int id, T newEntity);
    T findById(int id);
    List<T> findAll();
}
