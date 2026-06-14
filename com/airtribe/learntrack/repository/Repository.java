package com.airtribe.learntrack.repository;

import java.util.List;

public interface Repository<T, ID> {

    void add(T entity);

    void update(T entity);

    void removeById(ID id);

    T searchById(ID id);

    
    List<T> listAll();
}
