package com.ftech.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ftech.model.Musica;

@Repository
public class MusicaSearchRepository {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public Collection<Musica> buscaMusicas(String text) {
		return mongoTemplate.find(Query.query(new Criteria()
						.orOperator(Criteria.where("banda").regex(text, "i"), 
									Criteria.where("nome").regex(text, "i"), 
									Criteria.where("letra").regex(text, "i"))
						), Musica.class);
	}
	
	
}
