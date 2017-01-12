package com.ftech.repository;

import org.springframework.data.repository.CrudRepository;

import com.ftech.model.Musica;

public interface MusicaMongoRepository extends CrudRepository<Musica, String>{}


