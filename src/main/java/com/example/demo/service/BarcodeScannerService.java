package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.demo.model.Flight;


@Service
public class BarcodeScannerService {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public String createFlightId(String flightId) {
		
		Flight flight = mongoTemplate.findAndModify(
        		new Query(Criteria.where("_id").is(flightId)),
                new Update().set("_id", flightId),
                new FindAndModifyOptions().returnNew(true).upsert(true),
                Flight.class);
    	
		return flight.get_id();
	}
}
