package com.hackathon.iplbidding.repository;

import com.hackathon.iplbidding.domain.Bidder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidderRepository extends MongoRepository<Bidder, String> {
}
