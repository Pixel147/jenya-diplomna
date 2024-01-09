package com.project.spring.controller;

import com.project.spring.converter.BaseConverter;
import com.project.spring.service.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class BaseController<Entity, IdType, Request, Response> {
    public abstract BaseService<Entity, IdType> getService();

    public abstract BaseConverter<Entity, Request, Response> getConverter();

    @GetMapping("/{id}")
    public ResponseEntity<Response> get(@PathVariable IdType id) {
        return ResponseEntity.ok(getConverter().entityToResponse(getService().findById(id)));
    }

    @GetMapping
    public ResponseEntity<Iterable<Response>> get() {
        return ResponseEntity.ok(getConverter().entityToResponse(getService().getAll()));
    }

    @PostMapping
    public ResponseEntity<Response> save(@RequestBody Request request) {
        Entity entity = getConverter().requestToEntity(request);
        entity = getService().save(entity);
        Response response = getConverter().entityToResponse(entity);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@RequestParam IdType id, @RequestBody Request request) {
        Entity entity = getService().findById(id);
        if (entity == null) {
            return ResponseEntity.notFound().build();
        }
        entity = getConverter().requestToEntity(request);
        entity = getService().save(entity);
        Response response = getConverter().entityToResponse(entity);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable IdType id) {
        getService().deleteById(id);
        return ResponseEntity.ok().build();
    }
}