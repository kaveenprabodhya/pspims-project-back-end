package com.al.exports.pspims.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudService<T, ID> {
    Page<T> findAll(Pageable pageable);

    T findById(ID id);

    T create(T object);

    T update(ID id, T object);

    T patch(ID id, T object);

    void deleteById(ID id);
}
