package com.project.spring.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class BaseService<T, IdType> {
    public abstract JpaRepository<T, IdType> getRepository();

    public List<T> getAll() {
        return getRepository().findAll();
    }

    public T save(T entity) {
        return getRepository().save(entity);
    }

    public void delete(T entity) {
        getRepository().delete(entity);
    }

    public void deleteById(IdType id) {
        getRepository().deleteById(id);
    }

    public T findById(IdType id) {
        return getRepository().findById(id).orElse(null);
    }
}
