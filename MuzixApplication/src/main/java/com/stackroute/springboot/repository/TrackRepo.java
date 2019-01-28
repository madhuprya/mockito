package com.stackroute.springboot.repository;

import com.stackroute.springboot.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface TrackRepo extends MongoRepository<Track,Integer> {

    public Track findBytName(String name);

}
